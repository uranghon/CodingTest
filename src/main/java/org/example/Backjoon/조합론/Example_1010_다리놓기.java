package org.example.Backjoon.조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Example_1010_다리놓기 {
    static int[][] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            BigInteger n = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
//            BigInteger m = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
//            System.out.println(factorial(m).divide(factorial(m.subtract(n)).multiply(factorial(n))));

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            comb = new int[m + 1][n + 1];
//            System.out.println(buildBridge(m, n));
            System.out.println(buildBridge2(m, n));
        }
    }

    static int buildBridge(int m, int n) {
        if (m == n) return 1;
        if (n == 1) return m;
        return buildBridge(m - 1, n - 1) + buildBridge(m - 1, n);
    }

    /**
     * 한번 계산한건 더이상 계산안하고 바로 얻을 수 있게 수정한부분
     */
    static int buildBridge2(int m, int n) {
        if (m == n) return 1;
        if (comb[m][n] > 0) return comb[m][n];
        if (n == 1) return m;
        return comb[m][n] = buildBridge(m - 1, n - 1) + buildBridge(m - 1, n);
    }

    static BigInteger factorial(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) <= 0) return BigInteger.ONE;
        return num.multiply(factorial(num.subtract(BigInteger.ONE)));
    }
}
