package org.example.Backjoon.약수_배수_소수;

import java.io.*;

/**
 * 4 × 3 = 12이다.
 *
 * 이 식을 통해 다음과 같은 사실을 알 수 있다.
 *
 * 3은 12의 약수이고, 12는 3의 배수이다.
 *
 * 4도 12의 약수이고, 12는 4의 배수이다.
 *
 * 두 수가 주어졌을 때, 다음 3가지 중 어떤 관계인지 구하는 프로그램을 작성하시오.
 *
 * 첫 번째 숫자가 두 번째 숫자의 약수이다.
 * 첫 번째 숫자가 두 번째 숫자의 배수이다.
 * 첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.
 *
 * -풀이-
 * a 를 b 로 나눴을 때, 나머지가 0 이면 a 는 b 의 배수이고, b 는 a 의 약수이다.
 * a 를 b로 나누거나 b 를 a 로 나눴을 때, 나머지가 남아버리면 서로 남남이다.
 */
public class Example_5086_배수와약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true)
        {
            String[] sArr = br.readLine().split(" ");
            int a = Integer.parseInt(sArr[0]);
            int b = Integer.parseInt(sArr[1]);

            if(a == 0 && b == 0) break;
            else if (a == 0 || b == 0) bw.write("neither");
            else if(a % b == 0) bw.write("multiple");
            else if(b % a == 0) bw.write("factor");
            else bw.write("neither");

            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
