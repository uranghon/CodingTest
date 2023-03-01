package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
}