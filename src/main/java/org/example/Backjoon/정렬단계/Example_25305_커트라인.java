package org.example.Backjoon.정렬단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example_25305_커트라인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        String[] strScore = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] score = new int[n];

        for (int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(strScore[i]);
        }

        Arrays.sort(score);
//        Arrays.parallelSort(score);
        System.out.print(score[n-k]);
        br.close();
    }
}
