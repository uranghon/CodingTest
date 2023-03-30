package org.example.Backjoon.기본수학1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/JudgeOnline/upload/201009/3(2).png
 * 위의 그림과 같이 육각형으로 이루어진 벌집이 있다.
 * 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때
 * 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 *
 * - 풀이 -
 * 잘보면 규칙이 있다.
 * 처음셀은 1개, 2번째 벽의 셀은 6개, 3번째 벽의 셀은 12개, 4번째 벽의 셀은 18개 ...
 * n 이 1 이상일때는, 벽을 살펴가며 몇번째 벽에 있는지 찾으면 된다.
 */
public class Example_2292_벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        mine(n);
        others1(n);
        others2(n);

        br.close();
    }

    static void mine(int n) {
        //1 7 19 37 61   6 12 18 24 6의 배수 2~7까지가 1칸 이내, 8~19 까지 2칸 이내, 20~37 까지 3칸 이내
        // 결과 <= 1 이면

        int i = 1;
        while (n > 1) {
            i++;
            n -= 6 * (i - 1);
        }

        System.out.println(i);
    }

    static void others1(int n) {
        int count = 1;
        int num = 1;

        //벌집 방의 개수 1 => 6 => 12 => 18 ....
        while (num < n) {
            num += count * 6;
            count++;
        }
        System.out.println(count);
    }

    static void others2(int n) {
        double res = (n - 1) / 3.0;

        int j = 1;
        while (j * (j - 1) < res) {
            j++;
        }

        System.out.println(j);
    }
}
