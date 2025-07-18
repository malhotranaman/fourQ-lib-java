package fieldoperations;


import org.jetbrains.annotations.NotNull;
import types.data.Pair;
import constants.Key;
import constants.Params;
import utils.BigIntegerUtils;

import java.math.BigInteger;

/**
 * Finite field arithmetic operations for FourQ over GF(2^127-1).
 * 
 * This class implements arithmetic in the base field GF(p) where p = 2^127-1
 * is a Mersenne prime. The implementation includes:
 * - Montgomery arithmetic for efficient modular operations
 * - Modular addition, subtraction, and multiplication
 * - Scalar reduction and conversion utilities
 * - Optimized operations for the Mersenne prime structure
 * 
 * The PUtil nested interface provides low-level field operations optimized
 * for the specific prime p = 2^127-1.
 * 
 * @author Naman Malhotra, James Hughff
 * @since 1.0
 */
public class FP {
    /**
     * Performs Montgomery multiplication modulo the curve order.
     * <p>
     * Montgomery multiplication allows efficient modular arithmetic by
     * avoiding expensive division operations. This method is essential
     * for scalar arithmetic in signature operations.
     * 
     * @param ma first operand in Montgomery form
     * @param mb second operand in Montgomery form
     * @return the product ma * mb in Montgomery form, reduced modulo curve order
     */
    @NotNull
    public static BigInteger montgomeryMultiplyModOrder(@NotNull BigInteger ma, @NotNull BigInteger mb) {
        BigInteger rma = round256(ma);
        BigInteger rmb = round256(mb);
        BigInteger product = rma.multiply(rmb);

        BigInteger result = BigIntegerUtils.buildBigInteger(product,
                x -> round256(x).multiply(round256(Params.MONTGOMERY_r_PRIME)),
                x -> round256(x).multiply(round256(Params.CURVE_ORDER)),
                x -> product.add(x).shiftRight(256)
        );

        if (result.compareTo(Params.CURVE_ORDER) >= 0) {
            result = result.subtract(Params.CURVE_ORDER);
        }
        return result;
    }

    /**
     * Reduces a value modulo the curve order using Montgomery arithmetic.
     * <p>
     * This method efficiently computes key mod order by using Montgomery
     * multiplication operations, which is faster than standard modular reduction.
     * 
     * @param key the value to reduce modulo the curve order
     * @return key mod order
     */
    @NotNull
    public static BigInteger moduloOrder(@NotNull BigInteger key) {
        BigInteger res = montgomeryMultiplyModOrder(key, Params.MONTGOMERY_R_PRIME);
        return montgomeryMultiplyModOrder(
                res,
                BigInteger.ONE
        );
    }

    // Subtraction modulo the curve order, c = a+b mod order
    @NotNull
    public static BigInteger subtractModOrder(@NotNull BigInteger a, @NotNull BigInteger b) {
        return a.subtract(b).mod(Params.CURVE_ORDER);
    }

    // Addition modulo the curve order, c = a+b mod order
    @NotNull
    public static BigInteger addModOrder(@NotNull BigInteger a, @NotNull BigInteger b) {
        return a.add(b).mod(Params.CURVE_ORDER);
    }

    /**
     * Converts an even scalar to odd by adding the curve order if necessary.
     * <p>
     * Many ECC algorithms require odd scalars for efficiency. Since the curve
     * order is odd, adding it to an even scalar makes it odd without changing
     * the result of scalar multiplication.
     * 
     * @param scalar the scalar to convert
     * @return an odd scalar equivalent to the input modulo the curve order
     */
    @NotNull
    public static BigInteger conversionToOdd(@NotNull BigInteger scalar) {
        if (scalar.testBit(0)) {
            return scalar;  // Already odd
        }

        // Add curve order to make odd
        return scalar.add(Params.CURVE_ORDER);
    }

    /**
     * @param a first argument in multiply
     * @param b second argument in multiply
     * @return a * b
     * @implNote The following assumes that BigInteger performance limitations are negligible.
     */
    @NotNull
    public static BigInteger multiply(@NotNull BigInteger a, @NotNull BigInteger b) {
        return a.multiply(b);
    }

    @NotNull
    public static Pair<BigInteger, Integer> mpAdd(@NotNull BigInteger a, @NotNull BigInteger b) {
        // Add the two numbers
        BigInteger sum = a.add(b);

        // Calculate the maximum value for NWORDS_ORDER words
        // Assuming 32-bit words: max = 2^(NWORDS_ORDER * 32) - 1
        int bitsPerWord = Key.KEY_SIZE;
        int totalBits = Params.NWORDS_ORDER * bitsPerWord;
        BigInteger maxValue = BigInteger.ONE.shiftLeft(totalBits); //First value that cannot be represented in system

        // Check if overflow occurred
        if (sum.compareTo(maxValue) >= 0) {
            // Overflow, return sum mod 2^totalBits, carry = 1
            BigInteger wrappedSum = sum.remainder(maxValue);
            return new Pair<>(wrappedSum, 1);
        } else {
            // No overflow, return sum as-is, carry = 0
            return new Pair<>(sum, 0);
        }
    }

