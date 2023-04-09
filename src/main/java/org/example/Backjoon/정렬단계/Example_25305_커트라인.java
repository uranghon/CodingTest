package org.example.Backjoon.정렬단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 $N$명의 학생들이 응시했다.
 * 이들 중 점수가 가장 높은 $k$명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
 * 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
 *
 * 첫째 줄에는 응시자의 수 $N$과 상을 받는 사람의 수 $k$가 공백을 사이에 두고 주어진다.
 * 둘째 줄에는 각 학생의 점수 $x$가 공백을 사이에 두고 주어진다.
 *
 * 상을 받는 커트라인을 출력하라.
 *
 * -풀이-
 * merge sort 로다가 내림차순 정렬하고 앞의 k번째꺼 뽑자
 */
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
