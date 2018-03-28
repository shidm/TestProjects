package properties;

import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        int a = Integer.parseInt("17",16);
        int d = Integer.parseInt("ab",16);
        char cc = (char) d;
        char bb = 97;
        char nm = 171;
        int b1 = Integer.parseInt("0e",16);
        int n =Character.digit('a', 16);
        int b = 'a';
        int c = 'b';
        int e = 'c';

        System.out.println(cc);
        System.out.println(bb);
        System.out.println(nm);
        System.out.println(a+"-"+b+"-"+c+"-"+e+"-"+d);
        System.out.println(b1);
        System.out.println(n);

//        Properties properties = new Properties();
//        try {
//            FileReader reader = new FileReader("/home/shidongming/桌面/properties");
//            properties.load(reader);
//            System.out.println(properties.getProperty("sdm"));
//            properties.setProperty("born", "1995");
//            properties.setProperty("like", "PUBL");
//            FileWriter outputStream = new FileWriter("/home/shidongming/桌面/properties");
//            properties.store(outputStream,"添加一些属性");
//            System.out.println(properties.getProperty("born"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        String sigStr = "17b96c3bfd10101e4dbe212a5d3fede5ff4bf4ea0" +
                "420ec72474251e7fefb7a6b0fdda6d7795537166bf01cfb60" +
                "7f0bba88b1403dd1283909ed5bf7aa3c6c4bf6518459adf0c" +
                "fa6016e0770a9caa592001cf69152bce91011d16cd8f30541" +
                "e50bd2f728746d40f70fdf44989c41504fdc43bebb7522995" +
                "64f316b9833d6079229c859bb074017ca2e8cf5f6bce2c9f3" +
                "77b2b0d004a46fb593f1f4651e2058677dc9e127368fcb4a1" +
                "0d99253b3433b424dc49c2d21dd26baa05b32af2f21054da7" +
                "2c7215060f86fe700f1e6e728c6fec9097aa3124bb23181e0" +
                "e7d3b2ba8eefba319bdff4bd3ebeeb1c2fe490576b88c6c2a" +
                "78328fc195bb9f0466b8ffc11cea63";

        byte[] bytes = hexStr2Bytes(sigStr);

        String s = getStringFromBytes(bytes);
        System.out.println(s);
        if (sigStr.equals(s)) {
            System.out.println("结果相等");
        }

        char[] chars = toBytes(sigStr);
        byte[] newB = new byte[chars.length];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            newB[i] = (byte) chars[i];
        }
        System.out.println(newB.length);
        System.out.println(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != newB[i]) {
                System.out.println("not");
            }
        }
        System.out.println(toBytes(sigStr).length);
//        System.out.println(newBytes.length);
//        byte[] bytes1 = toBytes(sigStr);
//        boolean isOk = true;
//        for (int i = 0; i < bytes.length; i++) {
//            if (sigStr[i] != bytes[i]) {
//                isOk = false;
//                break;
//            }
//        }
//
//        if (bytes1.length == bytes.length) {
//            System.out.println("byte->length相等");
//            for (int i = 0; i < bytes.length; i++) {
//                if (bytes1[i] != bytes[i]) {
//                    System.out.println("byte不相等");
//                }
//            }
//        }
//
//        System.out.println(sigStr.length());
//        System.out.println(bytes.length);
//
//        String newSigStr = bytesToHexStr(bytes);
//        if (newSigStr.equals(sigStr)) {
//            System.out.println("相等");
//        }
    }

    static String bytesToHexStr(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    static byte[] hexStr2Bytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(
                    s.charAt(i + 1), 16));
        }
        return data;
    }

    public static char[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new char[0];
        }

        char[] bytes = new char[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (char) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    private static String getStringFromBytes(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(Integer.toHexString((bytes[i] & 0xf0) >> 4)).append(Integer.toHexString(bytes[i] & 0x0f));
        }
        return stringBuilder.toString();
    }
}
