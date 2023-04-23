package org.example.Backjoon.분할정복단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_1992_쿼드트리 {
    static StringBuilder sb = new StringBuilder();
    static int[][][] video;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int level = (int) Math.round(Math.log(n) / Math.log(2));
        video = new int[n][n][level + 1];

        for (int r = 0; r < n; r++) {
            char[] chars = br.readLine().toCharArray();
            for (int c = 0; c < n; c++) {
                video[r][c][0] = chars[c] - '0';
            }
        }

        for (int i = 1; i <= level; i++) {
            int jump = (int) Math.round(Math.pow(2, i));
            for (int r = jump - 1; r < n; r += jump) {
                for (int c = jump - 1; c < n; c += jump) {
                    int diff = jump / 2;
                    video[r][c][i] = video[r][c][i - 1] == video[r - diff][c][i - 1]
                                     && video[r][c][i - 1] == video[r][c - diff][i - 1]
                                     && video[r][c][i - 1] == video[r - diff][c - diff][i - 1] ? video[r][c][i - 1] : -1;
                }
            }
        }
        quadTree(level, n - 1, n - 1);
        System.out.println(sb);
    }

    static void quadTree(int level, int row, int col) {
        int type = video[row][col][level];

        if (type < 0) {
            level--;
            sb.append("(");
            int diff = (int) Math.round(Math.pow(2, level));
            quadTree(level, row - diff, col - diff);
            quadTree(level, row - diff, col);
            quadTree(level, row, col - diff);
            quadTree(level, row, col);
            sb.append(")");
        } else {
            sb.append(type);
        }
    }
}
