package org.example.Backjoon.기본수학1단계;

import java.io.*;

/**
 * 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
 * 이 아파트에 거주를 하려면 조건이 있는데,
 * “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때,
 * 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
 * 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 *
 * - 입력 -
 * 첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다
 *
 * - 출력 -
 * 각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
 *
 * - 풀이 -
 * n 호 길이의 int 형 배열 만들고
 * 먼저 0 층 각 호실 인원을 배열에 넣는다.
 * 층을 올라가면서 바로 앞호꺼를 현재호에 더해준다.
 *
 * 왜 바로 앞 호냐? 1호부터 앞호까지가 아니라?
 * 에를 들어 2층 3호의 인원은
 * 1층 1,2,3호의 인원의 합 이어야한다.
 * 근데 2층 2호는 1층 1,2호의 인원 합이다.
 * 그렇다면 2층 3호는 2층2호 + 1층 3호 하면 된다.
 * 1호부터 더해오면 3호때 아직 더하기 전에는
 * 배열[이전 호] 는 아래층 이전 호 까지 인원 합
 * 배열[지금 호] 는 아래층 지금 호의 인원
 */
public class Example_2775_부녀회장이될테야 {

    // 0 층 1 2 3 4 5 6 7 ~~
    // 1 층 1 12 123 1234
    // 2 층 1 112 112123 1121231234
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0)
        {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            int[] floor = new int[n];

            for (int i = 0; i < n; i++) {
                floor[i] = i + 1;
            }

            for(int i = 1; i <= k; i++)
            {
                floor = upFloor(floor);
            }

            bw.write(floor[n - 1] + "");
            bw.newLine();
        }
        bw.flush();
    }

    static int[] upFloor(int[] floor)
    {
        int n = floor.length;
        for (int i = 1; i < n; i++) {
            floor[i] = floor[i - 1] + floor[i];
        }
        return floor;
    }

    static void mine(int k, int n) {

        int[] floor = new int[n];

        // 1층
        for (int i = 0; i < n; i++) {
            floor[i] = i + 1;
        }

        for(int i = 1; i <= k; i++)
        {
            floor = upFloor(floor);
        }
    }
}
