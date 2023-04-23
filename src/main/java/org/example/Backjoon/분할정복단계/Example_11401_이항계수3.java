package org.example.Backjoon.분할정복단계;

import java.util.Scanner;

public class Example_11401_이항계수3 {

    static long mod = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long num1 = factorial(n);
        long num2 = factorial(n - k);
        long num3 = factorial(k);

        num2 = splitPow(num2, mod - 2);
        num3 = splitPow(num3, mod - 2);
        System.out.print(((num1 * num2) % mod * num3) % mod);
    }

    static long comb(int n, int k) {
        if (n == k || k == 0) return 1;
        else if (k == 1 || n - k == 1) {
            return n;
        } else {
            return (comb(n - 1, k - 1) * n / k) % 1_000_000_007;
        }
    }

    static long factorial(int n) {
        long num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
            num %= mod;
        }
        return num;
    }

    static long splitPow(long a, long b) {
        if (b == 1) {
            return a;
        } else {
            long num = splitPow(a, b / 2);
            if (b % 2 == 0) return num * num % mod;
            else return ((num * num) % mod * (a % mod)) % mod;
        }
    }
}
