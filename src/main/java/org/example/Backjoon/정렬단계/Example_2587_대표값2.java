package org.example.Backjoon.정렬단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;

/**
 * 어떤 수들이 있을 때, 그 수들을 대표하는 값으로 가장 흔하게 쓰이는 것은 평균이다. 평균은 주어진 모든 수의 합을 수의 개수로 나눈 것이다.
 * 예를 들어 10, 40, 30, 60, 30의 평균은 (10 + 40 + 30 + 60 + 30) / 5 = 170 / 5 = 34가 된다.
 *
 * 평균 이외의 또 다른 대표값으로 중앙값이라는 것이 있다. 중앙값은 주어진 수를 크기 순서대로 늘어 놓았을 때 가장 중앙에 놓인 값이다.
 * 예를 들어 10, 40, 30, 60, 30의 경우, 크기 순서대로 늘어 놓으면
 *
 * 10 30 30 40 60
 *
 * 이 되고 따라서 중앙값은 30이 된다.
 * 다섯 개의 자연수가 주어질 때 이들의 평균과 중앙값을 구하는 프로그램을 작성하시오.
 *
 * -입력-
 * 첫째 줄부터 다섯 번째 줄까지 한 줄에 하나씩 자연수가 주어진다. 주어지는 자연수는 100 보다 작은 10의 배수이다.
 *
 * -출력-
 * 첫째 줄에는 평균을 출력하고, 둘째 줄에는 중앙값을 출력한다. 평균과 중앙값은 모두 자연수이다.
 *
 * -풀이-
 * 뭐 평균은 다 더해서 5로 나누면 되고, 핵심은 중간값
 * 1. 정렬하고 중간거
 * 2. 입력값이 100보다 작은 10의 배수니까 10보다 작은 1의 배수로 봐도 됨. 카운팅정렬로 가즈아
 *
 */
public class Example_2587_대표값2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] iArr = new int[5];
        int[] tmpArr = new int[5];
        int sum = 0;
        for(int i = 0; i < 5;i++)
        {
            iArr[i] = Integer.parseInt(br.readLine());
            sum += iArr[i];
        }

        mergeSort(iArr, tmpArr, 0, 4);
        System.out.print(sum/5 + "\n" + iArr[2]);
        br.close();
    }

    static void mergeSort(int[] arr, int[] tmpArr, int fr, int to) {
        if(fr == to) return;

        int mid = (fr + to) / 2;
        mergeSort(arr, tmpArr, fr, mid);
        mergeSort(arr, tmpArr, mid+ 1, to);

        for (int i = fr; i <= to; i++) {
            tmpArr[i] = arr[i];
        }

        int left = fr;
        int right = mid + 1;
        int cur = fr;

        while (left <= mid || right <= to)
        {
            if(left > mid) break;
            else if (right > to)
            {
                arr[cur++] = tmpArr[left++];
            }
            else if(tmpArr[left] < tmpArr[right])
            {
                arr[cur++] = tmpArr[left++];
            }
            else if(tmpArr[left] > tmpArr[right])
            {
                arr[cur++] = tmpArr[right++];
            }
            else
            {
                arr[cur++] = tmpArr[left++];
                arr[cur++] = tmpArr[right++];
            }
        }
    }
}
