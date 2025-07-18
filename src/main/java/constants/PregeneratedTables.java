package constants;

import types.data.F2Element;
import types.point.PreComputedExtendedPoint;
import utils.BigIntegerUtils;

import java.math.BigInteger;

public class PregeneratedTables {
    public static String[] FIXED_BASE_TABLE = {
            "e18a34f3a703e631", "287460bf1d502b5f", "e02e62f7e4f90353", "0c3ba0378b86acde", "90bf0f98b0937edc", "740b7c7824f0c555", "b321239123a01366", "4ffcf5b93a9557a5", "297afccbabda42bb", "5948d137556c97c6", "a8189a393330684c", "0caf2b720a341f27"
            , "3a8ba018fd188787", "5546128188dd12a8", "b0b3cc33c09f9b77", "1baeeaf8b84d2049", "006425a611faf900", "18f7cd12e1a6f789", "6dccf09a12556066", "448e05eeace7b6eb", "bf2f33689d2829b0", "6d911dcb2957bdb4", "9f2353dbdc3c03ee", "06c54305babee501"
            , "2eaf45713dafa125", "72963058648a364d", "61b7771f9d313ef2", "4f41c7f8bfe2b069", "408623ae599790ac", "4d33858644330a42", "fc5696649cdd7487", "74df72e0e598e114", "c9a06325913c110b", "076bd4115fe4b0d8", "76619e65d6bff3d9", "249240147cee3a08"
            , "d695b96148965a73", "28aac8a28829f706", "41f1c05329f7a57b", "441ca9e89f03e00e", "e1aa38ab8bf7241e", "58f28cafc832b7f4", "cadaf8b8fa5400c6", "34b6d106284e863e", "f5498cab3af15097", "6dbe7790017d9c49", "63bf76a81448e8bc", "6371925bf23ae006"
            , "c5e2c721bded81fa", "4ede70eed68056ab", "8f3cd9b5b4975810", "4752fd192f0a9aa8", "318794eb1f734414", "11ddf7d2c8468662", "2613b06f72b1a34e", "465575b37ab06770", "40b9845f82638d2b", "48894050790298ce", "bedb93a501b4f131", "04f3560d2889b2fb"
            , "457dd875115b278b", "56f25ee54d92858a", "92d4c1cdce0c977e", "078fca4187d74996", "3bbb2ded76cc22a1", "117b28853ddc2bf6", "43f3767cb9c2baa2", "73079e25e0ea8a8f", "0177992b5a15796d", "2e77721480d9ef92", "be09883567372916", "258f176b7af7576d"
            , "308338fd6168391b", "7285925f9a7353a4", "862c0fd04fe85114", "53259ee7423aeb51", "fe0031a84b3b1a68", "1a4f1d661fa071fc", "2ddd54168dc928a7", "60185c1adf196a6a", "49809717dc6da9b4", "6062094b4dcffc03", "a41ea6fa05fa7e8d", "4a4fe06f277148a0"
            , "7bb253a9ee9e80f0", "419a928bccb11733", "84323be66a9a039e", "01b2d1ae972814bb", "a7588584d3051231", "54df1e20cc979dd7", "91d906fe3e2f22dd", "4e36e9975fdf1a0f", "d81871746b747634", "3e5e31baeee13433", "e4da80979573baa3", "4b852ad97cfe77c6"
            , "e08b346714418b9e", "283d719b2fe6ef88", "b7339d2de45c180b", "75acfcef11d2d5c8", "8f40777a8c561876", "0c54ac40a7134c4b", "b92e287d66baee08", "6f357e5006a188bf", "c5903319ed1e6971", "747c45ef91dafd40", "de4086a91d2f816e", "5dcb27edb3b3ef7d"
            , "43fdc46cfa1dd2ee", "51551f9f70966498", "b54534f761ed9bdc", "453455b3073fb07f", "f24773e383cab70b", "679be25e758cf4df", "da17edf2943eee29", "3dc9e5b8d6dc0f66", "56a50cba413fb75b", "1e65315bc5a8537f", "5ff90242802c7213", "73c9d8c8f425252e"
            , "3c637b8633198c8f", "534f84b3ed414f33", "ad313e72dedd6902", "5ed57e941cdf33af", "5a6fe01d2a57306e", "73b63dea344713f9", "39cb70570f1c2bf3", "2df8c6e49f1a18db", "661bc349677797e4", "501ae7cbbebe9062", "5b52a88de8959643", "0372752811c01d51"
            , "010c57a2301bb928", "378b317155554fc6", "f883fa4229a02cf1", "5f0047b850d7db29", "4d247ae328402daa", "0d030627a850a2bc", "b4e65d9a88a443f5", "6ec9686b2d6db089", "de202e08fea1d987", "5c64e1d3f28d7600", "157d17bef661bfb7", "56392d36dd75334c"
            , "e25478d8bd19155c", "146d4f2d3d336afd", "9bfbe00bf94e15e8", "2b185a9a6adf10c0", "926527b3ed52ab7b", "67997e1473101e80", "b58f4ff4947cc541", "36f800c7fac99a7a", "d0302e32400456d9", "4372e43640bc697b", "9144cabb4750d898", "75d25afac9a23cbf"
            , "794591767655cbfe", "74db216617fc4b07", "7057b2242566d0c9", "1d543b5908417b23", "19c280b444428783", "352309fd8b6cc3ef", "37833d6ac068ae72", "4ec0671a23c019f4", "9d9836e1a3d05bb5", "44fe1adff224efe3", "a296bc3ce57efb4a", "2efec86835a14150"
            , "2fe19c09fb194bca", "18cc07d3953cd206", "5bdff217c9c0b9e0", "671aa756581abcee", "e1cc33ae28f7d1a2", "1b6f254937a0a3fe", "51503d1665babb83", "74b95636d5889211", "bdb97ae4ea96f869", "1507ce189e2510bd", "796e4d54fab93b13", "6a81765f05960929"
            , "2e940521e5a833ed", "3bdea532b245f644", "bea76975ffd52693", "64b94848ba6d4ed6", "9db52d0194e33ec7", "71cf65da55639f25", "ede73b1fdb5a8138", "12e4d13b6c62dc22", "9d19b0c265185517", "77a011d257b5fdd0", "1fedc5caaecd84e4", "46844e151e3492d1"
            , "7a423a31904220df", "5b3165c747e8f099", "1c665eeadf35e22e", "7802b556fc45595b", "85a2def4015bd2de", "17f2ab87957166ad", "19cf6d352060c1e5", "122a7ad1be408e6a", "5b79bbc8645bf766", "20fb009d4d0adacf", "97526a272ba28538", "7041b4e90d420bde"
            , "3b30113358dab057", "3d398b66f0d24243", "91a5999a03cd4708", "1eae2409cd938096", "66dd6b604c36108c", "1713083789081968", "57cad6917125dcfd", "34b06cb89704f1ca", "dcafe8e71f35abf2", "698331198d544db9", "6287676643af075b", "200950e5559d2b6d"
            , "d4f63fc3ecdd9074", "7473317142ac13a2", "96b0030805319356", "2c20ffe0244378ba", "4889511ad26ac01a", "4ee327219997fcf6", "15ffe6e70f0bf8ea", "6b617fb4a6d0a6d7", "4916dca1c52f7324", "3c8269f086468277", "c24210c4c837e04b", "4e480b4f915a542c"
            , "c5fef3b09a7fe35e", "31a501de44fd84b2", "79f29e4940a407b9", "0ba7e03ca5cce5ab", "a7a8b2058a74d8ea", "46f4c7810e26dadc", "46171ace94a1128a", "44db55025495a811", "7f889e1a4bf18d5c", "4d4f172a43f306b2", "33a99766bb1cffad", "6254775924d39aca"
            , "d855230ec225136e", "1c544dd078d9211d", "12fe9969f63f63ba", "069af1dc949dd382", "305bcf40cfe5c256", "63ae90924bbbb595", "e451097793b7de06", "09780cf39fc0043e", "827af8e7eb798871", "3ace8a6c77577a37", "79df061332e055ba", "561dc07aaacea92b"
            , "7e4422d9820d2673", "6b85df83e0af5348", "1f151ac1ded8526b", "35ead8e5157142bd", "6da6ef6c33c79dd4", "5f2ea04d2594fde4", "91037d0cc027d5fa", "53b5401007b0331b", "810f198a3d4ba5a3", "4463bd259ba94195", "32b894acec2acf9e", "78711761d64349ce"
            , "253ae1b3f51fe211", "409e4b3f535b6463", "3a236d10da5e49de", "19d2b1029c21336a", "2835f40436aadd90", "0942a31505190b19", "c189131876828279", "3afe96c3ca8e1f9c", "9f1801b491230693", "39e28db8625fd091", "9fab50355dd44c8e", "145155da729b280d"
            , "d3ccf8101d4d76d5", "5a0faa1a8c2b6c68", "3cc66c84cb54ea8a", "51052ce3f566c773", "3bee14de65ae9ff5", "7586118a01ccf024", "089e791c896bf15e", "35ff022d261d93d6", "cd3ce13d8f7d1cf9", "4f1de98f95b7b8f6", "51e68a2462dc41b4", "61ad9e3c23f6dd29"
            , "584fea6480ebdb51", "5d52fe073f9decf3", "9afe483eadf336d5", "1dfa03c980b1696a", "55f73d47ff819a19", "697bf55d361100ed", "ded4804446399419", "618c94467fce259f", "f2597ff1f08ef50c", "07c935b98dd933c0", "bb758cbc78ded5f6", "1e9a0d06af13148f"
            , "879ce1457f4cd4db", "28396ca1962d4994", "f5095a3dc57605c3", "1e570f3da4c527b1", "2af69a3904935787", "591ee376fdd01cce", "f77b58df88bc8633", "5464d651b2f395d1", "afbc096b1e9a86ae", "6ce2df4bf65b6b28", "3b3a828d2e9d3e08", "6382011d8d2d66d0"
            , "94987ca64d3d193d", "50ddf70d3b6d56af", "8d5df67cc8ad15a9", "39208098bc5b1f92", "ce99f520dfd5a4fb", "323bbc87b86a7ba9", "e13f88a8d803c789", "56ffdcbdf2200055", "3aff0da31b24c72d", "70011566460c0c16", "76f7b7f53ac46a13", "1c069bfeb7077bc2"
            , "8f47193ca14a3c36", "6d73e34af088de3d", "634b2bd9317d6634", "5b404738b77f1ec8", "f34fabb71ca1cb1d", "054abbcaca546a46", "e8cdcadd08eda660", "6971abbf958bdef1", "41338557dddb4eaf", "1e158585b079b67c", "d2270474cfa26068", "53b36d32b3cea469"
            , "011523c16c543d08", "4668e92c5f73314e", "baef3ebe4117acd1", "04037d1aa713931a", "68e118e4e390c68d", "6b80cd55a44c1575", "7307ea8a5729c032", "5cc5475feee99ab2", "34450e424c14ac75", "3f09157e5db3dcd8", "62ce2b1b50588052", "27a899c54e652f8f"
            , "0acd039f2fc2a5ed", "4b4044ddd5813eec", "c04d189e90a75958", "242551bce71d33a1", "d95af96b51f87f05", "02988820f809d815", "b27f65f73b9483c5", "2ef60745f4364b43", "cb66bdc93f4fb8b9", "2b86c9b48756bb8a", "f8ebdae09b9867a1", "441e70184e6fe9aa"
            , "fdc2530330cc1289", "47d8d65a8b4d6992", "8c03b6fa30ae74be", "1ca8693cc3bd99d5", "699eb1511018f2a6", "3da04764d9f4fff5", "361720433d3aab59", "2fa911612cb857ff", "a4057da10c2f1cac", "48a219b933a5c619", "42341020d15f0bc5", "73f8895046a09dad"
            , "1bad5312c67421b8", "4194771b368e622e", "8cc71a79e44e0dff", "4b4564e45467f1c2", "7759f16aafe52093", "391b71dcd75fbea9", "2a1c0694ab4ef798", "023087545444130d", "4b7ae1ffcfaa1aa1", "64e26f32d73361e7", "8da47038bd0b54b9", "148cfa6feaecee15"
            , "3756d4d479c2cc3d", "25d44ea8d31543de", "d82c8bef26bb2c43", "2c2047033d27f37f", "5bd33d9837dad260", "77943117a3383b7d", "12071d697ea583f2", "3c7c41272a225bf2", "92ebbdfaf1f03ad3", "5d61030c68b63704", "ca6e2853baee75d1", "12404b34771a3636"
            , "be13c46326667e4f", "2bd261916f9be3b0", "86e3f8cbadc80f89", "74520d8a1794cb48", "1e15c745024cf97e", "5cee741e1e53eb02", "8d088de0af99cda1", "625812961cc0862c", "4313437321c0e934", "60bbc768c424f7a4", "aba71fbf3c10e143", "37b8ea9f14a915b8"
            , "8d96ec65c40213ff", "74a08828ff77845c", "bedb7194daf607a3", "17e86671161c8706", "aceb98e0524059cf", "68552ac494916f09", "4cd2971baf1b3c47", "68442ebcdde21b70", "19629b8c0e867595", "6a6955d3635fa47a", "6fab45e0f2e393ad", "66dd3ef4fcf050c4"
            , "bb0b7abcfddc7df1", "14eb5b751b0bcf9c", "1cf79f9ca2fd411d", "5c496f73fff0600a", "49648d8555426d70", "46c1016a2322d8a9", "b57fdb870d9b6d4f", "609eb65209ddb633", "e70f9166bedc82c5", "772fb5b5c8afaf27", "79a294d9b0227a20", "7f75b141112dbc8d"
            , "98d1c7f88e070020", "5953d0aac48217b1", "e28253ebe15f33ff", "267d1dc11e614c45", "be64f50ab99e2246", "4eaaab5c82fe5495", "927d5ac07e60bed0", "67d3786de6aa1b4d", "a71962bf0f6e2945", "63d93844a35eea9b", "b34228c7d26640ac", "169c38d2eb28f5a1"
            , "4b7972b33439dc22", "71478457cdaa1e14", "5226e125ec1d58c7", "669d8796e78fd4f1", "750dd1aaaa44a07f", "327c62b55aebbecf", "006b8e95b54fbd25", "2ab3f95d01eb364e", "fcbe5080c0d5e196", "2a1b9bd75a57e725", "1d2b2b6758139b5d", "751cf4af849b7a73"
            , "164a7d2e337d00a5", "00cee3a4cb83a4bc", "3498e0366dbe28f9", "053d899148d28502", "01665d64cab0fb69", "4a99132208d68e74", "ba44bbd4bd3f915d", "1d34b0f9172122bb", "5d114dc729e8a9f3", "08e7a43dd5334b60", "28db8e9232f0f3e8", "5cb7be1b80264f62"
            , "9af2c78782508f23", "336ae7ccf7e3a1b2", "7fe2d4ee2dd194be", "573d2e1b2b8a6872", "3332ea3363b2ea36", "200bc1375b1f4243", "65c47c8c06b3260d", "42021fca53995c5e", "2f7e6cf49bb19946", "311fba6a23196d2c", "c30c13b62be0d70d", "61eeac142711b0dc"
            , "88526996597d35d4", "70169bcbe6bd21d7", "a0f1b2d0ad29a510", "2ade531472c1b94d", "11e320dc189873e7", "2d2a1794e85cdb38", "a0a8c453a6f621e3", "4b06d5b54525f6f7", "f42916691848ec1c", "1d4216555d578730", "f8c60da7290a5b4e", "66dd9f39a1f3565f"
            , "55ac29d937b474a0", "4291967a4a369ee4", "918dacaa12e6bc89", "3d46e8900651c310", "af055430a00e90b1", "16f62bf56da5ca39", "1a021c33488c51e6", "0d64dadf63fbbcd5", "0918ece59dbfea7c", "3b3319d7dd74203a", "1d88545b8b9fa90c", "13b792dc908c59e6"
            , "0a2d939a9c3d0979", "321a5dbeb74bf127", "5e5947fff66d8470", "22ec9ecafd26bc99", "de17ca8293b10536", "593f56c0559dd846", "1148373375485023", "23c6b0fdf7448b1c", "377904458a27804f", "573e91962726ea70", "35e1b24f3235ac70", "51ba082049f4f85e"
            , "4bc4918160d47194", "5d29a21e3308e1dd", "7e15894b3e6e4e33", "50dbbd2f4f31d0fb", "ef248bd235a9c9de", "3418add21b634710", "96c7233a52363bd2", "7c8414ad9a08c99f", "bc6acb4a54e6c05c", "5729021a1193579a", "0627c3e00b08fa1c", "3d0b4ff9e17c2a73"
            , "d507e8755990317f", "75b27bb3bc7bfe48", "44a80f2c6ce651f5", "7b9795fc1b706e46", "9de75bdefdf9a640", "75ade50ababffaa8", "ce0ab116870889a0", "6f3ddcfcdd59ec6c", "6e36833588de0674", "291d1129ea28a073", "f8b8e53864884d61", "706ef8f1ae854d76"
            , "137a8c6583753069", "01e45f1cc620f966", "e28e1ff82f76c7ba", "36d29eace3e89c54", "83379f157f0b49cb", "65e9c39e2bacb937", "9b323c45070cda3e", "16e02f31ab7e2de5", "53bcf346635122b7", "1fd7e207d6c2de09", "3a5f5f94ea1e57ac", "0cba06e8d0f0b4df"
            , "70b440c387a9c392", "1e7dc143dee1d800", "5498ba6d7239912b", "332870a017182d14", "6be306fc672d794c", "2c2ce211245b2b4e", "109b722c8d2ba79f", "268520fa9c5f727a", "515b300524fe78ee", "736201eccbaea698", "4608ac113210bf78", "32d8fd919c441843"
            , "c9557e1b04b8f2d8", "775437f798dc7459", "1200f5585ba417f5", "2e00ec5f3e7ad304", "fc873d5f2b446288", "32270a93624876e4", "c646a47c08789b22", "2370d9fe925616be", "430afa3619e671c4", "156468ceac1f5fb2", "3b84dec2f2417635", "31140e9017c0e58f"
            , "5c85f88ccb7443fa", "0da75f5d64d864ac", "295ff44871b0fb84", "1b79e10bad3336c3", "ffdf9942dd2977b3", "4c1b198d0f9a1a23", "ba778a24c112864e", "74f66897f26d48d0", "3fd5c06e867ab611", "4b98ce33ff7878b9", "f7db4dce75cb9165", "11665aa099ec5163"
            , "2a498f16ae7118b9", "265ec3dbb4eb509a", "3da4230668ce2c86", "36e62baab2e33385", "99507d4a79ab4478", "25bfb2fc411e8875", "d7ac1ec933022ce1", "23d341ae033d0466", "d295b465e962bc00", "23d0211ba2d73180", "a03ccd7aff922d4d", "1e767148de301514"
            , "c241ab36a894efab", "1c9fc2f343fc1e58", "ca3b96562bd27a87", "53623e2285dd7015", "557411f01c219420", "19265577096b42f9", "d3312d941b23592f", "30a9a9a1c3c51c06", "3d89b0b3ea6e8f79", "7eab751dc5c77cb2", "c0a9b186e6df6e36", "4f844d583f155694"
            , "419018232793dffa", "2add440b6bd3854d", "d55480f131df6e32", "318ce3846ae3e417", "0565062d1a0984f4", "6ebaec63d2bff9f6", "77075fe729e79790", "0dd9434624c8a4e7", "bf8f11e2dfa9b062", "1b17d8255ee8b364", "62c2150cf72c6344", "28106880d081e8dc"
            , "f4a4af0ddfec91c1", "1a8f0e6c977e1f2e", "72a7a3a738b9316f", "323716728c4e22ec", "c14069065ba4af3b", "081514248911d367", "51bd4afaa8b6c337", "50e77a9b513400e7", "46c0051b2a822548", "024886e41a5edcfc", "a06b0efa41cac17f", "336a30b01b9c5675"
            , "74fb2c10ca097626", "2b204caa48e90981", "6902c952b9a17b74", "39c2e9b6b922303b", "b9216b9b3c597419", "6d92930264f15f76", "7b1297d5eeae1427", "0f0744adfe1bd307", "33b57e265be6a89d", "282fa2e533356c10", "3a03995c61dc772c", "4f5d8f5e893dcff5"
            , "4bfc927efc48023f", "596f2241d6a685ae", "3cb3e0afec29b8a2", "31018e0d10653842", "2fd00fe944575626", "1241d8704982e011", "970d56664e6781a7", "1b05f49d0f3de2ce", "a994ffdf63717e66", "416374a76ba88e98", "8b082ced53f1579a", "56781dfab5d2aa4b"
            , "8151defd1865b318", "64669b840d6081f7", "e436f4bb5f38e14e", "43d438410a974b40", "5832ceb3d666be02", "06347d9e1ae1828e", "6979471b39e3ea86", "2cf2cf61cb4b5ae4", "b7ab29eada5a6ee4", "12e75cb29aca5768", "e65b1109d30d1ffc", "71f9becd6b320e5a"
            , "dc8289026647eed9", "31d62d050ca5458f", "ea2bbf523a54c1e5", "602bf0b9e3ee5491", "25aa73622380ad4b", "2b6b1e3271df5f58", "dbc5efd86aa0470d", "05353c24b8c4354b", "a3c7db3cf5e06bca", "288a1c8f2b4ea5f7", "d6152f5e12ce7ca1", "59d4c1b436673c7d"
            , "1e02554e521fcb95", "66d3980f240ad440", "abf16f6b39a4d9d1", "7fea351ca94c2f62", "3d62b6f3389163ba", "0fc6b44f2e7895ea", "d5c64403cda7c669", "2e4099090e603193", "9b5c0faf15fa4c2f", "46295c9d8e12b639", "5ce4add63a5b331b", "5fa7bd736c4c5879"
            , "47b3471447d1aef2", "28004c1c22325739", "d588437d9a3c5299", "2ab19c1812cd27e8", "3ae700f680037802", "1ad163800b422b36", "45b7ef36fabc2139", "44bcdeff21dcbd1d", "41c6da2171e11c7b", "2c35ee79f7c4cc14", "4852942759c13849", "6492d26f10be050a"
            , "a6f54e988c50f0d9", "6a2db2b6dd62181b", "f7d9806b2a5e57a3", "57526bdb3ba53d20", "17ce6cb1f500e650", "05d841b042f8f345", "aa800a6c698de970", "04f4b559abe2cb8e", "c050dfd7259ce49d", "213839bdf94db935", "b371258655306204", "7d323b8b19f9705a"
            , "26d4502b16b6c618", "79717069aa89595b", "f867c0e36db41872", "13d601d86c76e1d0", "2dfc8b0d331b7383", "185472f3e42e8075", "05bd13e72b10eba0", "519a387490f79b95", "8d09c1b2d3ad2500", "045da45d2cf0f733", "640181956862426c", "728d57f59bfe1b09"
            , "f9a99f878da2c585", "4fc4831e61dc4e10", "6dc602cc54394fe0", "0484566b67e9e8ae", "c5fcf0474a93809b", "71c0c23a58f3e2bb", "b400fabe36fe6c43", "614c2f3eaee4c0a7", "7610a980d0e1c6c1", "1ce8197c88885dcc", "eade1c9f3ac2cb2b", "471ad07baf2f341e"
            , "d67a837c6b01121b", "2a8e64281f59cb59", "52e701e42f3262ca", "19e0a27dece50580", "b5691c17a7bda6ac", "43484c311b9df1f2", "a68155549bae49ea", "43a2c5dda225fae5", "fa5e992aed700eef", "58911f5623918856", "648b81a1e48c4da9", "66e6e30cbdd0c3bd"
            , "f3ba209c169d266b", "20f7a86230447685", "d1bb5aaa1a0c3d2e", "366c29843d1111f1", "06c78b642dcc9013", "27484a64e109e3fb", "8f8eacbca4677464", "0b6cb31b1dc24cc1", "df69c84f898f0fa0", "2dd426744920f2a2", "c0912a197d4c5c69", "489ade7f6a98d8d6"
            , "458769f47f203e28", "124f4123fc05ac97", "3bb936f4ad6d7d67", "330954fed4f00ff8", "c2ce650046f90eaf", "7bf94762d4f9debd", "2e93172a586dfb83", "3c7a6062b4113d96", "5ddb0397147f0d93", "08e3596fc6839034", "374e67ff67639bfa", "19021c2119888232"
            , "002f5d04fdd55efa", "05b4c6e079e1baa3", "e5678ea3ad74c84c", "1c42f7826a58a77d", "e054668bd2cafacd", "237668d3ede4261c", "edf46a6374aebb32", "31ec8c5931cf0ef4", "955c2e95c35b5825", "27d8b0ea68259603", "b7a8976e427d1ec0", "6b6cc5c07152bd13"
            , "03d88f0ca0b244cd", "001cae9a8cfed897", "a844b3a1f693a7fd", "676c9acb7abdec96", "631b6bd5e0cdbd33", "29f289dc0cddd9b8", "0947d57536fb2eff", "1eb2ce650e3eb059", "2139b3a40e8bf405", "4165edfb39f4ae8d", "e061eda67a70d6a6", "2e3cc0328c9084f6"
            , "1ef8329ed056063f", "6d4d01ce49e8b3d5", "0110c92f1656d34b", "6dad1c4e170829e0", "584c56c590b477be", "597e5f0ad525e935", "6008264d8eb7d36d", "3f586754999c829e", "3d7ea89df5546a1d", "41754f7d9a3f4364", "3b0796822ef879a7", "1ab2779598262872"
            , "dc37c9f0bbef7923", "256ec818ec35a097", "4a72da5c09dd5846", "51df6c61edcad45c", "aef24fcdcf5ce819", "0ba6bb959ae689f1", "e667bd65a57b3a9e", "71ffd591a28a8e4a", "06c325fa53a7fadf", "6667f2986b2dcf13", "3ef751a6d52a09e4", "517a104240b8c74a"
            , "d08cddfd8c8183f5", "59237cc71b8147f1", "fff94fd188395933", "538acc592d10ef67", "ac51ce386ff0eb1d", "69d42b8114c5fe65", "a17eda3995bfe8b9", "5dc6d98fdf05a341", "f2304d375ce8be78", "31b58521ecc483ca", "04d2d8140780222a", "3dc18b2be3ed95c9"
            , "a48e1639f2d70d2b", "4ffd54a6bc0f38d0", "8ae3c65ba6b7143b", "482eb41f9178fa9d", "240b8b4e87ad4f1d", "6d8532420059eb40", "c135f77e44275132", "6261076a0daae349", "35316bdb3842765c", "246165ba3a8bfd92", "1c2d774bd5177a75", "045a2f991647e3b6"
            , "ed3b5923594671a8", "0514fada5acd4db5", "e8297fc358a0f50f", "7cd2badcf2952a91", "0da45130ea9ac266", "26a0d43c1e14c979", "bb62b729fe93a390", "360357aff7f67ccb", "3ad4835d1c7c59e8", "570daffd86fa470b", "d7c4be698fa3bd96", "17e4bdec2ad76ffc"
            , "43ce4ea9ead7dc51", "58ba7ae0d64a518e", "e014cc7e64680555", "03abc953ce2630b8", "a318620c7799be57", "2b258fa2e84da952", "dd88fdc5063b2ffd", "17371dd79a3aa556", "927b837578981299", "554552101d90ab2d", "b45306218ce54bd0", "59109b65ffdb6235"
            , "8663e0c4a180a515", "41467fe41c6604f4", "ae2c1aa4dcb73878", "19d3cb02c6c07517", "aa147c97ea6745f1", "70dac71a31cac43c", "b9213ec26af87dfa", "67f228e9f60e7b25", "bfb59b8cf78df3df", "36687792a4256fa3", "e1be5c1f23177544", "786a9e1b644b1c90"
            , "4172f47393ca7f5b", "62ae5bb4b8aaeb59", "bcd9c431fa631b6f", "1fbe20b2edc9cc6d", "5fdd829fbc0ee085", "241dd315adc5dd59", "b4b688d625f7dbb6", "595a82fee5bed2d4", "69653ae0cc11880d", "2b9e85fefc402f76", "bb2495b507770a81", "05d20c575fb34731"
            , "9d9e623436485ab2", "27012a9665f3febb", "586cfef484c04ff7", "44a5860cc0eabfbe", "6fbfe6e2f3532e80", "05abeabaaf3220fe", "1bed21f2cb809678", "2aa62112b7eafed2", "e298837cf610190b", "1ec8fbbcef9158f8", "1efe9b3aa4f96f6b", "6a3b842a068b0ef3"
            , "92dd4b7cd7f827f7", "605175bbf3fd1c97", "139bb6419c1f6d98", "3a3ab2e9978db310", "c5c95941c9d5dd0b", "34c6c76025b2bce0", "0d44115a49bb8126", "7622cbeb11daf619", "785bff93164ef5ad", "7191647d355cb45d", "117f255c4cce6e5c", "581b448b0e9aae3e"
            , "54a4f3cb36225414", "790180c539bc4685", "47064043b7c6b96f", "43cccf5b3a2c010b", "1dfbf3afc14c3731", "1c368f3195572574", "00bc2ed3b5070b5a", "0332d8dd63b37f60", "0744b1908c9bd8f0", "2d258e628dacb9ce", "bba5b4bdb9c61e14", "0bca12295a34e996"
            , "059c84c66f2175d4", "1a3bed438790be78", "df394f577dabb5b0", "304777e63b3c33e4", "59a29d4fe82c5a6a", "72e421d1e88e77a4", "69e6230313312959", "2da03aad8cf2bbb8", "2858d8608fecb0b6", "343099e7a40243a6", "ba29b675d29a8f63", "3d2028a4f6f15886"
            , "f068e2d286047d0a", "14999b5d6c770e20", "d1874a592385da79", "78aeb552c15a1cd9", "482dcccc23e9c06e", "7b18a19fb54b5745", "036c896efe9a7a06", "2f2c2ce0d1871c13", "3b2d9b9ed65492c7", "0649c7e50819d077", "cdab66ea7b65e3cb", "49b15b40c4aaf03f" };

