package io;

import java.io.*;

public class Main {

    public static int aaa() {
        int x = 1;

        try {
            return ++x;
        } catch (Exception e) {

        } finally {
            ++x;
        }
        return x;
    }

    public static void main(String[] args) {
            Main t = new Main();
            int y = t.aaa();
            System.out.println(y);

//        try {
//            BufferedReader bufferedReader = new BufferedReader(
//                    new FileReader("/home/shidongming/桌面/BufferedReadertest"),
//                    10);
//
//            for (int i = 0; i < 8; i++) {
//                System.out.println("normal："+ (char) bufferedReader.read());
//            }
//
//            bufferedReader.mark(3);
//
//            for (int i = 0; i < 4; i++) {
//                System.out.println("mark:" + (char) bufferedReader.read());
//            }
//
//            bufferedReader.reset();
//
//            for (int i = 0; i < 6; i++) {
//                System.out.println("reset:" + (char) bufferedReader.read());
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
