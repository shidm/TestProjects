package usetrap;

import java.math.BigInteger;

public class Main {

    static String sigStr = "32661ae56a22b1d1bbc565ab36410659" +
            "da4530a7613a0a9423372e3722ca3371" +
            "9e2f1a1c0128ed55a9e04149c8ed0321" +
            "8504f1ae75d066ed4af3a3e7e95222fd" +
            "3ffda6ff21397ead99bdda01cd4a12ae" +
            "86d2072772cf869a8ab9325a3e0af25c" +
            "badafc09bfb0fb9b1069520bfceaac5f" +
            "7ca771f831e1dcc35620e56e4caabb58" +
            "1d828bce3ef21f2fe7d0a6280c8cba08" +
            "4ed2fcac8597490be424ce2f1a6b809c" +
            "127e0372326438e86ec42de8606f6825" +
            "73bde81588010ae2cabcf6f23fe15fa5" +
            "afc312cce06545838b4f1eaf73f160e2" +
            "d9e5a5ec66bd3eb06947bc8afcdcb8c5" +
            "f7338ac31038d47bb0720f5a935bfccf" +
            "61d97a62d3a0e4811c0738ea89d8360c";

    public static void main(String[] args) {
//        short s = 5;
//        s += 90000;
//        System.out.println(s);
//        BigInteger[] b = new BigInteger("1111111111111111111111")
//                .divideAndRemainder(new BigInteger("2"));
//        for (BigInteger i:b) {
//            System.out.println(i);
//        }

//        byte[] a = hextobyte(sigStr);

        System.out.println(new String(hextobyte(sigStr)));
    }

    static byte[] hextobyte(String str){
        int len = str.length();
        byte[] b = new byte[len/2];
        for (int i = 0; i < len; i+=2) {
            b[i/2] = (byte) (Character.digit(str.charAt(i), 16) << 4
                                + Character.digit(str.charAt(i), 16));
        }
        return b;
    }
}
