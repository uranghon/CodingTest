package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.Arrays;

public class SortExamples {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10_000_000];
        int[] arr2 = new int[arr.length];
        int[] arr3 = new int[arr.length];
//        int[] test = {28, 14, 29, 29, 23, 14, 13, 3, 4, 28};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1_000_000);
//            arr[i] = test[i];
            arr2[i] = arr[i];
            arr3[i] = arr[i];
        }

//        System.out.println(Arrays.toString(arr));

        long l = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long l2 = System.currentTimeMillis();
//        System.out.println("퀵정렬  : " + Arrays.toString(arr));
        System.out.println("퀵정렬  : " + (l2 - l));

        l = System.currentTimeMillis();
        quickSort2(arr2, 0, arr2.length - 1);
        l2 = System.currentTimeMillis();
//        System.out.println("퀵정렬2 : " + Arrays.toString(arr2));
        System.out.println("퀵정렬2 : " + (l2 - l));

        l = System.currentTimeMillis();
        quickSort3(arr3, 0, arr3.length - 1);
        l2 = System.currentTimeMillis();
//        System.out.println("퀵정렬3 : " + Arrays.toString(arr3));
        System.out.println("퀵정렬3 : " + (l2 - l));

        // 수행 속도 평균 빠른 순 : 퀵정렬 - 퀵정렬3 - 퀵정렬2
    }
    //퀵 정렬
    static void quickSort(int[] arr, int fr, int to) {
        if (to - fr < 1) return;

        int[] arr2 = Arrays.copyOfRange(arr, fr, to + 1);
        int pivot = arr2[arr2.length / 2];
        int start = fr;
        int end = to;
        int pivotCnt = 0; // pivot 랑 같은 수가 몇번 나오는지 체크

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < pivot) {
                arr[start++] = arr2[i];
            } else if (arr2[i] > pivot) {
                arr[end--] = arr2[i];
            } else pivotCnt++;
        }

        while (pivotCnt-- > 0) {
            arr[start + pivotCnt] = pivot;
        }

        quickSort(arr, fr, start - 1);
        quickSort(arr, end + 1, to);
    }

    //퀵 정렬 2
    static void quickSort2(int[] arr, int fr, int to) {
        if (fr >= to) return;

        int pivot = (fr + to) / 2;
        int pivotLeft = pivot - 1;
        int pivotRight = pivot + 1;

        int chkEqualPivot = pivotLeft;

        while(chkEqualPivot >= fr)
        {
            if(arr[chkEqualPivot] == arr[pivot])
            {
                int tmp = arr[chkEqualPivot];
                arr[chkEqualPivot] = arr[pivotLeft];
                arr[pivotLeft] = tmp;
                pivotLeft--;
            }
            chkEqualPivot--;
        }

        chkEqualPivot = pivotRight;

        while(chkEqualPivot <= to)
        {
            if(arr[chkEqualPivot] == arr[pivot])
            {
                int tmp = arr[chkEqualPivot];
                arr[chkEqualPivot] = arr[pivotRight];
                arr[pivotRight] = tmp;
                pivotRight++;
            }
            chkEqualPivot++;
        }

        int idxLeft = pivotLeft;
        int idxRight = pivotRight;

        boolean chkLeft = false;
        boolean chkRight = false;
        // 28 14 29 29 / 23 / 14 13 3 4 12
        // 28 14 29 29 / 23 / 14 13 3 4 12
        while(idxLeft >= fr && idxRight <= to)
        {
            if(arr[idxLeft] > arr[pivot]) chkLeft = true;
            else idxLeft--;

            if(arr[idxRight] < arr[pivot]) chkRight = true;
            else idxRight++;

            if(chkLeft && chkRight)
            {
                int tmp = arr[idxRight];
                arr[idxRight] = arr[idxLeft];
                arr[idxLeft] = tmp;
                idxLeft--;
                idxRight++;

                chkLeft = false;
                chkRight = false;
            }
        }

        while(idxLeft >= fr)
        {
            if(arr[idxLeft] > arr[pivot])
            {
                int tmp = arr[pivotLeft];
                arr[pivotLeft] = arr[idxLeft];
                arr[idxLeft] = tmp;

                tmp = arr[pivotLeft];
                arr[pivotLeft] = arr[pivotRight - 1];
                arr[pivotRight - 1] = tmp;

                pivot--;
                pivotLeft--;
                pivotRight--;
            }
            idxLeft--;
        }

        while(idxRight <= to)
        {
            if(arr[idxRight] < arr[pivot])
            {
                int tmp = arr[pivotRight];
                arr[pivotRight] = arr[idxRight];
                arr[idxRight] = tmp;

                tmp = arr[pivotRight];
                arr[pivotRight] = arr[pivotLeft + 1];
                arr[pivotLeft + 1] = tmp;

                pivot++;
                pivotLeft++;
                pivotRight++;
            }

            idxRight++;
        }

        quickSort2(arr, fr, pivotLeft);
        quickSort2(arr, pivotRight, to);
    }

    //퀵 정렬 3
    static void quickSort3(int[] arr, int fr, int to) {
        if (fr >= to) return;

        int pivot = fr;
        int chkPivotEqual = fr + 1;
        int pivotRight = fr + 1;

        while (chkPivotEqual <= to) {
            if(arr[chkPivotEqual] == arr[pivot])
            {
                int tmp = arr[chkPivotEqual];
                arr[chkPivotEqual] = arr[pivotRight];
                arr[pivotRight++] = tmp;
            }
            chkPivotEqual++;
        }

        int idxLeft = pivotRight;
        int idxRight = to;

        boolean chkLeft = false;
        boolean chkRight = false;

        while (idxLeft <= idxRight) {
            if (arr[idxLeft] > arr[pivot]) chkLeft = true;
            else idxLeft++;

            if (arr[idxRight] < arr[pivot]) chkRight = true;
            else idxRight--;

            if(chkLeft && chkRight)
            {
                int tmp = arr[idxLeft];
                arr[idxLeft] = arr[idxRight];
                arr[idxRight] = tmp;
                idxLeft++;
                idxRight--;
                chkLeft = false;
                chkRight = false;
            }
        }

        int pivotCnt = pivotRight - pivot;

        pivotRight = idxRight + 1;

        for (int i = 0; i < pivotCnt; i++) {
            int tmp = arr[pivot + i];

            if(arr[idxRight] == tmp)
            {
                idxRight = pivot + i - 1;
                break;
            }

            arr[pivot + i] = arr[idxRight];
            arr[idxRight] = tmp;
            idxRight--;
        }

        pivot = idxRight + 1;

        quickSort3(arr, fr, pivot - 1);
        quickSort3(arr, pivotRight, to);
    }

    //버블 정렬
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

    //카운팅 정렬
    static void countingSort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] iArr = new int[10001];

        for (int i = 0; i < n; i++) {
            iArr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr[i]; j++) {
                bw.write(i + "\n");
            }
        }

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < iArr.length; i++) {
//            if (iArr[i] > 0) {
//                sb.append((i + "\n").repeat(iArr[i]));
//            }
//        }
//        System.out.print(sb);
        bw.close();
        br.close();
    }
}
