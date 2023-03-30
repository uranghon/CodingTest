package org.example.Backjoon.브루트포스단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
 * 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
 * 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
 * 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
 * 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 *
 *
 */
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
