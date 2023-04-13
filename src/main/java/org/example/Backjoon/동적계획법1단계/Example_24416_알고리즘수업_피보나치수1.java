package org.example.Backjoon.동적계획법1단계;

import java.util.Scanner;

/**
 * 오늘도 서준이는 동적 프로그래밍 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 *
 * 오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다.
 * 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자. 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
 *
 * 피보나치 수 재귀호출 의사 코드는 다음과 같다.
 * fib(n) {
 *     if (n = 1 or n = 2)
 *     then return 1;  # 코드1
 *     else return (fib(n - 1) + fib(n - 2));
 * }
 *
 * 피보나치 수 동적 프로그래밍 의사 코드는 다음과 같다.
 * fibonacci(n) {
 *     f[1] <- f[2] <- 1;
 *     for i <- 3 to n
 *         f[i] <- f[i - 1] + f[i - 2];  # 코드2
 *     return f[n];
 * }
 *
 * 첫째 줄에 n(5 ≤ n ≤ 40)이 주어진다.
 *
 * 코드1 코드2 실행 횟수를 한 줄에 공백을 두고 출력한다.
 *
 * -풀이-
 * 1. 두 코드에 각각 cnt 체크하는거 떄려넣기
 * 2. 잘 생각해보면 코드1 의 실행 횟수는 피보나치수열 n번째의 값과 같다.
 *    코드2 의 실행횟수는 n-2 이다.
 *    따라서 출력값은 동적 프로그래밍 코드를 돌린 리턴값 + " " + n-2 이다.
 */
public class Example_24416_알고리즘수업_피보나치수1 {
    static int cnt1 = 0;
    static int cnt2 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(fib(n));
//        System.out.println(fibonacci(n));
        System.out.println(fibonacci(n) + " " + cnt2);
    }

    static int fib(int n) {
        if (n == 1 || n == 2)
        {
            cnt1++;
            return 1;
        }
        else return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        int[] f = new int[n];
        f[0] = f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            cnt2++;
        }
        return f[n - 1];
    }
}
