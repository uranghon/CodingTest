package org.example.Backjoon.동적계획법1단계;

import java.util.Scanner;

public class Example_10844_쉬운계단수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][10];
        for (int i = 1; i < 10; i++) {
            dp[0][i]++;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) dp[i][j] = dp[i-1][1];
                else if(j == 9) dp[i][j] = dp[i-1][8];
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n - 1][i];
        }

        System.out.print(sum % 1_000_000_000);
    }
}
