package org.example.Backjoon.집합과맵단계;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * -- 설명 --
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다.
 * 상근이는 숫자 카드 N개를 가지고 있다.
 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 *
 * -- 입력 --
 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
 * 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
 * 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 *
 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
 * 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
 * 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 *
 * -- 출력 --
 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
 */
public class Example_10816_숫자카드2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
//        int n = Integer.parseInt(br.readLine());
//        mine1(); // 카운팅정렬
//        mine2(); // 맵사용
        mine3(); // 카운팅정렬에서 배열 범위를 좁히는 방법
        bw.flush();
    }

    private static void mine1() throws IOException {
        int[] card = new int[20_000_001];
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            card[Integer.parseInt(st.nextToken()) + 10_000_000]++;
        }

        br.readLine();
        st = new StringTokenizer(br.readLine());
        bw.write(card[Integer.parseInt(st.nextToken()) + 10_000_000] + "");
        while (st.hasMoreTokens()) {
            bw.write(" " + card[Integer.parseInt(st.nextToken()) + 10_000_000]);
        }
    }

    private static void mine2() throws IOException {
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            bw.write(map.getOrDefault(st.nextToken(), 0) + " ");
        }
    }

    private static void mine3() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int min = 10_000_000;
        int max = -10_000_000;
        int[] origin = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            if(min > origin[i]) min = origin[i];
            if(max < origin[i]) max = origin[i];
        }
        int[] card = new int[max - min + 1];

        for (int i = 0; i < n; i++) {
            card[origin[i] - min]++;
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(num < min || num > max) bw.write("0 ");
            else bw.write(card[num - min] + " ");
        }
    }
}
