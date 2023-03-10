package org.example.Backjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
