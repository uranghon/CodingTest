package org.example.Backjoon.동적계획법1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에
 * 가장 긴 증가하는 부분 수열은 A = {'10', '20', 10, '30', 20, '50'} = {10,20,30,50}이고, 길이는 4이다.
 *
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
 * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
 *
 * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 *
 * -풀이-
 * "x번째 값이 가지는 가장 긴 증가하는 부분수열의 길이를 구하고 싶다면,
 * 1 ~ x - 1번째 값들 중, x번째 값 보다 더 작은 숫자들이 갖는 부분수열의 길이 중,
 * 가장 길이가 긴 부분수열의 길이에 + 1을 한 값이, x번째 값이 가지는 가장 긴 증가하는 부분 수열의 길이이다."
 *
 * 여기서 한가지 추가사항을 넣어준다면 1부터 x-1까지 점검하는게 아니라 x-1부터 1까지 체크해가다가 x번째 값과 동일한 값이 있으면
 * 걔의 부분수열 길이랑 현재 부분수열 길이랑 비교해서 더 큰게 찐 부분수열 길이.
 */
public class Example_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
            for (int idx = i - 1; idx >= 0; idx--) {
                if(dp[i][0] > dp[idx][0])
                {
                    dp[i][1] = Math.max(dp[i][1], dp[idx][1] + 1);
                }
                else if (dp[i][0] == dp[idx][0])
                {
                    dp[i][1] = Math.max(dp[i][1], dp[idx][1]);
                    break;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i][1]);
        }

        System.out.println(max);

    }
}
