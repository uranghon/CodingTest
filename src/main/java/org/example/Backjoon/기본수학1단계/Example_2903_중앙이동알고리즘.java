package org.example.Backjoon.기본수학1단계;

import java.util.Scanner;

public class Example_2903_중앙이동알고리즘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = 2;
        for (int i = 0; i < n; i++) {
            p += p - 1;
            // p = p * 2 - 1;
        }
        System.out.print(p * p);
    }
}
