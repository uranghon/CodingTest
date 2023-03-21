package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.Arrays;

public class SortExamples {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[20];
        int[] arr2 = new int[arr.length];
        int[] arr3 = new int[arr.length];
        int[] arr4 = new int[arr.length];
//        int[] test = {28, 14, 29, 29, 23, 14, 13, 3, 4, 28};
        int randomInt = 100;
        int minusNum = 50;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * randomInt) - minusNum;
//            arr[i] = test[i];
            arr2[i] = arr[i];
            arr3[i] = arr[i];
            arr4[i] = arr[i];
        }

        System.out.println(Arrays.toString(arr));
        long l = 0;
        long l2 = 0;

        l = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        l2 = System.currentTimeMillis();
        System.out.println("퀵정렬 : " + Arrays.toString(arr));
//        System.out.println("퀵정렬  : " + (l2 - l));

        l = System.currentTimeMillis();
        selectionSort(arr2);
        l2 = System.currentTimeMillis();
        System.out.println("선택정렬 : " + Arrays.toString(arr2));
//        System.out.println("선택정렬 : " + (l2 - l));

//        l = System.currentTimeMillis();
//        bubbleSort(arr3);
//        l2 = System.currentTimeMillis();
//        System.out.println("버블정렬 : " + Arrays.toString(arr3));
//        System.out.println("버블정렬 : " + (l2 - l));

        l = System.currentTimeMillis();
        insertSort(arr4);
        l2 = System.currentTimeMillis();
        System.out.println("삽입정렬 : " + Arrays.toString(arr4));
//        System.out.println("삽입정렬 : " + (l2 - l));

        l = System.currentTimeMillis();
        countingSort(arr3, 0 - minusNum, randomInt - minusNum);
        l2 = System.currentTimeMillis();
        System.out.println("카운팅 : " + Arrays.toString(arr3));
