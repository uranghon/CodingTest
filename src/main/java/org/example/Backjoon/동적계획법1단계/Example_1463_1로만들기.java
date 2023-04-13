package org.example.Backjoon.동적계획법1단계;

import java.util.Scanner;

/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 *
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
public class Example_1463_1로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int[] arr = new int[n + 1];
        arr[0] = -1;

        for (int i = 1; i <= n; i++) {
//            if(i % 6 == 0)
//            {
//                arr[i] = Math.min(Math.min(arr[i / 3], arr[i / 2]), arr[i - 1])  + 1;
//            }
//            else if(i % 3 == 0)
//            {
//                arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1;
//            } else if (i % 2 == 0) {
//                arr[i] = Math.min(arr[i / 2], arr[i - 1]) + 1;
//            }
//            else {
//                arr[i] = arr[i - 1] + 1;
//            }

            arr[i] = arr[i - 1] + 1;

            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }

            if(i % 3 == 0)
            {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
        }
        System.out.print(arr[n]);
    }
}
