package org.example.Backjoon.동적계획법1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
 * 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
 *
 * 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 * N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 * i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 *
 * 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
 * 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
 *
 * 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */
public class Example_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = Math.min(r + arr[i - 1][1], r + arr[i - 1][2]);
            arr[i][1] = Math.min(g + arr[i - 1][0], g + arr[i - 1][2]);
            arr[i][2] = Math.min(b + arr[i - 1][0], b + arr[i - 1][1]);
        }

        System.out.print(Math.min(Math.min(arr[n][0], arr[n][1]), arr[n][2]));
    }
}
