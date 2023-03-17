package org.example.Backjoon.정렬단계;

import java.io.*;

public class Example_10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] iArr = new int[10001];

        for (int i = 0; i < n; i++) {
            iArr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr[i]; j++) {
                bw.write(i + "\n");
            }
        }

//        bw.close();
        bw.flush();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] > 0) {
                sb.append((i + "\n").repeat(iArr[i]));
            }
        }
        System.out.print(sb);
        bw.close();
        br.close();
    }
}
