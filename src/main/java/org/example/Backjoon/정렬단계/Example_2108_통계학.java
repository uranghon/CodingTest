package org.example.Backjoon.정렬단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = -4000;
        int max = 4000;
        int[] cntArr = new int[max - min + 1];
        int sum = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num =Integer.parseInt(br.readLine());
            cntArr[num - min]++;
            sum += num;
        }

        int mid = 0;

        int fr = 0;
        int to = 0;

        int cntMax = 0;
        int cntMax1Idx = min - 1;
        int cntMax2Idx = min - 1;
        int idx = 0;

        for (int i = 0; i < cntArr.length; i++) {
            if(cntArr[i] > 0)
            {
                if(cntMax < cntArr[i])
                {
                    cntMax = cntArr[i];
                    cntMax1Idx = i + min;
                    cntMax2Idx = min - 1;
                } else if (cntMax == cntArr[i] && cntMax2Idx == min - 1) {
                    cntMax2Idx = i + min;
                }

                for (int j = 0; j < cntArr[i]; j++) {
                    if(idx == 0)
                    {
                        fr = i + min;
                    }

                    if(idx == n - 1)
                    {
                        to = i + min;
                    }

                    if(idx == n / 2)
                    {
                        mid = i + min;
                    }

                    idx++;
                }
            }
        }

        System.out.println(Math.round((double) sum / n));
        System.out.println(mid);
        System.out.println(cntMax2Idx > min - 1 ? cntMax2Idx : cntMax1Idx);
        System.out.print(to - fr);
    }

    static int countingSort_And_cntMax(int[] arr, int[] cntArr, int min, int max) {
        int cntMax = 0;
        int cntMax1Idx = min - 1;
        int cntMax2Idx = min - 1;
        int idx = 0;

        for (int i = 0; i < cntArr.length; i++) {
            if(cntArr[i] > 0)
            {
                if(cntMax < cntArr[i])
                {
                    cntMax = cntArr[i];
                    cntMax1Idx = i + min;
                    cntMax2Idx = min - 1;
                } else if (cntMax == cntArr[i] && cntMax2Idx == min - 1) {
                    cntMax2Idx = i + min;
                }

                for (int j = 0; j < cntArr[i]; j++) {
                    arr[idx++] = i + min;
                }
            }
        }

        return cntMax2Idx > min - 1 ? cntMax2Idx : cntMax1Idx;
    }
}
