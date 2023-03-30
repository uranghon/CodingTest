package org.example.Backjoon.문자열단계;

import java.io.*;
import java.util.*;

public class Example_5622_다이얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        int s = 0;
        for (char c : charArray) {
            s += dialNum2(c);
        }

        System.out.print(s + charArray.length); // 원하는 숫자 누르려면 다이얼넘버+1만큼 이동해야하니까. 번호+전화번호자리수 하면 된다.
        br.close();
    }

    static int dialNum1(char c) {
        Map<String, Integer> dialMap = new HashMap<>();
        dialMap.put("A", 2);
        dialMap.put("B", 2);
        dialMap.put("C", 2);
        dialMap.put("D", 3);
        dialMap.put("E", 3);
        dialMap.put("F", 3);
        dialMap.put("G", 4);
        dialMap.put("H", 4);
        dialMap.put("I", 4);
        dialMap.put("J", 5);
        dialMap.put("K", 5);
        dialMap.put("L", 5);
        dialMap.put("M", 6);
        dialMap.put("N", 6);
        dialMap.put("O", 6);
        dialMap.put("P", 7);
        dialMap.put("Q", 7);
        dialMap.put("R", 7);
        dialMap.put("S", 7);
        dialMap.put("T", 8);
        dialMap.put("U", 8);
        dialMap.put("V", 8);
        dialMap.put("W", 9);
        dialMap.put("X", 9);
        dialMap.put("Y", 9);
        dialMap.put("Z", 9);

        return dialMap.get(c + "");
    }

    static int dialNum2(char c) {
        int num = 0;
        switch (c) {
            case 'A':
            case 'B':
            case 'C':
                num = 2;
                break;
            case 'D':
            case 'E':
            case 'F':
                num = 3;
                break;
            case 'G':
            case 'H':
            case 'I':
                num = 4;
                break;
            case 'J':
            case 'K':
            case 'L':
                num = 5;
                break;
            case 'M':
            case 'N':
            case 'O':
                num = 6;
                break;
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                num = 7;
                break;
            case 'T':
            case 'U':
            case 'V':
                num = 8;
                break;
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                num = 9;
                break;
        }
        return num;
    }

    static int dialNum3(char c) {
        int num = 0;

        if (c - 'A' < 15) num = ((c - 'A') / 3) + 2;
        else if (c - 'A' >= 15 && c - 'A' <= 18) num = 7;
        else if (c - 'A' >= 19 && c - 'A' <= 21) num = 8;
        else num = 9;

        return num;
    }
}
