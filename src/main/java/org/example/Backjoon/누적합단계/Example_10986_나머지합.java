package org.example.Backjoon.누적합단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example_10986_나머지합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        mine1(n, m);
        mine2(n, m);
    }

    static void mine1(int n, int m) throws IOException {
        st = new StringTokenizer(br.readLine());
        int[][] arr = new int[n + 1][2]; // 값, 이전위치
        int[] remain = new int[m];
        int[] dp = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = (Integer.parseInt(st.nextToken()) + arr[i - 1][0]) % m;
            arr[i][1] = remain[arr[i][0]];
            remain[arr[i][0]] = i;
            dp[i] = arr[i][0];
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        int[] cnt = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] == 0 || arr[i][1] != 0) {
                cnt[i] = cnt[arr[i][1]] + 1;
            }
        }

        System.out.println(Arrays.toString(cnt));

        long cntSum = 0;
        for (int i = 0; i < cnt.length; i++) {
            cntSum += cnt[i];
        }

        System.out.print(cntSum);
    }

    static void mine2(int n, int m) throws IOException {
        st = new StringTokenizer(br.readLine());
        long[] dp = new long[n + 1];
        int[] remain = new int[m];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Long.parseLong(st.nextToken()) + dp[i - 1];
            remain[(int)(dp[i] % m)]++;
        }

        long cntSum = 0;

        for (int i = 0; i < m; i++) {
            int cnt = remain[i];
            if(i == 0)
            {
                cntSum += cnt * (cnt + 1) / 2;
            }
            else
            {
                cntSum += cnt * (cnt - 1) / 2;
            }
        }

        System.out.print(cntSum);
    }
}
