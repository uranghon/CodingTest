package org.example.Backjoon.누적합단계;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
 * 둘째 줄에는 N개의 수가 주어진다.
 * 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 *
 * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 *
 * -풀이-
 * 보면 에를들어 i번째부터 j번째까지의 합은
 * 1번째부터 j번째까지의 누적합 - 1번째부터 i-1번째까지의 누적합 이다.
 * 그러면 일단 n짜리 배열 만들어놓고
 * 1번까지 누적합 : 1번
 * 2번까지 누적합 : 1번 + 2번 = 1번까지 누적합 + 2번
 * 3번까지 누적합 : 1번 + 2번 + 3번 = 2번째까지 누적합 + 3번
 * 4번까지 누적합 : 1번 + 2번 + 3번 + 4번 = 3번까지 누적합 + 4번
 * ...
 * n번째지 누적합 : 1번 + 2번 + 3번 + ... + n-1번 + n번 = n-1번까지 누적합 + n번
 * 이렇게 저장한다.
 *
 * 그러고 나서 i, j 받으면 j까지 누적합 - i-1까지 누적합 하면 i부터 j까지 합이다.
 */
public class Example_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] = arr[i- 1] + Integer.parseInt(st.nextToken());
        }

//        int[][] dp = new int[n + 1][n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = i; j > 0; j--) {
//                dp[i][j] = dp[i - 1][j] + arr[i];
//            }
//        }
//
//        for (int idx = 0; idx < m; idx++) {
//            st = new StringTokenizer(br.readLine());
//
//            int i = Integer.parseInt(st.nextToken());
//            int j = Integer.parseInt(st.nextToken());
//
//            bw.write(dp[j][i] + "\n");
//        }

        for (int idx = 0; idx < m; idx++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write((arr[j] - arr[i - 1]) + "\n");
        }

        bw.flush();
    }
}
