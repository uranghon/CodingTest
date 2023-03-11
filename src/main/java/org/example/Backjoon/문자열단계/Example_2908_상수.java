package org.example.Backjoon.문자열단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2908_상수 {
    public static void main(String[] args) throws IOException {
        다른사람꺼();
    }

    static void 내꺼() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" +");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int ra = reverse(a, str[0].length());
        int rb = reverse(b, str[1].length());

        System.out.println(ra > rb ? ra : rb);
        br.close();
    }


    static int reverse(int num, int length) {
        int rNum = 0;
        for (int i = 1; i <= length; i++) {
            rNum += ((num / (int) Math.pow(10, i - 1)) % 10) * Math.pow(10, length - i);
        }
        return rNum;
    }

    static void 다른사람꺼() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" +");
        StringBuilder sb1 = new StringBuilder(str[0]);
        StringBuilder sb2 = new StringBuilder(str[1]);
        System.out.println(Math.max(Integer.parseInt(sb1.reverse().toString()), Integer.parseInt(sb2.reverse().toString())));
        br.close();
    }
}
