package org.example.Backjoon.조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_11050_이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
//        System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));
        System.out.println(comb(n, k));
    }

    static long factorial(int num) {
        if(num == 0) return 1;
        return num * factorial(num - 1);
    }

    static int comb(int n, int k) {
        if (n == k) return 1;
        else if (k == 1) {
            return n;
        } else {
            return comb(n - 1, k - 1) + comb(n - 1, k);
        }
    }
}
