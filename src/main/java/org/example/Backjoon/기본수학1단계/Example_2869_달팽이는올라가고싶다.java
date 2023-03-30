package org.example.Backjoon.기본수학1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 *
 * -입력-
 * 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
 *
 * -출력-
 * 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 * -풀이-
 * 1. (V - A) / (A - B) 방식
 * A - B 가 하루에 갈 수 있는 높이이다.
 * V - A 까지 도달하는데 n 일이 걸린다면 거기서 하루만 더 가면 된다.
 * 만약에 n일 걸려서 딱 V - A 위치에 도달한다면 딱 n + 1 일 걸리고
 * 넘기면 뭐 역시 n + 1 일이긴 하지만 n 을 구하는 식이
 * (V - A) / (A - B) 라서 딱 떨어지는거 아니면 + 2 해줘야 한다.
 *
 * 2. (v-b) / (a-b)
 * 예를 들어 높이 10, 올라감 4, 내려감 2. 일때, 결국 낮에 올라감으로 딱 10에 도착한다는건, 내려옴까지 하면 10 - 2 인 8에 도달한다는거다.
 * (높이 - 내려감) % (올라감 - 내려감) 이 0 이면 딱 맞춰서 도착한다는거니까
 * day = (높이 - 내려감) / (올라감 - 내려감)
 * (높이 - 내려감) % (올라감 - 내려감) 이 0 이 아니면 하루 더 가야한다는 거니까
 * day = (높이 - 내려감) / (올라감 - 내려감) + 1
 */
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
