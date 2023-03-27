package org.example.Backjoon.백트래킹단계;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 자연수 N과 M이 주어졌을 때,
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 조합을 모두 구하는 프로그램을 작성하시오.
 * 고른 조합은 오름차순이어야 한다.
 */
public class Example_15650_N과M_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
//        combination(n, m, 1, 0);
        combination2(n, m, 1, 0);
        System.out.print(sb);
    }

    static void combination(int n, int m, int fr, int idx) {
        if (m == 0) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = fr; i <= n - m + 1; i++) {
            arr[idx] = i;
            combination(n, m - 1, i + 1, idx + 1);
        }
    }

    static void combination2(int n, int m, int fr, int idx) {
        if (m == 0) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        if (fr > n) return;
        arr[idx] = fr;
        combination2(n, m - 1, fr + 1, idx + 1);
        combination2(n, m, fr + 1, idx);
    }
}
