package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
 * 팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다.
 * level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.
 *
 * -풀이-
 * 단어를 받아서 반을 짜른다.
 * 하나는 그대로 두고, 하나는 reverse 한다.
 * 둘을 비교하여 같으면 펠린드롬.
 */
public class Example_10988_펠린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder(str.substring(str.length() - (str.length() / 2)));

        if(sb.reverse().toString().equals(str.substring(0, str.length() / 2))) System.out.print(1);
        else System.out.print(0);

//        int isP = 1;
//        for (int i = 0; i < str.length() / 2; i++) {
//            if(str.charAt(i) != str.charAt(str.length() - i - 1))
//            {
//                isP = 0;
//                break;
//            }
//        }
//        System.out.print(isP);
    }
}
