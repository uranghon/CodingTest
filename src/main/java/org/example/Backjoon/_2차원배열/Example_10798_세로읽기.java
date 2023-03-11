package org.example.Backjoon._2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] cArr = new char[5][15];
        for (int i = 0; i < 5; i++) {
            cArr[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (j >= cArr[i].length  ) continue;

                sb.append(cArr[i][j]);
            }
        }

        System.out.print(sb);
        br.close();
    }
}
