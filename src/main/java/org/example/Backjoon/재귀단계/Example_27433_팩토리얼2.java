package org.example.Backjoon.재귀단계;

import java.util.Scanner;

public class Example_27433_팩토리얼2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.print(factorial(n));
    }

    static long factorial(long n)
    {
        if(n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
