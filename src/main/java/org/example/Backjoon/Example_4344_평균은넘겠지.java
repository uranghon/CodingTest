package org.example.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_4344_평균은넘겠지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int c = br.read() - '0';
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            double[] score = new double[num];
            double sumScore = 0;
            int overScore = 0;
            for (int j = 0; j < num; j++) {
                score[j] = Double.parseDouble(st.nextToken());
                sumScore += score[j];
            }

            for (int j = 0; j < num; j++) {
                if(score[j] > sumScore / num) overScore++;
            }

            System.out.println(String.format("%.3f", ((double) overScore / num) * 100) + "%");
        }
    }
}
