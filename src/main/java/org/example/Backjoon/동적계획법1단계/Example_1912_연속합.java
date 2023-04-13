package org.example.Backjoon.동적계획법1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxSum = -1000;
        int sum = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            if(maxSum < sum) maxSum = sum;
            if(sum < 0) sum = 0;
        }
        System.out.print(maxSum);
    }
}
