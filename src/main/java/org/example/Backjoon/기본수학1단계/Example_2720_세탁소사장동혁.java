package org.example.Backjoon.기본수학1단계;

import java.io.*;

public class Example_2720_세탁소사장동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        final int quarter = 25;
        final int dime = 10;
        final int nickel = 5;
        final int penny = 1;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            bw.write(num / quarter + " ");
            num %= quarter;
            bw.write(num / dime + " ");
            num %= dime;
            bw.write(num / nickel + " ");
            num %= nickel;
            bw.write(num / penny + "\n");
        }
        bw.flush();
    }
}
