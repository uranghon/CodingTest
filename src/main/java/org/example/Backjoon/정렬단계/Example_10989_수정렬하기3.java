package org.example.Backjoon.정렬단계;

import java.io.*;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
 *
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * -풀이-
 * 수의 범위가 갯수보다 상대적으로 작다. 카운팅 정렬을 사용한다.
 */
public class Example_10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] iArr = new int[10001];

        for (int i = 0; i < n; i++) {
            iArr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr[i]; j++) {
                bw.write(i + "\n");
            }
        }

//        bw.close();
        bw.flush();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] > 0) {
                sb.append((i + "\n").repeat(iArr[i]));
            }
        }
        System.out.print(sb);
        bw.close();
        br.close();
    }
}
