package org.example.Backjoon.재귀단계;

import java.io.*;

/**
 * 칸토어 집합은 0과 1사이의 실수로 이루어진 집합으로, 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만든다.
 * 전체 집합이 유한이라고 가정하고, 다음과 같은 과정을 통해서 칸토어 집합의 근사를 만들어보자.
 * <p>
 * 1. -가 3^N개 있는 문자열에서 시작한다.
 * 2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.
 * 3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.
 * <p>
 * 예를 들어, N=3인 경우, 길이가 27인 문자열로 시작한다.
 * ---------------------------
 * 여기서 가운데 문자열을 공백으로 바꾼다.
 * ---------         ---------
 * 남은 두 선의 가운데 문자열을 공백으로 바꾼다.
 * ---   ---         ---   ---
 * 한번 더
 * - -   - -         - -   - -
 * 모든 선의 길이가 1이면 멈춘다. N이 주어졌을 때, 마지막 과정이 끝난 후 결과를 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력은 여러 줄로 이루어져 있다. 각 줄에 N이 주어진다. 파일의 끝에서 입력을 멈춘다. N은 0보다 크거나 같고, 12보다 작거나 같은 정수이다.
 * 입력으로 주어진 N에 대해서, 해당하는 칸토어 집합의 근사를 출력한다.
 */
public class Example_4779_칸토어집합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
//        mine1();
        mine2();
        bw.flush();
    }

    static void mine1() throws IOException {
        String space = " ";
        String str = "";
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder("-");
            for (int i = 0; i < n; i++) {
                String tmpSb = sb.toString();
                sb.append(space.repeat((int) Math.pow(3, i))).append(tmpSb);
            }
            bw.write(sb.toString());
            bw.newLine();
        }
    }

    static void mine2() throws IOException {
        String str = "";

        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int repeatCnt = (int) Math.pow(3, n);
            char[] chars = "-".repeat(repeatCnt).toCharArray();
            cantor(chars, n, 0, repeatCnt - 1);
            bw.write(chars);
            bw.newLine();
        }
    }

    static void cantor(char[] chars, int n, int fr, int to) {
        if (n == 0) return;

        int s = (int) Math.pow(3, n - 1);
        for (int i = fr + s; i < fr + s * 2; i++) {
            chars[i] = ' ';
        }
        cantor(chars, n - 1, fr, fr + s - 1);
        cantor(chars, n - 1, fr + s * 2, to);
    }
}
