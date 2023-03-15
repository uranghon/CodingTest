package org.example.Backjoon.약수_배수_소수;

import java.io.*;

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

        // 현재 소수로 나눌만큼 나누고 ++ 하는 방식.
        for(int i = 2; i <=num; i++) {
            while(num % i == 0) {
                bw.write(String.valueOf(i));
                bw.newLine();
                num /= i;
            }
        }

        bw.close();
    }
}
