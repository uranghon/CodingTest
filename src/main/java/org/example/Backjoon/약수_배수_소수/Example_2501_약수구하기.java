package org.example.Backjoon.약수_배수_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 어떤 자연수 p와 q가 있을 때, 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다.
 *
 * 6을 예로 들면
 *
 * 6 ÷ 1 = 6 … 0
 * 6 ÷ 2 = 3 … 0
 * 6 ÷ 3 = 2 … 0
 * 6 ÷ 4 = 1 … 2
 * 6 ÷ 5 = 1 … 1
 * 6 ÷ 6 = 1 … 0
 * 그래서 6의 약수는 1, 2, 3, 6, 총 네 개이다.
 *
 * 두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.
 */
public class Example_2501_약수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sArr = br.readLine().split(" ");
        int n = Integer.parseInt(sArr[0]);
        int k = Integer.parseInt(sArr[1]);
        int s = 0;
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0) s++;
            if(s == k)
            {
                System.out.print(i);
                break;
            }
        }

        if(s < k) System.out.print("0");
        br.close();
    }
}
