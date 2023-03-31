package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다.
 * 바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ..., 가장 오른쪽 바구니를 N번째 바구니라고 부른다.
 * 도현이는 앞으로 M번 바구니의 순서를 회전시키려고 만들려고 한다.
 * 도현이는 바구니의 순서를 회전시킬 때, 순서를 회전시킬 범위를 정하고, 그 범위 안에서 기준이 될 바구니를 선택한다.
 * 도현이가 선택한 바구니의 범위가 begin, end이고, 기준이 되는 바구니를 mid라고 했을 때,
 * begin, begin+1, ..., mid-1, mid, mid+1, ..., end-1, end 순서로 되어있는 바구니의 순서를
 * mid, mid+1, ..., end-1, end, begin, begin+1, ..., mid-1로 바꾸게 된다.
 *
 * 바구니의 순서를 어떻게 회전시킬지 주어졌을 때, M번 바구니의 순서를 회전시킨 다음, 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
 *
 * -입력-
 * 첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
 * 둘째 줄부터 M개의 줄에는 바구니의 순서를 바꾸는 만드는 방법이 주어진다.
 * 방법은 i, j, k로 나타내고, 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 회전시키는데, 그 때 기준 바구니는 k번째 바구니라는 뜻이다. (1 ≤ i ≤ k ≤ j ≤ N)
 * 도현이는 입력으로 주어진 순서대로 바구니의 순서를 회전시킨다.
 *
 * -출력-
 * 모든 순서를 회전시킨 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.
 *
 * -풀이-
 * 링크드리스트 사용
 */
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

//            for (int j = begin - 1; j < mid - 1; j++) {
//                list.add(end + j - (begin - 1), list.get(j));
            for (int j = 0; j < mid - begin; j++) {
                list.add(end - 1, list.remove(begin - 1)); // list.remove(begin - 1) 는 begin - 1 위치꺼를 지우면서 걔를 반환한다.
            }

//            for (int j = begin - 1; j < mid - 1; j++) {
//                list.remove(begin - 1);
//            }
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(i -> sb.append(i).append(" "));
        System.out.print(sb);
    }
}
