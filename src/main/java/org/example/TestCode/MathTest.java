package org.example.TestCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
//            double n = Double.parseDouble(str);
//
//            System.out.println(Math.floor(n));// 값기준 내림. 음수로 가도 계속 아래로. -2.5 를 내리면 -3
//            System.out.println(Math.ceil(n)); // 값기준 올림. 음수도 양수도 계속 위로. -2.5 를 올리면 -2
//            System.out.println(Math.abs(n)); // 절대값
//            System.out.println(Math.rint(n)); // 0.5 기준 짝수쪽 반올림. 음양수 상관없이 가까운거 우선. 0.5면 가까운 짝수 반환
//            System.out.println(Math.round(n)); // 0.5 기준 위쪽 반올림. 정수형 반환. 2.5 는 3, -2.5 는 -2
            String l = "2.1";
            String r = "2.2";
            double dl = Double.parseDouble(l);
            double dr = Double.parseDouble(r);
            System.out.println(dl);
            System.out.println(dr);
            System.out.println(dl + dr);
            if (dl + dr == 4.3) System.out.print("T");
            else {
                System.out.print("F");
                break;
            }
        }
    }
}