    @NotNull
    public static Pair<BigInteger, Integer> mpSubtract(@NotNull BigInteger a, @NotNull BigInteger b) {
        // For fixed-width arithmetic, handle negative results
        if (a.compareTo(b) >= 0) {
            // No borrow
            return new Pair<>(a.subtract(b), 0);
        }

        // Borrow occurred
        // Simulate fixed-width wraparound: a - b + 2^n
        int totalBits = Params.NWORDS_ORDER * Key.KEY_SIZE;
        BigInteger modulus = BigInteger.ONE.shiftLeft(totalBits), wrappedResult = a.subtract(b).add(modulus);
        return new Pair<>(wrappedResult, 1);
    }

    /**
     * Low-level field arithmetic operations for GF(2^127-1).
     * <p>
     * This interface provides optimized implementations for arithmetic
     * in the Mersenne prime field p = 2^127-1, taking advantage of
     * the special structure of Mersenne primes for faster reductions.
     */
    public interface PUtil {
        // Modular correction, output = a mod (2^127-1)
        @NotNull
        static BigInteger fpMod1271(@NotNull BigInteger a) {
            return a.mod(Params.PRIME_1271);
        }

        // Field multiplication using schoolbook method, c = a*b mod p
        @NotNull
        static BigInteger fpMul1271(@NotNull BigInteger a, @NotNull BigInteger b) {
            return Mersenne.mersenneReduce127(multiply(a, b));
        }

        // Field squaring using schoolbook method, output = a^2 mod p
        @NotNull
        static BigInteger fpSqr1271(@NotNull BigInteger a) {
            return PUtil.fpMul1271(a, a);
        }

        // Field negation, a = -a mod (2^127-1)
        @NotNull
        static BigInteger fpNeg1271(@NotNull BigInteger a) {
            // Ensure input is in valid range first
            a = a.mod(Params.PRIME_1271);

            if (a.equals(BigInteger.ZERO)) {
                return BigInteger.ZERO;
            }
            return Params.PRIME_1271.subtract(a);
        }

        // Field inversion, af = a^-1 = a^(p-2) mod p
        @NotNull
        static BigInteger fpInv1271(@NotNull BigInteger a) {
            return BigIntegerUtils.buildBigInteger(a,
                    FP.PUtil::fpExp1251,
                    FP.PUtil::fpSqr1271,
                    FP.PUtil::fpSqr1271,
                    x -> FP.PUtil.fpMul1271(a, x)
            );
        }

        @NotNull
        static BigInteger fpExp1251(@NotNull BigInteger a) {
            BigInteger exponent = BigInteger.ONE.shiftLeft(125).subtract(BigInteger.ONE);
            return fpModPow1271(a, exponent);
        }

        // Optimized modular exponentiation for 2^127-1
        @NotNull
        static BigInteger fpModPow1271(@NotNull BigInteger base, @NotNull BigInteger exponent) {
            // Use Java's built-in with Mersenne optimization
            BigInteger result = base.modPow(exponent, Params.PRIME_1271);
            return Mersenne.mersenneReduce127(result);
        }

        // Field addition, c = a+b mod (2^127-1)
        @NotNull
        static BigInteger fpAdd1271(@NotNull BigInteger a, @NotNull BigInteger b) {
            BigInteger sum = a.add(b);

            // Quick path: if sum < 2^127, no reduction needed
            if (sum.bitLength() <= 127) {
                return sum.equals(Params.PRIME_1271) ? BigInteger.ZERO : sum;
            }

            // Handle the single overflow case (sum has 128 bits)
            if (sum.bitLength() == 128) {
                // Extract bit 127 and add it back to lower 127 bits
                BigInteger lower127 = sum.and(Params.MASK_127);  // sum & (2^127-1)
                BigInteger overflow = sum.shiftRight(127); // sum >> 127 (will be 1)

                BigInteger result = lower127.add(overflow);
                return result.equals(Params.PRIME_1271) ? BigInteger.ZERO : result;
            }

            // Fallback for unexpected cases (shouldn't happen with valid inputs)
            return Mersenne.mersenneReduce127(sum);
        }

        // Field subtraction, c = a-b mod (2^127-1)
        @NotNull
        static BigInteger fpSub1271(@NotNull BigInteger a, @NotNull BigInteger b) {
            BigInteger diff = a.subtract(b);

            // If result is negative, add the prime to make it positive
            if (diff.signum() < 0) {
                return diff.add(Params.PRIME_1271);
            }

            return diff;
        }

        // Field division by two, output = a/2 mod (2^127-1)
        @NotNull
        static BigInteger fpDiv1271(@NotNull BigInteger a) {
            // If input is odd, add (2^127-1) to make it even before dividing
            // Check if least significant bit is 1 (odd)
            BigInteger dividend = a.testBit(0) ? a.add(Params.PRIME_1271) : a;
            return Mersenne.mersenneReduce127Fast(dividend.shiftRight(1));
        }
    }

    @NotNull
    private static BigInteger round256(@NotNull BigInteger val) {
        return val.mod(BigInteger.ONE.shiftLeft(256));
    }
}
