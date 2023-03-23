package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.*;

/**
 * 정수 n 이 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수를 찾는 프로그램을 작성하시오.
 */
public class Example_4134_다음소수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        for (long i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            while (!isBSD(num)) num++;
            bw.write(num + "\n");
        }
        bw.flush();
    }

    static boolean isBSD(long num){
        if (num < 2) return false;
        for (int i = 2; i < Math.sqrt(num + 1); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
