package org.example.Backjoon.약수_배수_소수;

import java.io.*;
import java.util.StringTokenizer;

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
