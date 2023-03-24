package org.example.Backjoon.집합과맵단계;

import java.io.*;
import java.util.*;

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
