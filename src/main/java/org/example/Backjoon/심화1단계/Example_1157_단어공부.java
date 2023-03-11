package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_1157_단어공부 {
    public static void main(String[] args) {

    }
    static void 내꺼() throws IOException {
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

    static void 남꺼_좋은거() throws IOException {
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
