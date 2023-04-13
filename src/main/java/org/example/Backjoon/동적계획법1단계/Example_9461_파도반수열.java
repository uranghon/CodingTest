package org.example.Backjoon.동적계획법1단계;

import java.io.*;

/**
 * 오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다.
 * 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
 * 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
 * N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
 *
 */
public class Example_9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if(num[i] > max) max = num[i];
        }
        long[] pArr = new long[max + 1];
        for (int i = 1; i < pArr.length; i++) {
            if(i < 4) pArr[i] = 1;
            else if(i < 6) pArr[i] = 2;
            else pArr[i] = pArr[i - 1] + pArr[i - 5];
        }

        for (int i = 0; i < num.length; i++) {
            bw.write(pArr[num[i]] + "\n");
        }

        bw.flush();
    }
}
