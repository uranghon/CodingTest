package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
 * (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 *
 * -풀이-
 * 11650 반대로 하면 된다.
 *
 */
public class Example_11651_좌표정렬하기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] iArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            iArr[i][0] = Integer.parseInt(st.nextToken());
            iArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(iArr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int[] a : iArr) {
            bw.write(a[0] + " " + a[1] + "\n");
        }

//        Arrays.stream(iArr).sorted((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]).forEach(a -> {
//            try {
//                bw.write(a[0] + " " + a[1] + "\n");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });

        bw.flush();
    }
}
