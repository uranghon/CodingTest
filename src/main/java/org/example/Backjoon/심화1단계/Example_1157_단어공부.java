package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 *
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 *
 * -풀이-
 * 알파벳 26개 크기 int 형 배열 만들고
 * 입력값 문자 하나하나 읽으면서 해당하는 배열의 값을 1씩 더해준다.
 * a,A 는 0 번째, b,B는 1번째, c,C는 2번째, ... z,Z 는 25번째 위치
 */
public class Example_1157_단어공부 {
    public static void main(String[] args) {

    }
    static void mine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toUpperCase().toCharArray();
        int[] aToz = new int[26];
        StringBuilder sb = new StringBuilder();
        int max = 0;

        for (char c : cArr) {
//            aToz[c - 'A']++;
            if (++aToz[c - 'A'] > max) {
                max = aToz[c - 'A'];
            }
        }
        for (int i = 0; i < aToz.length; i++) {
            if (aToz[i] == max) {
                sb.append((char) (i + 'A'));
            }
        }

        if (sb.length() > 1) System.out.print("?");
        else System.out.print(sb);

        br.close();
    }

    static void others() throws IOException {
        int[] arr = new int[26];
        int c = System.in.read();
        while (c > 64) {
            if (c < 91) {
                arr[c - 65]++;
            } else {
                arr[c - 97]++;
            }
            c = System.in.read();
        }
        int max = -1;
        int ch = -2;	// ? 는 63 이다.
        for (int i = 0; i < 26; i++) {

            if (arr[i] > max) {
                max = arr[i];
                ch = i;
            } else if (arr[i] == max) {
                ch = -2;
            }
        }
        System.out.print((char) (ch+65));
    }

}
