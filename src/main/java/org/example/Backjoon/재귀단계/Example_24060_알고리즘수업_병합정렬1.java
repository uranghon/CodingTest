package org.example.Backjoon.재귀단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example_24060_알고리즘수업_병합정렬1 {
    static int k = 0;
    static int num = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(A, 0, n - 1);
        System.out.print(num);
//        System.out.print(Arrays.toString(A));
    }

    static void merge_sort(int[] A, int p, int r) { // A[p..r]을 오름차순 정렬한다.
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(A, p, q);
            if(k == 0) return;
            merge_sort(A, q + 1, r);
            if(k == 0) return;
            merge(A, p, q, r);
        }
    }

    // A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
    // A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
    static void merge(int[] A, int p, int q, int r) {
        int i = p, j = q + 1, t = 0;
        int[] tmp = Arrays.copyOfRange(A, p, q + 1);
        while (t <= q - p && j <= r) {
            if (tmp[t] <= A[j]) A[i++] = tmp[t++];
            else A[i++] = A[j++];

            if(k-- == 1)
            {
                num = A[i - 1];
                return;
            }
        }

        while (t <= q - p) { // 왼쪽 배열 부분이 남은 경우
            A[i++] = tmp[t++];
            if(k-- == 1)
            {
                num = A[i - 1];
                return;
            }
        }
        while (j++ <= r) { // 왼쪽 배열 부분이 남은 경우
            if(k-- == 1)
            {
                num = A[j - 1];
                return;
            }
        }
    }
}
