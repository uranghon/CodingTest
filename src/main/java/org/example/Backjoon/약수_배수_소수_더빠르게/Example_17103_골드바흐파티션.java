package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.*;

/**
 * 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
 * 짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다.
 * 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다
 *
 * 첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.
 *
 * 각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.
 *
 * -풀이-
 * 1부터 n 까지 소수, 비소수 구분함
 * 왼쪽은 2, 오른쪽은 n-2 부터
 * 왼쪽은 1씩 증가, 오른쪽은 1씩 감소시키면서
 * 서로의 위치가 같아질떄까지 소수의 합일경우를 체크한다.
 */
public class Example_17103_골드바흐파티션 {
    static final int max = 1_000_000;
    static boolean[] notPrime = new boolean[max + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        setNotPrime();

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            bw.write(getPartition(num) + "\n");
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

    static int getPartition(int num) {
        int cnt = 0;
        int start = 2;
        int end = num - 2;

        while (start <= end) {
            if(!notPrime[start] && !notPrime[end]) cnt++;
            start++;
            end--;
        }
        return cnt;
    }
}
