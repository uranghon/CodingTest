package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example_11651_좌표정렬하기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] iArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            iArr[i][0] = Integer.parseInt(st.nextToken());
            iArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(iArr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int[] a : iArr) {
            bw.write(a[0] + " " + a[1] + "\n");
        }

//        Arrays.stream(iArr).sorted((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]).forEach(a -> {
//            try {
//                bw.write(a[0] + " " + a[1] + "\n");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });

        bw.flush();
    }
}
