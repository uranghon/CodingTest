package org.example.Backjoon.문자열단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2675_문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split(" ");
//            char[] c = strArr[1].toCharArray();
//            for (int j = 0; j < c.length; j++) {
            for (char c: strArr[1].toCharArray()) {
                for (int k = 0; k < Integer.parseInt(strArr[0]); k++) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
