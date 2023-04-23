package org.example.Backjoon.분할정복단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.RuntimeMXBean;
import java.util.StringTokenizer;

public class Example_1780_종이의개수 {
    static int[][][] paper;
    static int[][] paper2;
    static int p1 = 0;
    static int p2 = 0;
    static int p3 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int level = (int) Math.round(Math.log(n) / Math.log(3));
        paper = new int[n][n][level + 1];
        paper2 = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                paper[r][c][0] = Integer.parseInt(st.nextToken());
                paper2[r][c] = paper[r][c][0];
            }
        }

        for (int i = 1; i <= level; i++) {
            int jump = (int) Math.round(Math.pow(3, i));
            for (int r = jump - 1; r < n; r += jump) {
                for (int c = jump - 1; c < n; c += jump) {
                    int diff = jump / 3;
                    int diff2 = diff * 2;
                    paper[r][c][i] = paper[r][c][i - 1] == paper[r - diff][c][i - 1]
                                  && paper[r][c][i - 1] == paper[r][c - diff][i - 1]
                            && paper[r][c][i - 1] == paper[r - diff][c - diff][i - 1]
                            && paper[r][c][i - 1] == paper[r - diff2][c][i - 1]
                            && paper[r][c][i - 1] == paper[r - diff2][c- diff][i - 1]
                            && paper[r][c][i - 1] == paper[r][c - diff2][i - 1]
                            && paper[r][c][i - 1] == paper[r - diff][c - diff2][i - 1]
                            && paper[r][c][i - 1] == paper[r - diff2][c - diff2][i - 1] ? paper[r][c][i - 1] : -2;
                }
            }
        }

//        splitPaper(level, n - 1, n - 1);
        splitPaper2(level, 0, 0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.print(p3);
    }
    static void splitPaper(int level, int row, int col) {
        int type = paper[row][col][level];
        if(type == -1) p1++;
        else if(type == 0) p2++;
        else if (type == 1) p3++;
        else {
            level--;
            int diff = (int) Math.round(Math.pow(3, level));
            int diff2 = diff * 2;
            splitPaper(level, row - diff2, col - diff2);
            splitPaper(level, row - diff2, col - diff);
            splitPaper(level, row - diff2, col);
            splitPaper(level, row - diff, col - diff2);
            splitPaper(level, row - diff, col - diff);
            splitPaper(level, row - diff, col);
            splitPaper(level, row, col - diff2);
            splitPaper(level, row, col - diff);
            splitPaper(level, row, col);
        }
    }

    static void splitPaper2(int level, int row, int col) {
        int type = paper2[row][col];

        int diff = (int) Math.round(Math.pow(3, level));
        boolean blNot = false;
        for (int r = row; r < row + diff; r++) {
            for (int c = col; c < col + diff; c++) {
                if (paper2[r][c] != type) {
                    blNot = true;
                    break;
                }
            }
            if(blNot) break;
        }

        if (blNot) {
            level--;
            diff = (int) Math.round(Math.pow(3, level));
            int diff2 = diff * 2;

            splitPaper2(level, row, col);
            splitPaper2(level, row, col + diff);
            splitPaper2(level, row, col + diff2);
            splitPaper2(level, row + diff, col);
            splitPaper2(level, row + diff, col + diff);
            splitPaper2(level, row + diff, col + diff2);
            splitPaper2(level, row + diff2, col);
            splitPaper2(level, row + diff2, col + diff);
            splitPaper2(level, row + diff2, col + diff2);
        } else if (type == -1) p1++;
        else if (type == 0) p2++;
        else if (type == 1) p3++;
    }
}
