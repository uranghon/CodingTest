package org.example.Backjoon.기본수학1단계;

import java.io.*;

public class Example_2775_부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0)
        {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            int[] floor = new int[n];

            for (int i = 0; i < n; i++) {
                floor[i] = i + 1;
            }

            for(int i = 1; i <= k; i++)
            {
                floor = upFloor(floor);
            }

            bw.write(floor[n - 1] + "");
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static int[] upFloor(int[] floor)
    {
        int n = floor.length;
        for (int i = 1; i < n; i++) {
            floor[i] = floor[i - 1] + floor[i];
        }
        return floor;
    }
}
