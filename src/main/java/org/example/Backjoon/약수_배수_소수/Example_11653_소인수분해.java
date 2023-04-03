package org.example.Backjoon.약수_배수_소수;

import java.io.*;

/**
 * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 * N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
 *
 * -풀이-
 * n 을 i로 나누는데
 * i를 2부터 일단 현재 i로 나머지가 0이게 나눠질때까지 n 을 나누고 안나눠지면 i를 1씩 올려가며 반복한다.
 * 반복하는 중에 i 가 남은 n / i 보다 커지면 종료한다.
 * i > n / i 는 i * i > n 이랑 같다. 에라토스테네스의 체에서 본거랑 같다
 */
public class Example_11653_소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
//        mine(num);
//        others1(num);
        others2(num);
        br.close();
    }

    static void mine(int num) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (num > 1) {
            int sosu = 2;
            // 현재 소수로 나눠지면 sosu를 다시 2로 되돌리는 방식. 다른사람꺼가 맞는듯. 어짜피 넘어가면 다시 2로 갈 일이 없음.
            while (sosu <= num) {
                if (num % sosu == 0) {
                    bw.write(String.valueOf(sosu));
                    bw.newLine();
//                    System.out.println(sosu);
                    num /= sosu;
                    sosu = 2;
                } else sosu++;
            }
        }
        bw.close();
    }
    static void others1(int num) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (num > 1) {
            int sosu = 2;
            // 현재 소수로 나눠지면 continue 로 ++ 건너뛰는 방식.
            while (sosu <= num) {
                if(num % sosu == 0){
                    bw.write(String.valueOf(sosu));
                    bw.newLine();
                    num /= sosu;
                    continue;
                }
                sosu++;
            }
        }
        bw.close();
    }

    static void others2(int num) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(num > 3)
        {
            // 현재 소수로 나눌만큼 나누고 ++ 하는 방식.
            for(int i = 2; i <= num / i; i++) {
                while(num % i == 0) {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                    num /= i;
                }
            }
        }

        if(num > 1) bw.write(String.valueOf(num));

        bw.flush();
    }
}
