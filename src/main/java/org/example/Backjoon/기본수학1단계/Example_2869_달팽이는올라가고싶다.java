package org.example.Backjoon.기본수학1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2869_달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = br.readLine().split(" ");
        int a = Integer.parseInt(sArr[0]);
        int b = Integer.parseInt(sArr[1]);
        int v = Integer.parseInt(sArr[2]);

        mine(a, b, v);
        others1(a, b, v);
        others2(a, b, v);

        br.close();
    }

    static void mine(int a, int b, int v) {
        int day = (v - a) / (a - b);

        // (v-a) / (a-b) 방식. 얘는 이해가 간다.
        System.out.println((v - a) % (a - b) == 0 ? day + 1 : day + 2);
    }

    private static void others1(int a, int b, int v) {
        int day;
        if ((v - a) % (a - b) != 0) {
            day = (v - a) / (a - b) + 2;
        } else {
            day = (v - a) / (a - b) + 1;
        }
        System.out.println(day);
    }

    private static void others2(int a, int b, int v) {
        // (v-b) / (a-b) 방식. 얘는 어떻게 나온건지?
        // 알았다. 예를 들어 높이 10, 올라감 4, 내려감 2. 일때, 결국 낮에 올라감으로 딱 10에 도착한다는건, 내려옴까지 하면 10 - 2 인 8에 도달한다는거다.
        //
        // (높이 - 내려감) % (올라감 - 내려감) 이 0 이면 딱 맞춰서 도착한다는거니까
        // day = (높이 - 내려감) / (올라감 - 내려감)
        // (높이 - 내려감) % (올라감 - 내려감) 이 0 이 아니면 하루 더 가야한다는 거니까
        // day = (높이 - 내려감) / (올라감 - 내려감) + 1

        int day = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0) day++;
        System.out.println(day);
    }
}
