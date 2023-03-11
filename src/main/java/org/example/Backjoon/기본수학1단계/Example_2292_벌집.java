package org.example.Backjoon.기본수학1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2292_벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        mine(n);
        others1(n);
        others2(n);

        br.close();
    }

    static void mine(int n) {
        //1 7 19 37 61   6 12 18 24 6의 배수 2~7까지가 1칸 이내, 8~19 까지 2칸 이내, 20~37 까지 3칸 이내
        // 결과 <= 1 이면

        int i = 1;
        while (n > 1) {
            i++;
            n -= 6 * (i - 1);
        }

        System.out.println(i);
    }

    static void others1(int n) {
        int count = 1;
        int num = 1;

        //벌집 방의 개수 1 => 6 => 12 => 18 ....
        while (num < n) {
            num += count * 6;
            count++;
        }
        System.out.println(count);
    }

    static void others2(int n) {
        double res = (n - 1) / 3.0;

        int j = 1;
        while (j * (j - 1) < res) {
            j++;
        }

        System.out.println(j);
    }
}
