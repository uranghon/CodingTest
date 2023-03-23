package org.example.Backjoon.약수_배수_소수;

import java.io.*;
import java.security.spec.EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다.
 * 예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.
 * 골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다.
 * 이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
 * 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다.
 * 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
 *
 * 2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오.
 * 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
 */
public class Example_9020_골드바흐의추측 {
    static Map<Integer, Integer> primeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        mine1(); // 2번쨰.. 쏘쏘함.
        mine2(); // 얘가 제일 좋음
        mine3(); // 구림.
    }

    static void mine1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());

            for (int i = num / 2; i >= 2; i--) {
                if (isPrimeNumber(i) && isPrimeNumber(num - i)) {
                    bw.write(i + " " + (num - i));
                    bw.newLine();
                    break;
                }
            }
        }

        bw.close();
        br.close();
    }

    static void mine2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());

            for (int i = num / 2; i >= 2; i--) {
                int chkPN1 = primeMap.getOrDefault(i, -1);
                int chkPN2 = primeMap.getOrDefault(num - i, -1);
                if (chkPN1 != 0 && chkPN2 != 0) {
                    if ((chkPN1 == 1 || isPrimeNumber(i)) && (chkPN2 == 1 || isPrimeNumber(num - i))) {
                        bw.write(i + " " + (num - i));
                        bw.newLine();
                        break;
                    }
                }
            }
        }

        bw.close();
        br.close();
    }

    static void mine3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());

            int pNum1 = 0;
            int pNum2 = 0;

            for (int i = 2; i <= num / 2; i++) {
                int chkPN1 = primeMap.getOrDefault(i, -1);
                int chkPN2 = primeMap.getOrDefault(num - i, -1);
                if (chkPN1 != 0 && chkPN2 != 0) {
                    if ((chkPN1 == 1 || isPrimeNumber(i)) && (chkPN2 == 1 || isPrimeNumber(num - i))) {
                        pNum1 = i;
                        pNum2 = num - i;
                    }
                }
            }

            bw.write(pNum1 + " " + pNum2);
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static boolean isPrimeNumber(int num) {
        boolean isPN = false;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && i < num) break;
            else if (num % i == 0 && i == num) isPN = true;
        }
        if (isPN) primeMap.putIfAbsent(num, 1);
        else primeMap.putIfAbsent(num, 0);
        return isPN;
    }

    public static boolean prime[] = new boolean[10001];


    static void others() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        //에라토스테네스의 체
        prime[1] = prime[0] = true;
        for (int i = 2; i < Math.sqrt(10001); i++) {
            if (prime[i] == true)
                continue;
            // 왜 i * 2 가 아니라 i의 제곱으로 시작하는가?
            // 왜냐하면 예를들어 4,6,8, ... / 6,9,12, ... / 8,12,16, ... 이렇게 하는건
            // 예를들어 i가 뭐 100이라 치자. 100 * 2 부터 100 * 99 까지는 딱봐도 오른쪽 항인. 2~99 로 나눠지는게 정해져있고,
            // 이건 i가 2~99 일 때 이미 걸러진다. 그래서 i * 2 부터 i * (i - 1) 까지는 i -1 까지 검사할 때 이미 걸러진다는 뜻이라
            // i * i 부터 i 씩 더해가면서 체크하면 된다.
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            int a = num / 2;
            int b = num / 2;
            while (true) {
                if (prime[a] == false && prime[b] == false) {
                    str.append(a + " " + b + "\n");
                    break;
                }
                a--;
                b++;
            }
        }

        System.out.print(str);
    }
}