//        System.out.println("카운팅  : " + (l2 - l));
    }

    // 병합 <= 퀵 <= 힙 < 삽입 <= 선택 <= 버블
    // 카운팅은 논외. 일반적으로는 제일 빠름

    //퀵 정렬
    // 수행 속도 평균 빠른 순 : 퀵정렬 - 퀵정렬3 - 퀵정렬2
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

        while (chkEqualPivot >= fr) {
            if (arr[chkEqualPivot] == arr[pivot]) {
                int tmp = arr[chkEqualPivot];
                arr[chkEqualPivot] = arr[pivotLeft];
                arr[pivotLeft] = tmp;
                pivotLeft--;
            }
            chkEqualPivot--;
        }

        chkEqualPivot = pivotRight;

        while (chkEqualPivot <= to) {
            if (arr[chkEqualPivot] == arr[pivot]) {
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
        while (idxLeft >= fr && idxRight <= to) {
            if (arr[idxLeft] > arr[pivot]) chkLeft = true;
            else idxLeft--;

            if (arr[idxRight] < arr[pivot]) chkRight = true;
            else idxRight++;

            if (chkLeft && chkRight) {
                int tmp = arr[idxRight];
                arr[idxRight] = arr[idxLeft];
                arr[idxLeft] = tmp;
                idxLeft--;
                idxRight++;

                chkLeft = false;
                chkRight = false;
            }
        }

        while (idxLeft >= fr) {
            if (arr[idxLeft] > arr[pivot]) {
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

        while (idxRight <= to) {
            if (arr[idxRight] < arr[pivot]) {
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
            if (arr[chkPivotEqual] == arr[pivot]) {
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

            if (chkLeft && chkRight) {
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

            if (arr[idxRight] == tmp) {
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

    /** 선택 정렬(Selection Sort)
     *  배열에서 최솟값을 찾아 정렬하는것을 반복하는 방법.
     *  한바퀴에 1개씩 정렬된다.
     *  n, n-1, n-2, ... , 1 번 수행된다.
     *  (n+1)*n/2
     */
    static void selectionSort(int[] arr) {
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

    //버블 정렬
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //삽입 정렬
    static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                for (int j = i; j >= 1; j--) {
                    if (arr[j] >= arr[j - 1]) break;

                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }


    /** 병합 정렬
     * 1. 반으로 짜르기를 길이 1인 배열로 될 때까지 쪼갠다.
     * 2. 인접한 배열(짤리기 전 함께했던 배열)과 정렬하며 합병 하는 방식이다.
     * 3. 아래서 올라온 애들은 이미 반반은 정렬되어있으므로 왼쪽꺼 오른쪽꺼 맨 앞부터 서로 비교하면서 작은걸 앞으로 보내는 정렬을 한다
     *
     * n -> 1 이 될때까지 2로 x번 나누면 된다. x = log_2(n) 이다.
     * x 는 곧 계층의 갯수를 의미하고, 각 계층에서 비교되는 횟수는 원소의 갯수 n이니까
     * nlog_2(n) 의 시간복잡도를 갖는다.
     *
     * 그리고 안정적인 정렬이다.
     * -> 원배열에서 동일 key값을 가진 원소들의 순서를 정렬 후에도 유지한다.
     */
    static void mergeSort(int[] arr, int fr, int to) {
        if (fr == to) return;

        int mid = fr / 2 + to / 2;

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
                arr[cur++] = tmpArr[left++];
            } else if (tmpArr[left] < tmpArr[right]) { // left 부분 값 넣기.
                arr[cur++] = tmpArr[left++];
            } else if (tmpArr[left] > tmpArr[right]) { // rigth 부분 값 넣기.
                arr[cur++] = tmpArr[right++];
            } else { // left 부분 값이랑 rigth 부분 값 cur 랑 cur + 1 위치에 넣가.
                arr[cur++] = tmpArr[left++];
                arr[cur++] = tmpArr[right++];
            }
        }
    }

    /**
     * 카운팅 정렬
     * arr : 정렬할 배열
     * min, max : arr 내에 들어있는 데이터의 범위
     */
    static void countingSort(int[] arr, int min, int max) {
        //fr ~ to 는 arr 내에 들어있는 데이터의 범위
        int[] iArr = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            iArr[arr[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr[i]; j++) {
                arr[index++] = i + min;
            }
        }
    }

    static void heapSort(int[] arr) {
        int[] heapArr = new int[arr.length];

        long l = 0;
        long l2 = 0;

        l = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            heapArr[i] = arr[i];
            makeMinHeapChkParent(heapArr, i);
        }
        l2 = System.currentTimeMillis();

        System.out.println("최소힙만들기  : " + (l2 - l));

        int maxIdx = heapArr.length - 1;

        l = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heapArr[0];

            heapArr[0] = heapArr[maxIdx];
            maxIdx--;
            makeMinHeapChkChild(heapArr, 0, maxIdx);
        }
        l2 = System.currentTimeMillis();
        System.out.println("힙정렬하기  : " + (l2 - l));
    }

    static void makeMinHeapChkParent(int[] heapArr, int curIdx) {
        if (curIdx == 0) return;
        int parentIdx = (curIdx - 1) / 2;
        if (heapArr[curIdx] < heapArr[parentIdx]) {
            int tmp = heapArr[curIdx];
            heapArr[curIdx] = heapArr[parentIdx];
            heapArr[parentIdx] = tmp;
            makeMinHeapChkParent(heapArr, parentIdx);
        }
    }

    static void makeMinHeapChkChild(int[] heapArr, int curIdx, int maxIdx) {
        int leftChildIdx = (curIdx * 2) + 1;
        int rightChildIdx = (curIdx * 2) + 2;

        int smallestIdx = curIdx;

        if (maxIdx == leftChildIdx) {
            if (heapArr[leftChildIdx] < heapArr[curIdx]) {
                smallestIdx = leftChildIdx;
            }
        } else if (maxIdx >= rightChildIdx) {
            if (heapArr[leftChildIdx] <= heapArr[rightChildIdx]) {
                if (heapArr[leftChildIdx] < heapArr[curIdx]) {
                    smallestIdx = leftChildIdx;
                }
            } else {
                if (heapArr[rightChildIdx] < heapArr[curIdx]) {
                    smallestIdx = rightChildIdx;
                }
            }
        }

        if (smallestIdx > curIdx) {
            int tmp = heapArr[curIdx];
            heapArr[curIdx] = heapArr[smallestIdx];
            heapArr[smallestIdx] = tmp;
            makeMinHeapChkChild(heapArr, smallestIdx, maxIdx);
        }
    }

}
