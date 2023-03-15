package org.example.Backjoon.정렬단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;

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
