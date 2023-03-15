package org.example.Backjoon.약수_배수_소수;

import java.io.*;

public class Example_9506_약수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while ((str = br.readLine()) != null) {
            if(str.equals("-1")) break;

            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(str);
            int sum = 1;
            sb.append(num + " = 1");
            for (int i = 2; i < num; i++) {
                if(num % i == 0)
                {
                    sum += i;
                    sb.append(" + " + i);
                }
            }

            if(num == sum) System.out.println(sb);
            else System.out.println(num + " is NOT perfect.");
        }

        br.close();
    }
}
