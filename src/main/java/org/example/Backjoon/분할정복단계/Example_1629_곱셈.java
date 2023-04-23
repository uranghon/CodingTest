package org.example.Backjoon.분할정복단계;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
 * <p>
 * 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.
 * <p>
 * 첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
 * <p>
 * -풀이-
 * 느낌상 A^B%C 는
 * 매번 A를 제곱할때마다 C로 나눈 나머지에 A를 곱해주는 방식으로 구하면 될듯.
 * 예를 들어 8 5 13 는
 * 1. (1 * 8) % 13 = 8
 * 2. (8 * 8) % 13 = 64 % 13 = 12
 * 3. (12 * 8) % 13 = 96 % 13 = 5
 * 4. (5 * 8) % 13 = 40 % 13 = 1
 * 5. (1 * 8) % 13 = 8
 * 6. (8 * 8) % 13 = 64 % 13 = 12
 * ...
 * 계속 이런식으로
 *
 * 근데 여기에 추가할 식이 있다.
 * b 짝수 : a^b = a^(b/2) * a^(b/2)
 * b 홀수 : a^b = a^(b/2) * a^(b/2 + 1)
 */
public class Example_1629_곱셈 {
    static long num;
//    static long a;
//    static long c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        a = a % c;
//        powRemain(b,1);
//        System.out.print(num);
        System.out.print(powRemain(a, b,c));

    }

    static long powRemain(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        } else if (b % 2 == 0) {
            long num = powRemain(a, b / 2, c);
            return num * num % c;
        } else {
            long num = powRemain(a, b / 2, c);
//            long num2 = powRemain(a, b / 2 + 1, c);
//            return num * num2 % c;
            return (num * num % c) * a % c;
        }
    }
}
