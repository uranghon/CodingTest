package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_1735_분수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int sumA = a1 * b2 + a2 * b1;
        int sumB = b1 * b2;

        int gcd = getGCD(sumA, sumB);
        System.out.print((sumA / gcd) + " " + (sumB / gcd));
    }

    private static int getGCD(int sumA, int sumB) {
        if(sumA % sumB == 0) return sumB;
        return getGCD(sumB, sumA % sumB);
    }
}
