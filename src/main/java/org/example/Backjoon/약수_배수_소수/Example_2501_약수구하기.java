package org.example.Backjoon.약수_배수_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
