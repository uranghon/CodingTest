package org.example.Backjoon.약수_배수_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2581_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fr = Integer.parseInt(br.readLine());
        int to = Integer.parseInt(br.readLine());
//        mine1(fr, to);
        mine2(fr, to);

        br.close();
    }

    static void mine1(int fr, int to) throws IOException {
        int minNum = 0;
        int sum = 0;
        for (int i = fr; i <= to; i++) {
            for (int j = 2; j <= i; j++) {
                if(i % j == 0 && j < i) break;
                if(i % j == 0 && j == i) {
                    if(minNum == 0) minNum = i;
                    sum += i;
                }
            }
        }
        if(sum > 0)
        {
            System.out.println(sum);
            System.out.print(minNum);
        }
        else
        {
            System.out.print(-1);
        }
    }

    static void mine2(int fr, int to) throws IOException {
        int minNum = 0;
        int sum = 0;
        boolean[] notPrime = new boolean[to + 1];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(to); i++) {
            // 왜 최소 2 * 2 = 4부터냐? 어짜피 2,3 은 소수임.
            for (int j = i * i; j <= to; j += i) {
                notPrime[j] = true;
            }
        }

        for (int i = fr; i <= to; i++) {
            if(!notPrime[i])
            {
                if(minNum == 0) minNum = i;
                sum += i;
            }
        }

        if(sum > 0)
        {
            System.out.println(sum);
            System.out.print(minNum);
        }
        else
        {
            System.out.print(-1);
        }
    }
}
