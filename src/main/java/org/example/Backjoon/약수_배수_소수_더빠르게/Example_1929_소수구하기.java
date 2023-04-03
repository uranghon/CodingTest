package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.*;

/**
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 *
 * -풀이-
 * N 짜리 크기의 boolean 형 배열 만들고, 에라토스테네스의 체로 거른다.
 * 다음 M 부터 N 까지 가면서 소수를 출력한다.
 */

public class Example_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] mn = br.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        boolean[] notPrime = new boolean[n + 1];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i < Math.sqrt(n + 1); i++) {
            if(notPrime[i] == true) continue;

            for (int j = i * i; j <= n; j += i) {
                notPrime[j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if(!notPrime[i]) bw.write(i + "\n");
        }
        bw.flush();
    }
}
