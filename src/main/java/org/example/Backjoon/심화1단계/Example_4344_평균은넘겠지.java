package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 *
 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 *
 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
 * 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 *
 * 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */
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
