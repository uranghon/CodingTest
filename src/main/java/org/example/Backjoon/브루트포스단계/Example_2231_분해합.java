package org.example.Backjoon.브루트포스단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
 * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
 * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 *
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 */
public class Example_2231_분해합 {

    /** 기본 골자는 자연수N은 기본생성자 + 기본생성자의 자리수 단위만큼 9를 곱한수 보다는 아래란 것이다.
     * 예를들어 기본생성자 999 일때, 자연수 N 은 999 + 9*3 이고, 174 일때는 174 + 1 + 7 + 4 이다.
     * 이걸 자세히 보니 기본생성자가 그 단위에서 제일 큰 999일 때 자연수 N은 999 + 9*3 과 같고
     * 174 와 같이 999보다 낮은 값일 때는 174 + 1 + 7 + 4 < 174 + 9*3 이다.
     *
     * 이걸 역으로 생각해보면 기본생성자를 체크할 시작점을 구할 수 있다.
     * 자연수N에 대하여 기본생성자는 아무리 작아봤자. 자연수N 에서 자연수N의 단위만큼 9를 곱한 수를 뺀 값보단 크다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();
        int n = Integer.parseInt(strN);
        int start = Math.max(0, n - (9 * strN.length()));

        mine1(start, n);
        mine2(start, n);
    }

    static void mine1(int start, int n) {
        while(start < n)
        {
            int tmp = start;
            int sum = tmp;
            while (tmp > 0)
            {
                sum += tmp % 10;
                tmp /= 10;
            }
            if(sum == n)
            {
                System.out.print(start);
                return;
            }

            start++;
        }

        System.out.print(0);
    }

    static void mine2(int start, int n) {

        while(start < n)
        {
            int sum = start;
            char[] chars = (start + "").toCharArray();
            for (int i = 0; i < chars.length; i++) {
                sum += chars[i] - '0';
            }

            if(sum == n) break;

            start++;
        }

        if(start == n) System.out.print(0);
        else System.out.print(start);
    }
}