    public static final PreComputedExtendedPoint[] FIXED_BASE_TABLE_POINTS = convertUnsignedStringArrayToPoints();

    // The function below aims to convert the above unsigned String array To an array of points,
    // following the specification outlined:
    // The table above was generated using window width W = 5 and table parameter V = 5 (see http://eprint.iacr.org/2013/158).
    // Number of point entries = 5 * 2^4 = 80 points, where each point (x,y) is represented using coordinates (x+y,y-x,2*d*t).
    // Table size = 80 * 3 * 256 = 7.5KB.
    private static PreComputedExtendedPoint[] convertUnsignedStringArrayToPoints() {
        PreComputedExtendedPoint[] parsedArray = new PreComputedExtendedPoint[FIXED_BASE_TABLE.length / 3];

        for(int i = 0, nextPos = 0; i < FIXED_BASE_TABLE.length; i += 3, nextPos++) {
            String xPlusY = FIXED_BASE_TABLE[i];      // x+y coordinate
            String yMinusX = FIXED_BASE_TABLE[i+1];   // y-x coordinate
            String twoDT = FIXED_BASE_TABLE[i+2];     // 2*d*t coordinate

            parsedArray[nextPos] = new PreComputedExtendedPoint(
                    BigIntegerUtils.convertBigIntegerToF2Element(new BigInteger(xPlusY, Params.HEX_RADIX)),
                    BigIntegerUtils.convertBigIntegerToF2Element(new BigInteger(yMinusX, Params.HEX_RADIX)),
                    new F2Element(BigInteger.ONE, BigInteger.ZERO),
                    BigIntegerUtils.convertBigIntegerToF2Element(new BigInteger(twoDT, Params.HEX_RADIX))
            );
        }

        return parsedArray;
    }
}
