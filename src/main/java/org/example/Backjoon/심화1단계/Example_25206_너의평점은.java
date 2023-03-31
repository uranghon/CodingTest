package org.example.Backjoon.심화1단계;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
 * 치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
 * 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
 * 인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
 *
 * A+	4.5
 * A0	4.0
 * B+	3.5
 * B0	3.0
 * C+	2.5
 * C0	2.0
 * D+	1.5
 * D0	1.0
 * F	0.0
 *
 * P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
 *
 * -입력-
 * 20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.
 *
 * -풀력-
 * 치훈이의 전공평점을 출력한다.
 * 정답과의 절대오차 또는 상대오차가 10^-4 (0.0001) 이하이면 정답으로 인정한다.
 *
 */
public class Example_25206_너의평점은 {
    public static void main(String[] args) throws IOException {
        mine();
    }

    static void mine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Float> score = new HashMap<>();
        score.put("A+", 4.5f);
        score.put("A0", 4.0f);
        score.put("B+", 3.5f);
        score.put("B0", 3.0f);
        score.put("C+", 2.5f);
        score.put("C0", 2.0f);
        score.put("D+", 1.5f);
        score.put("D0", 1.0f);
        score.put("F", 0.0f);
        float sum1 = 0f;
        float sum2 = 0f;

        for (int i = 0; i < 20; i++) {
            String[] line = br.readLine().split(" ");
            if(line[2].equals("P")) continue;

            float f1 = Float.parseFloat(line[1]);
            float f2 = score.get(line[2]);

            sum1 += f1 * f2;
            sum2 += f1;
        }
        System.out.println(String.format("%.6f", sum1 / sum2));
        br.close();
    }

    // Map 안쓰고 하는 방법
    static void others() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double[] arr = new double[]{0, 0, 1.0, 2.0, 3.0, 4.0};
        int n = 20;
        double sum = 0;
        double hakjum = 0;

        while(n--> 0){
            String line[] = br.readLine().split(" ");

            if(line[2].equals("P")) {
                continue;
            }

            double a = Double.parseDouble(line[1]);
            double b = 0;
            hakjum += a;
            if(line[2].equals("F")){
                b = arr[70 - line[2].charAt(0)]; // 70 은 F 의 아스키. 70 - 'F' 는 0. arr[0] 은 F의 점수
            }
            else{
                b = arr[70 - line[2].charAt(0)] + (line[2].charAt(1) == '+'? 0.5 : 0);
            }
            sum += (a * b);
        }

        bw.write(Double.toString((sum)/hakjum));
        bw.flush();
        bw.close();
    }
}
