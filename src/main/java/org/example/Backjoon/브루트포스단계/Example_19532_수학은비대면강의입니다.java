package org.example.Backjoon.브루트포스단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * a,b,c,d,e,f 가 주어질 때,
 * ax + by = c
 * dx + ey = f
 * 를 만족하는 x, y 를 구하시오.
 * <p>
 * -입력-
 * -999 <= a,b,c,d,e,f <= 999 인 a,b,c,d,e,f 가 서로 공백을 구분으로 하여 한줄에 주어진다.
 * 해는 단 1개임이 보장된다.
 * <p>
 * -출력-
 * x y 를 공백으로 구분해 출력한다.
 *
 * -풀아-
 * y = (c - ax) / b , y = (f - dx) / e
 * y 는 같으니 우변들도 같다. -> (c - ax) / b = (f - dx) / e
 * 양 변의 분모를 1로 만들기 위해 양변에 be 를 곱한다. -> e(c -ax) = b(f - dx) -> ec - eax = bf - bdx
 * x 를 한 변으로 합치고 나머지를 반대 변으로 옮긴다.
 * bdx - eax = bf - ec -> (bd-ea)x = bf-ec -> x = (bf-ec)/(bd-ea)
 *
 * y 도 이것처럼 구한다.
 */
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

    /**
     * 브루트 포스 방식
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

    /**
     * 수학 ㅈ고수 방식
     * 자 우리는 주어식 식을 만족하는 x,y 값이 단 1개인걸 보장받았다.
     * ax + by = c, dx + ey = f 를 y 만 한쪽에 남도록 다음과 같이 바꿔보자.
     * y = (c - ax) / b, y = (f - dx) / e
     * 이 때, x,y 값이 단 한개니까 y는 서로 같다. 따라서
     * (c - ax) / b = (f - dx) / e 이다.
     * 이제 x 만 한쪽에 남게 바꿔보자.
     * ce - aex = bf - bdx
     * (bd - ae)x = bf - ce
     * x = (bf - ce) / (bd - ae)
     * <p>
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
