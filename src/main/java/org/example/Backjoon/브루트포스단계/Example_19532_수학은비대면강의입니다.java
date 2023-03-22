package org.example.Backjoon.브루트포스단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_19532_수학은비대면강의입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        mine(a, b, c, d, e, f);
        others(a, b, c, d, e, f); // 이게 수학 ㅈ고수
    }

    /** 브루트 포스 방식
     */
    static void mine(int a, int b, int c, int d, int e, int f) {
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.print(x + " " + y);
                    return;
                }
            }
        }
    }

    /** 수학 ㅈ고수 방식
     * 자 우리는 주어식 식을 만족하는 x,y 값이 단 1개인걸 보장받았다.
     * ax + by = c, dx + ey = f 를 y 만 한쪽에 남도록 다음과 같이 바꿔보자.
     * y = (c - ax) / b, y = (f - dx) / e
     * 이 때, x,y 값이 단 한개니까 y는 서로 같다. 따라서
     * (c - ax) / b = (f - dx) / e 이다.
     * 이제 x 만 한쪽에 남게 바꿔보자.
     * ce - aex = bf - bdx
     * (bd - ae)x = bf - ce
     * x = (bf - ce) / (bd - ae)
     *
     * y 도 위에 방식처럼 구할 수 있다.
     * x = (c - by) / a, x = (f - ey) / d
     * (c - by) / a = (f - ey) / d
     * cd - bdy = af - aey
     * (ae - bd)y = af - cd
     * y = (af - cd) / (ae - bd)
     */
    static void others(int a, int b, int c, int d, int e, int f) {
        System.out.print((c * e - b * f) / (a * e - b * d) + " " + (a * f - c * d) / (a * e - b * d));
    }
}
