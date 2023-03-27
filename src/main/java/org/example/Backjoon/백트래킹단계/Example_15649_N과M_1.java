package org.example.Backjoon.백트래킹단계;

import java.io.*;
import java.util.*;

/**
 * 자연수 N과 M이 주어졌을 때,
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 순열을 모두 구하는 프로그램을 작성하시오.
 */
public class Example_15649_N과M_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static boolean[] checked;
    static int m;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        checked = new boolean[n];
        Permutation(n,0);
        bw.flush();
    }

    static void Permutation(int n, int idx) throws IOException {
        if (idx == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checked[i]) continue;

            checked[i] = true;
            arr[idx] = i + 1;
            Permutation(n,idx + 1);
            checked[i] = false;
        }
    }
}

