package org.example.Backjoon.브루트포스단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = mine(n);
//        int cnt = others(n);

        System.out.print(cnt);
    }

    /** burte force 방식
     * 개중엔 그나마 줄이긴 했다.
     */
    static int mine(int n) {
        for (int i = n / 5; i >= 0; i--) {
            if ((n - 5 * i) % 3 == 0) {
                return i + (n - 5 * i) / 3;
            }
        }

        return -1;
    }

    /** 수학천재 방식
     * 수학 공부를 다시 해야하나..
     */
    static int others(int n) {
        // n >= 3 임이 보장될경우
        if (n == 4 || n == 7) return -1;
        else if (n % 5 == 1 || n % 5 == 3) return n / 5 + 1;
        else if (n % 5 == 2 || n % 5 == 4) return n / 5 + 2;
        else return n / 5; // if (n % 5 == 0)
    }
}
