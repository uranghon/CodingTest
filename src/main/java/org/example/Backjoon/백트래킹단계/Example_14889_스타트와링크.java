package org.example.Backjoon.백트래킹단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example_14889_스타트와링크 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] arr;
    static int startCnt = 1;
    static int min;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int iStart = 1;
        int iLink = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(i < j) arr[i][j] += num;
                else arr[j][i] += num;
                min += num;
            }
        }

        dfs(iStart, iLink, 1);
        System.out.print(min);
    }

    static void dfs(int start, int link, int col) {
        if(startCnt < n / 2)
        {
            for (int i = col; i < n; i++) {
                if((start & 1 << i) == 0)
                {
                    start |= 1 << i;
                    startCnt++;
                    dfs(start, link, i + 1);
                    startCnt--;
                    start ^= 1 << i;
                }
            }
        }
        else
        {
            for (int i = 1; i < n; i++) {
                if((start & 1 << i) == 0) link |= 1 << i;
            }
            int diff = Math.abs(sumStat(start) - sumStat(link));
            min = Math.min(min, diff);
        }
    }

    static int sumStat(int team) {
        int row = 0;
        int col = 0;
        int stat = 0;

        for (int i = 0; i < n; i++) {
            if((team & 1 << i) > 0)
            {
                row = i;
                for (int j = i + 1; j < n; j++) {
                    if((team & 1 << j) > 0)
                    {
                        col = j;
                        stat += arr[row][col];
                    }
                }
            }
        }

        return stat;
    }
}
