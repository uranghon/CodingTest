package org.example.Backjoon.기본수학1단계;

import java.io.*;

public class Example_10250_ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0)
        {
            String[] sArr = br.readLine().split(" ");
            int h = Integer.parseInt(sArr[0]); // 높이
            int w = Integer.parseInt(sArr[1]); // 넓이
            int n = Integer.parseInt(sArr[2]); // n번째 손님

            int x = (n - 1) / h + 1; // xx 가 몇인지
            int y = (n - 1) % h + 1; // 층
            bw.write(String.format("%d", y) + String.format("%02d", x));
            bw.newLine();
        }
    }
}
