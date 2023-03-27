package org.example.Backjoon.백트래킹단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_15651_N과M_3 {
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

        for (int i = 1; i <= n; i++) {
            arr[idx] = i;
            dfs(idx + 1);
        }
    }
}
