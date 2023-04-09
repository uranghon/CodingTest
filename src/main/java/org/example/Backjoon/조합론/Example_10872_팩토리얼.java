package org.example.Backjoon.조합론;

import java.util.Scanner;

/**
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 */
public class Example_10872_팩토리얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(factorial(sc.nextInt()));
    }

    static int factorial(int n) {
        if(n <= 1) return 1;
        else return n * factorial(n -1);
    }
}
