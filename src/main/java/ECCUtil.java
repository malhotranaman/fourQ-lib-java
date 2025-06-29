import types.AffinePoint;
import types.ExtendedPoint;
import types.F2Element;
import types.FieldPoint;

import java.math.BigInteger;


public class ECCUtil {
    private static final int W_FIXEDBASE = 5;
    private static final int V_FIXEDBASE = 5;
    private static final int D_FIXEDBASE = 54;
    private static final int E_FIXEDBASE = 10;

    private static final F2Element F2_ONE = new F2Element(BigInteger.ONE, BigInteger.ONE);

    static FieldPoint<F2Element> eccMulFixed(BigInteger val) {
        BigInteger temp = FP.moduloOrder(val);
        temp = FP.conversionToOdd(temp);
        int[] digits = mLSBSetRecode(temp);  // TODO: No idea how this works
        int digit = digits[W_FIXEDBASE * D_FIXEDBASE - 1];
        int startI = (W_FIXEDBASE - 1) * D_FIXEDBASE - 1;
        for (int i = startI; i >= 2 * D_FIXEDBASE - 1; i -= D_FIXEDBASE) {
            digit = 2 * digit + digits[i];
        }

        // TODO: Both instances of TABLE in this function might need updating
        AffinePoint<F2Element> affPoint = Table.tableLookupFixedBase(digit, digits[D_FIXEDBASE - 1]);
        ExtendedPoint<F2Element> exPoint = R5_To_R1(affPoint);

        for (int j = 0; j < V_FIXEDBASE - 1; j++) {
            digit = digits[W_FIXEDBASE * D_FIXEDBASE - (j + 1) * E_FIXEDBASE - 1];
            int iStart = (W_FIXEDBASE - 1) * D_FIXEDBASE - (j + 1) * E_FIXEDBASE - 1;
            int iMin = 2 * D_FIXEDBASE - (j + 1) * E_FIXEDBASE - 1;
            for (int i = iStart; i >= iMin; i -= D_FIXEDBASE) {
                digit = 2 * digit + digits[i];
            }
            // Extract point in (x+y,y-x,2dt) representation
            int signDigit = D_FIXEDBASE - (j + 1) * E_FIXEDBASE - 1;
            affPoint = Table.tableLookupFixedBase(digit, digits[signDigit]);
            exPoint = eccMixedAdd(affPoint, exPoint);
        }

        for (int i = E_FIXEDBASE - 2; i >= 0; i--) {
            exPoint = eccDouble(exPoint);
            for (int j = 0; j < V_FIXEDBASE; j++) {
                digit = digits[W_FIXEDBASE * D_FIXEDBASE - j * E_FIXEDBASE + i - E_FIXEDBASE];
                int kStart = (W_FIXEDBASE - 1) * D_FIXEDBASE - j * E_FIXEDBASE + i - E_FIXEDBASE;
                int kMin = 2 * D_FIXEDBASE - j * E_FIXEDBASE + i - E_FIXEDBASE;
                for (int k = kStart; k >= kMin; k -= D_FIXEDBASE) {
                    digit = 2 * digit + digits[k];
                }
                int signDigit = D_FIXEDBASE - j * E_FIXEDBASE + i - E_FIXEDBASE;
                affPoint = Table.tableLookupFixedBase(digit, signDigit);
                exPoint = eccMixedAdd(affPoint, exPoint);
            }
        }
        return eccNorm(exPoint);
    }

    static BigInteger encode(FieldPoint<F2Element> point) {
        BigInteger y = point.y.real.add(point.y.im.shiftLeft(128));
        boolean ySignBit = point.y.real.compareTo(BigInteger.ZERO) <= 0;

        if (ySignBit) {
            y = y.setBit(255);
        }
        return y;
    }

    static FieldPoint<F2Element> decode(BigInteger encoded) {}

    static int[] mLSBSetRecode(BigInteger scalar) {}

    static ExtendedPoint<F2Element> R5_To_R1(AffinePoint<F2Element> p) {
        F2Element x = mp2Div(mp2Sub(p.xy, p.yx));
        F2Element y = mp2Div(mp2Add(p.xy, p.yx));
        return new ExtendedPoint<F2Element>(x, y, F2_ONE, x, y);
    }

    static ExtendedPoint<F2Element> eccMixedAdd(AffinePoint<F2Element> p, ExtendedPoint<F2Element> q) {}

    static ExtendedPoint<F2Element> eccDouble(ExtendedPoint<F2Element> p) {
        F2Element t1 = mp2Sqr(p.x);
        F2Element t2 = mp2Sqr(p.y);
        F2Element t3 = mp2Add(p.x, p.y);
        F2Element tb = mp2Add(t1, t2);
        t1 = mp2Sub(t2, t1);
        F2Element ta = mp2Sqr(t3);
        t2 = mp2Sqr(p.z);
        ta = mp2Sub(ta, tb);
        t2 = mp2AddSub(t2, t1);
        final F2Element y = mp2Mul(t1, tb);
        final F2Element x = mp2Mul(t2, ta);
        final F2Element z = mp2Mul(t1, t2);
        return new ExtendedPoint<F2Element>(x, y, z, ta, tb);
    }

    static FieldPoint<F2Element> eccNorm(ExtendedPoint<F2Element> p) {}

    static FieldPoint<F2Element> eccMulDouble(BigInteger k, FieldPoint<F2Element> q, BigInteger l) {}

    static F2Element mp2Add(F2Element a, F2Element b) {
        return new F2Element(FP.mpAdd(a.real, b.real).first, FP.mpAdd(a.im, b.im).first);
    }

    static F2Element mp2Sub(F2Element a, F2Element b) {
        return new F2Element(FP.mpSubtract(a.real, b.real).first, FP.mpSubtract(a.im, b.im).first);
    }

    static F2Element mp2Div(F2Element val) {
        return new F2Element(val.real.shiftRight(1), val.im.shiftRight(1));
    }

    static F2Element mp2Mul(F2Element a, F2Element b) {}

    static F2Element mp2Sqr(F2Element val) {}

    private static F2Element mp2AddSub(F2Element t2, F2Element t1) {}
}
