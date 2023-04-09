package org.example.Backjoon.기본수학1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 *
 * 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
 * B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
 *
 * 첫째 줄에 B진법 수 N을 10진법으로 출력한다.
 *
 * -풀이-
 * 1. 문제가 원하는대로 한글자씩 짤라보기
 * 2. Integer.parseInt 활용하기.
 *    그냥 스트링을 변환하는거 단항매개변수 말고, 이항매개변수로
 *    Integer.parseInt(String, int) 형식으로다가 두번째에 몇진법인지 넣는거 있다.
 */
public class Example_2745_진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] n = st.nextToken().toCharArray();
        int b = Integer.parseInt(st.nextToken());
        int sum = 0;
        int num;
        for (int i = 0; i < n.length; i++) {
            char c = n[n.length - 1 - i];
            if(c > '9') num = c - 'A' + 10;
            else num = c - '0';
            sum += ((int) Math.pow(b, i)) * num;
        }

        System.out.print(sum);
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //System.out.println(Integer.parseInt(st.nextToken(), Integer.valueOf(st.nextToken())));
    }
}
