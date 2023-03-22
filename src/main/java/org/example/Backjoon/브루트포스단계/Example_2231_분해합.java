package org.example.Backjoon.브루트포스단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();
        int n = Integer.parseInt(strN);
        int start = Math.max(0, n - (9 * strN.length()));

        mine1(start, n);
        mine2(start, n);
    }

    static void mine1(int start, int n) {
        while(start < n)
        {
            int tmp = start;
            int sum = tmp;
            while (tmp > 0)
            {
                sum += tmp % 10;
                tmp /= 10;
            }
            if(sum == n)
            {
                System.out.print(start);
                return;
            }

            start++;
        }

        System.out.print(0);
    }

    static void mine2(int start, int n) {

        while(start < n)
        {
            int sum = start;
            char[] chars = (start + "").toCharArray();
            for (int i = 0; i < chars.length; i++) {
                sum += chars[i] - '0';
            }

            if(sum == n) break;

            start++;
        }

        if(start == n) System.out.print(0);
        else System.out.print(start);
    }
}
