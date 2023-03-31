package org.example.Backjoon.약수_배수_소수;

import java.io.*;

/**
 * 어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
 * 예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
 * n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.
 *
 * -풀이-
 * i 를 1부터 n / 2 까지 올려가면서 n % i == 0 인 애들은 더해준다.
 * n / 2 까지만 하는 이유는 n / 2 를 넘어가는 애는 n 의 약수가 될 수 없다.
 */
public class Example_9506_약수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while ((str = br.readLine()) != null) {
            if(str.equals("-1")) break;

            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(str);
            int sum = 1;
            sb.append(num + " = 1");
            for (int i = 2; i <= num / 2; i++) {
                if(num % i == 0)
                {
                    sum += i;
                    sb.append(" + " + i);
                }
            }

            if(num == sum) System.out.println(sb);
            else System.out.println(num + " is NOT perfect.");
        }

        br.close();
    }
}
