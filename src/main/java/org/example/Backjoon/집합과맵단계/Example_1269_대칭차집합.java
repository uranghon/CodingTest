package org.example.Backjoon.집합과맵단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오.
 * 두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.
 *
 * 예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,
 * A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.
 *
 * -풀이-
 * set으로 일단 a 받음
 * a 받은 set에다가 b를 받는데 b의 요소가 a에 들어있는지 체크하면서 있으면 중복cnt 1씩 증가시키면서 받음
 * 다 받고나면 중복된 애들이랑 아닌애들이 set에 들어있음.
 * set의 요소 갯수에서 중복cnt를 빼면 됨.
 *
 * 혹은 입력값이 a몇개, b몇개라는게 있으니까
 * 중복되는 애가 발견되면 -2씩 하면 됨.
 */
public class Example_1269_대칭차집합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        mine1();
    }

    private static void mine1() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        int bCnt = Integer.parseInt(st.nextToken());
        Set<Integer> aSet = new HashSet<>(aCnt);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }
        int dupl = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if(aSet.contains(Integer.parseInt(st.nextToken()))) dupl += 2;
        }

        System.out.print(aCnt + bCnt - dupl);
    }

    private static void mine2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        int bCnt = Integer.parseInt(st.nextToken());
        List<Integer> aList = new ArrayList<>(aCnt);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            aList.add(Integer.parseInt(st.nextToken()));
        }
        aList.sort((a, b) -> a - b);
        int dupl = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if(Collections.binarySearch(aList, Integer.parseInt(st.nextToken())) > -1) dupl += 2;
        }

        System.out.print(aCnt + bCnt - dupl);
    }
}
