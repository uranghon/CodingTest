package org.example.Backjoon.약수_배수_소수;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 */
public class Example_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // 어짜피 StringTokenizer 쓸거면 읽어서 사용할 필요없음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) continue;

            for (int i = 2; i <= num; i++) {
                if(num % i == 0 && i < num) break;
                else if(num % i == 0 && i == num) cnt++;
            }
        }
        System.out.print(cnt);
        br.close();
    }
}
