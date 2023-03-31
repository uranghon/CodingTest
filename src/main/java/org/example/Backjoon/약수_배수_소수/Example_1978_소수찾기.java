package org.example.Backjoon.약수_배수_소수;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * -풀이-
 * 소수구하기 방법 쓰면 된다.
 * isPrime_Eratos 꺼 가 제일 낫다.
 * 저게 뭔말이냐?
 * 예를들어 숫자 a 가 소수인지 아닌지 보고 싶다면 a를 2부터 a의 제곱근까지 나눠보면서 나머지가 0이 되는지 체크해보면 된다.
 * 0이 되는 수가 있으면 소수가 아니고, 없으면 소수이다.
 *
 * 왜 a의 제곱근까지냐? a를 a의 제곱근으로 나누면 a의 제곱근이 된다.
 * 이는 a를 a의 제곱근보다 더 큰 값으로 나눈다면 나눠진 값은 a의 제곱근보다 작다는 뜻이고, 이건 이미 2~a의 제곱근까지 오는동안 체크된 것이기 때문이다.
 * (A/a = b 이면 A/b = a 이다)
 */
public class Example_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // 어짜피 StringTokenizer 쓸거면 읽어서 사용할 필요없음
//        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
//            if(isPrime(num)) cnt++;
            if(isPrime_Eratos(num)) cnt++;
        }
        System.out.print(cnt);
        br.close();
    }

    static boolean isPrime(int num) {
        if(num == 1) return false;

        for (int i = 2; i <= num / 2; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

    static boolean isPrime_Eratos(int num) {
        if(num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
//            int ii = i * i;
//            while (ii < num) ii += i;
            if(num % i == 0) return false;
        }
        return true;
    }
}
