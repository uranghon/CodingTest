package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.
 * 두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오.
 * 기약분수란 더 이상 약분되지 않는 분수를 의미한다.
 *
 * -풀이-
 * 두 분수를 일단 더하기 위해서 두 분수 다 상대 분수쪽의 분모를 자기의 분자, 분모에 곱해준다.
 * 그리고 두 분수를 더해준다.
 * 그 다음에 합쳐진 분수의 분자와 분모의 최대공약수를 구한다음에 양쪽다 그거로 나눈다.
 *
 * 그럼 최대공약수는 어떻게 구하냐? 유클리드 호제법 사용.
 * a%b == 0 이 아님면 a = b, b = a%b 로 바꾼다음에
 * a%b == 0 인지 체크하는걸 a%b 가 될 때까지 반복한다.
 * a%b == 0 이 되는 b 가 최대공약수이다.
 */
public class Example_1735_분수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int sumA = a1 * b2 + a2 * b1;
        int sumB = b1 * b2;

        int gcd = getGCD(sumA, sumB);
        System.out.print((sumA / gcd) + " " + (sumB / gcd));
    }

    // 공약수 구하기
    private static int getGCD(int sumA, int sumB) {
        if(sumA % sumB == 0) return sumB;
        return getGCD(sumB, sumA % sumB);
    }
}
