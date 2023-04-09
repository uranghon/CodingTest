package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.*;
//import java.util.stream.Stream;

/**
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번 점의 위치 xi와 yi가 주어진다.
 * (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 *
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 *
 * -풀이-
 * 1. 좌표 클래스 만들고, 정렬문 작성
 * 2. 좌표니까 int[n][2] 배열 만들어서 x좌표부터 비교하고 y 좌표 비교하는 정렬문 작성.
 * 3.
 */

public class Example_11650_좌표정렬하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
//        mine1();
        mine2();
    }

    static void mine1() throws IOException {
        int n = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<Integer>> xyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::new).toArray();

            ArrayList<Integer> orDefault = xyMap.getOrDefault(arr[0], new ArrayList<>());
            orDefault.add(arr[1]);
            xyMap.put(arr[0], orDefault);
        }
        StringBuilder sb = new StringBuilder();

        xyMap.keySet().stream().sorted().forEach((k) -> {
                    ArrayList<Integer> integers = xyMap.get(k);
                    integers.sort((a, b) -> a - b);
                    integers.forEach(a -> sb.append(k + " " + a + "\n"));
                }
        );

        System.out.println(sb);
    }

    static void mine2() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] iArr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            iArr[i][0] = Integer.parseInt(s[0]);
            iArr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(iArr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int[] ints : iArr) {
            bw.write(ints[0] + " " + ints[1] + "\n");
        }

        bw.flush();
    }
}
