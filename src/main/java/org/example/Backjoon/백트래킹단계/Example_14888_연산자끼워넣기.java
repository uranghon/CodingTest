package org.example.Backjoon.백트래킹단계;

import java.io.*;
import java.util.StringTokenizer;

public class Example_14888_연산자끼워넣기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] arr;
    static int plusCnt;
    static int minusCnt;
    static int multiplyCnt;
    static int divideCnt;
    static int[] operator = new int[4];
    static int value;
    static int max = -1_000_000_000;;
    static int min = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        plusCnt = Integer.parseInt(st.nextToken());
        minusCnt = Integer.parseInt(st.nextToken());
        multiplyCnt = Integer.parseInt(st.nextToken());
        divideCnt = Integer.parseInt(st.nextToken());
        operator[0] = plusCnt;
        operator[1] = minusCnt;
        operator[2] = multiplyCnt;
        operator[3] = divideCnt;
        value = arr[0];
//        dfs(1);
        dfs2(1);
        System.out.print(max + "\n" + min);
    }

    static void dfs(int idx) {
        if(idx == n)
        {
            min = Math.min(value, min);
            max = Math.max(value, max);
            return;
        }

        if(plusCnt > 0){
            int tmp = value;
            value += arr[idx];
            plusCnt--;
            dfs(idx + 1);
            value = tmp;
            plusCnt++;
        }

        if(minusCnt > 0){
            int tmp = value;
            value -= arr[idx];
            minusCnt--;
            dfs(idx + 1);
            value = tmp;
            minusCnt++;
        }

        if(multiplyCnt > 0){
            int tmp = value;
            value *= arr[idx];
            multiplyCnt--;
            dfs(idx + 1);
            value = tmp;
            multiplyCnt++;
        }

        if(divideCnt > 0){
            int tmp = value;
            value /= arr[idx];
            divideCnt--;
            dfs(idx + 1);
            value = tmp;
            divideCnt++;
        }
    }

    static void dfs2(int idx) {
        if(idx == n)
        {
            min = Math.min(value, min);
            max = Math.max(value, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operator[i] == 0) continue;

            int tmp = value;
            switch (i) {
                case 0:
                    value += arr[idx];
                    break;
                case 1:
                    value -= arr[idx];
                    break;
                case 2:
                    value *= arr[idx];
                    break;
                case 3:
                    value /= arr[idx];
                    break;
            }
            operator[i]--;
            dfs2(idx + 1);
            operator[i]++;
            value = tmp;
        }
    }
}
