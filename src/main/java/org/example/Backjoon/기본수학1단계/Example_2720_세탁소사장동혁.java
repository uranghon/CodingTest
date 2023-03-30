package org.example.Backjoon.기본수학1단계;

import java.io.*;

/**
 * 거스름돈의 액수가 주어지면 리암이 줘야할 쿼터(Quarter, $0.25)의 개수, 다임(Dime, $0.10)의 개수,
 * 니켈(Nickel, $0.05)의 개수, 페니(Penny, $0.01)의 개수를 구하는 프로그램을 작성하시오.
 * 거스름돈은 항상 $5.00 이하이고, 손님이 받는 동전의 개수를 최소로 하려고 한다.
 * 예를 들어, $1.24를 거슬러 주어야 한다면, 손님은 4쿼터, 2다임, 0니켈, 4페니를 받게 된다.
 *
 * - 입력 -
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 거스름돈 C를 나타내는 정수 하나로 이루어져 있다. C의 단위는 센트이다. (1달러 = 100센트) (1<=C<=500)
 *
 * - 출력 -
 * 각 테스트케이스에 대해 필요한 쿼터의 개수, 다임의 개수, 니켈의 개수, 페니의 개수를 공백으로 구분하여 출력한다.
 */
public class Example_2720_세탁소사장동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        final int quarter = 25;
        final int dime = 10;
        final int nickel = 5;
        final int penny = 1;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            bw.write(num / quarter + " ");
            num %= quarter;
            bw.write(num / dime + " ");
            num %= dime;
            bw.write(num / nickel + " ");
            num %= nickel;
            bw.write(num / penny + "\n");
        }
        bw.flush();
    }
}
