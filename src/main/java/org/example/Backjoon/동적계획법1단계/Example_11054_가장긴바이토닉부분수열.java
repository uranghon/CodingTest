package org.example.Backjoon.동적계획법1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
 *
 * 예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,
 * {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
 *
 * 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)
 *
 * 첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.
 *
 * -풀이-
 * 가장긴증가하는부분수열을 구하고
 * 배열 리버스해서 또 가장긴증가하는부분수열 구한 다음에
 * 각각을 합한게 가장 큰거에서 꼭지점값 중복되는거 하나 뺀게 답이다.
 */
public class Example_11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 2][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            for (int ii = i - 1; ii >= 0; ii--) {
                if (dp[i][0] > dp[ii][0]) {
                    dp[i][1] = Math.max(dp[i][1], dp[ii][1] + 1);
                }
                else if (dp[i][0] == dp[ii][0]) {
                    dp[i][1] = Math.max(dp[i][1], dp[ii][1]);
                }
            }
        }

        for (int i = n; i > 0; i--) {
            for (int ii = i + 1; ii <= n + 1; ii++) {
                if (dp[i][0] > dp[ii][0]) {
                    dp[i][2] = Math.max(dp[i][2], dp[ii][2] + 1);
                } else if (dp[i][0] == dp[ii][0]) {
                    dp[i][2] = Math.max(dp[i][2], dp[ii][2]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i][1] + dp[i][2]);
        }

        System.out.print(max - 1);

    }
}
