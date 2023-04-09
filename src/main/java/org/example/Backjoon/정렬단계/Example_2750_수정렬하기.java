package org.example.Backjoon.정렬단계;

import javax.xml.stream.events.StartDocument;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * -입력-
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
 * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 * -출력-
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * -풀이-
 * 1. 카운팅정렬
 * 2. 그냥 정렬
 */
public class Example_2750_수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] iArr = new int[n];

//        for (int i = 0; i < n; i++) {
//            iArr[i] = Integer.parseInt(br.readLine());
//        }

        for (int i = 0; i < n; i++) {
            iArr[i] = n - i;
        }

        try {
            long start = System.currentTimeMillis();
            quickSort(iArr, 0, n - 1);
            long end = System.currentTimeMillis();
            System.out.println("퀵정렬 : " + (end - start));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        for (int i : iArr) {
//            bw.write(i + "\n");
//        }
//
//        bw.close();
        br.close();

//        int[] iArr2 = new int[n];
//        for (int i = 0; i < n; i++) {
//            iArr2[i] = n - i;
//        }

//        try {
//            long start = System.currentTimeMillis();
//            bubbleSort(iArr2);
//            long end = System.currentTimeMillis();
//            System.out.println("버블정렬 : " + (end - start));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//        }

        int[] iArr3 = new int[n];
        for (int i = 0; i < n; i++) {
            iArr3[i] = n - i;
        }

//        System.out.println(Arrays.toString(iArr3));
//        mergeSort(iArr3, 0, n - 1);
//        System.out.println(Arrays.toString(iArr3));
        try {
            long start = System.currentTimeMillis();
            mergeSort(iArr3, 0, n - 1);
            long end = System.currentTimeMillis();
            System.out.println("병합정렬 : " + (end - start));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 퀵정렬
    static void quickSort(int[] arr, int fr, int to) {
        if (to - fr < 1) return;

        int[] arr2 = Arrays.copyOfRange(arr, fr, to + 1);
        int mid = arr2[arr2.length / 2];
        int start = fr;
        int end = to;
        int midCnt = 0; // mid 랑 같은 수가 몇번 나오는지 체크

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < mid) {
                arr[start] = arr2[i];
                start++;
            } else if (arr2[i] > mid) {
                arr[end] = arr2[i];
                end--;
            } else midCnt++;
        }

        while (midCnt-- > 0) {
            arr[start + midCnt] = mid;
        }

        quickSort(arr, fr, start - 1);
        quickSort(arr, end + 1, to);
    }

    //버블정렬
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }

    //병합 정렬
    static void mergeSort(int[] arr, int fr, int to) {
        if (fr == to) return;

        int mid = (fr + to) / 2;
        // 분할하는 부분
        mergeSort(arr, fr, mid);
        mergeSort(arr, mid + 1, to);


        // 정렬하는 부분.
        int[] tmpArr = Arrays.copyOfRange(arr, fr, to + 1);
        int left = 0;
        int right = mid + 1 - fr;
        int cur = fr;

        while (left <= mid - fr || right <= to - fr) {
            if (left > mid - fr) break; // left 가 넘어가면 어짜피 남은 right 부분은 전부 left 보다 큼.
            else if (right > to - fr) { // rigth 가 넘어가면 남은 left 부분을 cur 뒤에 추가.
                arr[cur] = tmpArr[left];
                cur++;
                left++;
            } else if (tmpArr[left] < tmpArr[right]) { // left 부분 값 넣기.
                arr[cur] = tmpArr[left];
                cur++;
                left++;
            } else if (tmpArr[left] > tmpArr[right]) { // rigth 부분 값 넣기.
                arr[cur] = tmpArr[right];
                cur++;
                right++;
            } else { // left 부분 값이랑 rigth 부분 값 cur 랑 cur + 1 위치에 넣가.
                arr[cur] = tmpArr[left];
                cur++;
                arr[cur] = tmpArr[right];
                cur++;
                left++;
                right++;
            }
        }
    }
}
