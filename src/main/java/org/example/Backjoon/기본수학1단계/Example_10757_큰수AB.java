package org.example.Backjoon.기본수학1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 준나 큰 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * -입력-
 * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 10^10000)
 * -출력-
 * 첫째 줄에 A+B를 출력한다.
 * -풀이-
 * 1. BigInteger 사용
 * 2. 두 수를 char형 배열로 만들어서 끝에서부터 비교해서 더하고 올리는 식으로 계산한다.
 */
public class Example_10757_큰수AB {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] sArr = br.readLine().split(" ");
        String[] sArr = {"92233720368547234675807", "9223372033456854775808"};
        mine1(sArr); // 쉽계하는법. java 에서 제공하는 크기 거의 무한의 숫자 클래스 쓰기.
        mine2(sArr); // 문제에서 요구하는 풀이방식(?) 하나하나 비교해서 더하기.

//        br.close();
    }

    static void mine1(String[] sArr) {
        BigInteger bi1 = new BigInteger(sArr[0]);
        BigInteger bi2 = new BigInteger(sArr[1]);
        System.out.println(bi1.add(bi2));
    }

    static void mine2(String[] sArr) {
        char[] cArr1 = sArr[0].toCharArray();
        char[] cArr2 = sArr[1].toCharArray();

        int n = 0;
        int up = 0;
        StringBuilder sb = new StringBuilder();
        int l = cArr1.length > cArr2.length ? cArr1.length : cArr2.length;

        for (int i = 1; i <= l; i++) {
            int a = i > cArr1.length ? 0 : cArr1[cArr1.length - i] - '0';
            int b = i > cArr2.length ? 0 : cArr2[cArr2.length - i] - '0';
            n = a + b + up;
            up = n / 10;
            sb.append(n % 10);
        }

        sb.append(up > 0 ? up : "");
        System.out.println(sb.reverse());
    }
}
