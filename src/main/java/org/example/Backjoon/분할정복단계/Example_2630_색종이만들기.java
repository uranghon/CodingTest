package org.example.Backjoon.분할정복단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_2630_색종이만들기 {

    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int level = (int) Math.round(Math.log(n) / Math.log(2));
        int[][][] color = new int[n][n][level + 1];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                color[r][c][0] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= level; i++) {
            int jump = (int) Math.round(Math.pow(2, i));
            for (int r = jump - 1; r < n; r += jump) {
                for (int c = jump - 1; c < n; c += jump) {
                    color[r][c][i] = color[r][c][i - 1] == color[r][c - (jump / 2)][i - 1]
                            && color[r][c][i - 1] == color[r - (jump / 2)][c][i - 1]
                            && color[r][c][i - 1] == color[r - (jump / 2)][c - (jump / 2)][i - 1] ? color[r][c][i - 1] : -1;;
                }
            }
        }

        int idx = (int) Math.round(Math.pow(2, level)) - 1;

        splitPaper(level, idx, idx, color);

        System.out.println(white);
        System.out.println(blue);
    }

    static void splitPaper(int level, int row, int col, int[][][] color) {
        int type = color[row][col][level];

        if (type == 0) {
            white++;
        } else if (type == 1) {
            blue++;
        } else {
            level--;
            int diff = (int) Math.round(Math.pow(2, level));
            splitPaper(level, row, col, color);
            splitPaper(level, row - diff, col, color);
            splitPaper(level, row, col - diff, color);
            splitPaper(level, row - diff, col - diff, color);
        }
    }
}
