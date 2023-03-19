package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.Arrays;

public class Example_10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] sArr = new String[n];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = br.readLine();
        }

        Arrays.sort(sArr, (s1, s2) -> Integer.parseInt(s1.split(" ")[0]) - Integer.parseInt(s2.split(" ")[0]));

        for (String s : sArr) {
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
    }
}
