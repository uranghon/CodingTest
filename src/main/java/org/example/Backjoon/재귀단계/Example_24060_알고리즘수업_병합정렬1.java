package org.example.Backjoon.재귀단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 오늘도 서준이는 병합 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 * N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.
 *
 * -입력-
 * 첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 500,000), 저장 횟수 K(1 ≤ K ≤ 10^8)가 주어진다.
 * 다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 10^9)
 *
 * -출력-
 * 배열 A에 K 번째 저장 되는 수를 출력한다. 저장 횟수가 K 보다 작으면 -1을 출력한다.
 *
 * -풀이-
 * 일단 병합정렬 코드가 분할할 파트가 홀수일때는 반 자를 때, 왼쪽이 1개만큼 크다.
 * ex) 길이 5짜리 분할 -> [3,2] -> [[2,1],[1,1]] -> [[[1,1],1],[1,1]]
 * 다 분할 후에 정렬해오면서 카운트 세고, 정렬 횟수가 K에 도달하면 해당하는 시기의 정렬되는 숫자 출력.
 * 다 정렬됐는데 k에 미치지 못했다면 -1 출력
 */
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
