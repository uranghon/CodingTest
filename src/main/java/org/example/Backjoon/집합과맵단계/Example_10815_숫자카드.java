package org.example.Backjoon.집합과맵단계;

import java.io.*;
import java.util.*;

/**
 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
 * 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
 * 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
 *
 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
 * 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
 * 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
 *
 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.
 *
 * 한마디로 4번째 줄에 받는 애들 중에 2번째 줄에서도 받은 애는 1, 처음 받은 애들은 0 으로 출력
 *
 * -풀이-
 * set 또는 boolean 형 카운팅배열 써서 있으면 1 없으면 0 출력하면 된다.
 */
public class Example_10815_숫자카드 {

    static boolean[] card = new boolean[20_000_001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
//        mine1();
        mine2();
        bw.flush();
    }

    static void mine1() throws IOException {
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            card[Integer.parseInt(st.nextToken()) + 10_000_000] = true;
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if(card[Integer.parseInt(st.nextToken()) + 10_000_000]) bw.write("1 ");
            else bw.write("0 ");
        }
    }

    static void mine2() throws IOException {
        Set<Integer> cardSet = new HashSet<>(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            cardSet.add(Integer.parseInt(st.nextToken()));
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if(cardSet.contains(Integer.parseInt(st.nextToken()))) bw.write("1 ");
            else bw.write("0 ");
        }
    }

    static void mine3() throws IOException {
        Map<Integer, Boolean> map = new HashMap<>(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            map.putIfAbsent(Integer.parseInt(st.nextToken()), true);
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if(map.containsKey(Integer.parseInt(st.nextToken()))) bw.write("1 ");
            else bw.write("0 ");
        }
    }
}
