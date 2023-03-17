package org.example.Backjoon.정렬단계;

import java.io.*;

public class Example_2751_수정렬하기2 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] iArr;
    private static int[] tmpArr;

    // -1_000_000 ~ 0 ~ 1_000_000 까지 받기 위해 2_000_001 크기 배열
    static boolean[] othersArr = new boolean[2_000_001];
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        iArr = new int[n];
        tmpArr = new int[n];
        for (int i = 0; i < n; i++) {
            iArr[i] = Integer.parseInt(br.readLine());
            othersArr[iArr[i] + 1_000_000] = true;
        }

        mine();
        // 똑똑하네. 이런걸 기억해야겠다. 수 중복이면 boolean 형 말고 int 형으로 하면 됨.
        // 받고 정렬하는게 아니라 받으면서 맞는 위치에 넣으면 되네
        // 다른것도 마찬가지 가능할듯
        // 이게 Counting Sort 구나
        others();

        bw.close();
        br.close();
    }

    static void others() throws IOException {

        for (int i = 0; i < othersArr.length; i++) {
            if(othersArr[i]) bw.write((i - 1_000_000) + "\n");
        }
//        bw.flush();

    }

    static void mine() throws IOException {
        mergeSort(0, iArr.length - 1);
        for (int i : iArr) {
            bw.write(i + "\n");
        }
//        bw.flush();
    }

    static void mergeSort(int fr, int to) {
        if(fr == to) return;

        int mid = (fr + to) / 2;
        mergeSort(fr, mid);
        mergeSort(mid+ 1, to);

        for (int i = fr; i <= to; i++) {
            tmpArr[i] = iArr[i];
        }

        int left = fr;
        int right = mid + 1;
        int cur = fr;

        while (left <= mid && right <= to)
        {
            if(tmpArr[left] < tmpArr[right])
            {
                iArr[cur++] = tmpArr[left++];
            }
            else if(tmpArr[left] > tmpArr[right])
            {
                iArr[cur++] = tmpArr[right++];
            }
            else
            {
                iArr[cur++] = tmpArr[left++];
                iArr[cur++] = tmpArr[right++];
            }
        }

        while (left <= mid)
        {
            iArr[cur++] = tmpArr[left++];
        }
    }
}
