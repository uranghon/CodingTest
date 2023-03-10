package org.example.Backjoon.심화1단계;

import java.io.IOException;
import java.util.Scanner;

public class Example_2444_별찍기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2 * n - 1; i++) {

            if(i < n)
            {
                for (int j = 1; j <= n - i; j++) {
                    sb.append(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    sb.append("*");
                }
            }
            else
            {
                for (int j = 1; j <= i - n; j++) {
                    sb.append(" ");
                }
                for (int j = 1; j <= (2 * n - i) * 2 - 1; j++) {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
