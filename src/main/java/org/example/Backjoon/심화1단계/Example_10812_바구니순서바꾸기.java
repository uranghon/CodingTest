package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example_10812_바구니순서바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//        int[] basket = new int[Integer.parseInt(st.nextToken())];
//        for (int i = 0; i < basket.length; i++) {
//            basket[i] = i+1;
//        }
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

//        LinkedList<Integer> list = new LinkedList<>(Arrays.stream(basket).boxed().collect(Collectors.toList()));


        int begin = 0; // 시작
        int mid = 0; // 끝
        int end = 0; // 기준

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            begin = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            mid = Integer.parseInt(st.nextToken());

            for (int j = begin - 1; j < mid - 1; j++) {
                list.add(end + j - (begin - 1), list.get(j));
            }

            for (int j = begin - 1; j < mid - 1; j++) {
                list.remove(begin - 1);
            }
        }
        list.forEach(i -> System.out.print(i + " "));
    }
}
