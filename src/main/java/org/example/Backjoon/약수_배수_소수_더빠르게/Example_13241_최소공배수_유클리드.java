package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_13241_최소공배수_유클리드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long ab = a * b;
        while(b > 0)
        {
            long tmp = a % b;
             a = b;
             b = tmp;
        }
        System.out.print(ab / a);
    }

    static int getGCD(int a, int b)
    {
        if(a % b == 0) return b;
        return getGCD(b, a % b);
    }
}
