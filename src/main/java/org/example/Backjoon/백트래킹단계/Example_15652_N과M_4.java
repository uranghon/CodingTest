package org.example.Backjoon.백트래킹단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 */
public class Example_15652_N과M_4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int idx) {
        if(idx == m)
        {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int fr = 1;
        if(idx > 0) fr = arr[idx - 1];

//        for (int i = 1; i <= n; i++) {
        for (int i = fr; i <= n; i++) {
//            if(idx > 0 && arr[idx - 1] > i) continue;
            arr[idx] = i;
            dfs(idx + 1);
        }
    }
}
