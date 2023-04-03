package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.*;

/**
 * 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
 * 이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
 * 예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
 * 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
 *
 * -풀이-
 * 2n 크기의 소수체크 배열 만들어서 에라토스테네스의 체로 소수 거르고
 * n부터 2n 까지 소수 구함
 */
public class Example_4948_베르트랑공준 {
    static final int max = 123456 * 2;
    static boolean[] notPrime = new boolean[max + 1];
    static int[] primeCnt = new int[max + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        setNotPrime();
        setPrimeCnt();

        int n;
        while ((n = Integer.parseInt(br.readLine())) > 0) {
//            int cnt = 0;
//            for (int i = n + 1; i <= 2 * n; i++) {
//                if (!notPrime[i]) cnt++;
//            }
//            bw.write(cnt + "\n");

            bw.write((primeCnt[2 * n] - primeCnt[n]) + "\n");
        }
        bw.flush();
    }

    static void setNotPrime() {
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (notPrime[i] == true) continue;

            for (int j = i * i; j <= max; j += i) {
                notPrime[j] = true;
            }
        }
    }

    static void setPrimeCnt() {
        int cnt = 0;
        for (int i = 0; i <= max; i++) {
            if (!notPrime[i]) cnt++;
            primeCnt[i] = cnt;
        }
    }
}
