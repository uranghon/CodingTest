package org.example.Backjoon.시간복잡도단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Example_24313_점근적표기1 {
    /**
     * 오늘도 서준이는 점근적 표기 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
     * 알고리즘의 소요 시간을 나타내는 O-표기법(빅-오)을 다음과 같이 정의하자.
     * O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다}
     * 이 정의는 실제 O-표기법(https://en.wikipedia.org/wiki/Big_O_notation)과 다를 수 있다.
     * 함수 f(n) = a1n + a0, 양의 정수 c, n0가 주어질 경우 O(n) 정의를 만족하는지 알아보자.
     *
     * 첫째 줄에 함수 f(n)을 나타내는 정수 a1, a0가 주어진다. (0 ≤ |ai| ≤ 100)
     * 다음 줄에 양의 정수 c가 주어진다. (1 ≤ c ≤ 100)
     * 다음 줄에 양의 정수 n0가 주어진다. (1 ≤ n0 ≤ 100)
     *
     * f(n) = a1*n + a0
     * g(n) = n
     * 이게 n >= n0 인 상황에서 항상 f(n) <= c * g(n) 인지
     * a1*n + a0 <= c*n
     * (a1-c)n + a0 <= 0
     * 0 <= (c-a1)n - a0
     * a0 <= (c-a1)n
     * a0 / (c-a1) <= n
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = br.readLine().split(" ");
        int a1 = Integer.parseInt(sArr[0]);
        int a0 = Integer.parseInt(sArr[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

//        if(c < a1) System.out.print(0);
//        else if(c == a1 && a0 > 0) System.out.print(0);
//        else if(c == a1) System.out.print(1);
//        else if((double) a0 / (c-a1) <= n0) System.out.print(1);
//        else System.out.print(0);

        // 문제를 잘못봤네.. a0, a1 은 절대값이구나.
        // -100 ~ 100 임

        // 설명 c >= a1 이어야지만 특정 n0 에서 a1 * n0 + a0 <= c * n0 를 만족했을 때,
        // n0 보다 이상인 수가 n0 자리에 들어가더라도 기울기덕분에 만족한다.
        if(a1 * n0 + a0 <= c * n0 && c >= a1) System.out.print(1);
        else System.out.print(0);

        br.close();
    }
}
