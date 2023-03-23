package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.*;

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
