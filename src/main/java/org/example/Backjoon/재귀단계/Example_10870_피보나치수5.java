package org.example.Backjoon.재귀단계;

import java.util.Scanner;

/**
 * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다.
 * 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 *
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
 *
 * n=17일때 까지 피보나치 수를 써보면 다음과 같다.
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 *
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 */
public class Example_10870_피보나치수5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(setFibonacci(n));

//        int[] fibonacci = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            setFibonacci(fibonacci, i);
//        }
//        System.out.print(fibonacci[n]);
    }

    static int setFibonacci(int n)
    {
        if(n <= 1) return n;
        else return setFibonacci(n - 1) + setFibonacci(n - 2);
    }

    static void setFibonacci(int[] fibonacci, int n)
    {
        if(n <= 1) fibonacci[n] = n;
        else fibonacci[n] = fibonacci[n - 1] + fibonacci[n - 2];
    }
}
