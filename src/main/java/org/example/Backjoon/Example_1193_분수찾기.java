package org.example.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
 *
 * 1/1	1/2	1/3	1/4	1/5	…
 * 2/1	2/2	2/3	2/4	…	…
 * 3/1	3/2	3/3	…	…	…
 * 4/1	4/2	…	…	…	…
 * 5/1	…	…	…	…	…
 * …	…	…	…	…	…
 *
 * 1 2 6 7
 * 1 3 4 10 11
 *
 * 1 2 4 7 11 ...
 * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
 *
 * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 *
 * 첫째 줄에 분수를 출력한다.
 */
public class Example_1193_분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        mine(n);
        others1(n); // 얘가 좋다.
        others2(n);

        br.close();
    }

    static void mine(int n) {
        int point = 1;
        int i = 1;

        while (point < n) {
            point += 4 * i;
            i++; //
        }

        int diff = 0;
        int t = 0;
        int b = 0;

        if (n < point - (3 * (i - 1))) // 아랫기준 우상단 검색
        {
            diff = n - (point - (4 * (i - 1)));
            t = i - 1 - diff;
            b = i - 1 + diff;
        } else if (n > point - i) // 기준으로 좌하단 검색
        {
            diff = point - n;
            t = i + diff;
            b = i - diff;
        } else // 중간대각선 검색
        {
            diff = (point - n) - i;
            t = 2 * (i - 1) - diff;
            b = 1 + diff;
        }

        System.out.println(t + "/" + b);
    }

    // 이놈이 제일 낫네.
    private static void others1(int n) {
        int a = 1;
        int b;
        while (n > a * (a + 1) / 2) {
            a++; // 체크포인트가 1/1, 2/1, 1/3, 4/1, 1/5, 6/1, 1/7, ...
        }
        // a 가 홀수면 1/a 가 체크포인트
        // a 가 짝수면 a/1 이 체크포인트
        // 차이만큼 빼거나 더한다.
        b = (a * (a + 1) / 2) - n;

        if (a % 2 == 1) // 홀수. 작은게 좌하단.
            System.out.println((1 + b) + "/" + (a - b));
        else // 짝수. 작은게 우상단
            System.out.println((a - b) + "/" + (b + 1));
    }

    private static void others2(int x) {
        int idx = -1;
        for (int i = 1; i < 4500; i++) {
            if (i * (i + 1) / 2 + 1 > x) {
                idx = i;
                break;
            }
        }
        x -= (idx - 1) * idx / 2;

        if (idx % 2 == 1) {
            System.out.println((idx + 1 - x) + "/" + x);
        } else {
            System.out.println(x + "/" + (idx + 1 - x));
        }
    }
}
