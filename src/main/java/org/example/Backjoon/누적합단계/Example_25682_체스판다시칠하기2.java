package org.example.Backjoon.누적합단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_25682_체스판다시칠하기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int row = 0;
        int col = 0;

        dp = new int[n + 1][m + 1][2];

//        mine1(n, m);
        mine2(n, m);

        int min = Integer.MAX_VALUE;
        for (int r = k; r <= n; r++) {
            for (int c = k; c <= m; c++) {
                int cntB = dp[r][c][0] - dp[r - k][c][0] - dp[r][c - k][0] + dp[r - k][c - k][0];
                int cntW = dp[r][c][1] - dp[r - k][c][1] - dp[r][c - k][1] + dp[r - k][c - k][1];
                min = Math.min(min, Math.min(cntB, cntW));

                if (min == 0) {
                    System.out.print(0);
                    return;
                }
            }
        }

        System.out.print(min);
    }

    static void mine1(int n, int m) throws IOException {
        char s = 'B';

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                char cur = (char) br.read();
                if (cur == s) {
                    dp[r][c][0] = dp[r - 1][c][0] + dp[r][c - 1][0] - dp[r - 1][c - 1][0];
                    dp[r][c][1] = dp[r - 1][c][1] + dp[r][c - 1][1] - dp[r - 1][c - 1][1] + 1;
                } else {
                    dp[r][c][0] = dp[r - 1][c][0] + dp[r][c - 1][0] - dp[r - 1][c - 1][0] + 1;
                    dp[r][c][1] = dp[r - 1][c][1] + dp[r][c - 1][1] - dp[r - 1][c - 1][1];
                }
                s = s == 'B' ? 'W' : 'B';
            }
            br.read();
            if(m % 2 == 0) s = s == 'B' ? 'W' : 'B';
        }
    }

    /**
     * (r+c)가 짝수인 칸이 B, 홀수인칸이 W 방법
     * BW 문양으로 시작하는 완성된 가상 체스판을 만들고 걔랑 현재 보드를 비교하게 한다.
     */
    static void mine2(int n, int m) throws IOException {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                char cur = (char) br.read();
                if ((r + c) % 2 == 0) {
                    if (cur == 'B') dp[r][c][1]++;
                    else dp[r][c][0]++;
                } else {
                    if (cur == 'B') dp[r][c][0]++;
                    else dp[r][c][1]++;
                }

                dp[r][c][0] += dp[r - 1][c][0] + dp[r][c - 1][0] - dp[r - 1][c - 1][0];
                dp[r][c][1] += dp[r - 1][c][1] + dp[r][c - 1][1] - dp[r - 1][c - 1][1];
            }
            br.read();
        }
    }
}
