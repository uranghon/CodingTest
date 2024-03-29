package org.example.Backjoon.기본수학1단계;

import java.util.Scanner;

/**
 * 외계 지형은 중앙 이동 알고리즘을 이용해서 만들려고 한다.
 * 알고리즘을 시작하면서 상근이는 정사각형을 이루는 점 4개를 고른다. (1번. 정사각형 만들기)
 * 그 후에는 다음과 같은 과정을 거쳐서 지형을 만든다.
 * - 정사각형의 각 변의 중앙에 점을 하나 추가한다.
 * - 정사각형의 중심에 점을 하나 추가한다.
 * 초기 상태에서 위와 같은 과정을 한 번 거치면 총 4개의 정사각형이 새로 생긴다. 이와 같은 과정을 상근이가 만족할 때 까지 계속한다.
 *
 * 상근이는 어떤 점은 한 개 보다 많은 정사각형에 포함될 수 있다는 사실을 알았다.
 * 메모리 소모량을 줄이기 위해서 중복하는 점을 한 번만 저장하려고 한다.
 * 과정을 N번 거친 후 점 몇 개를 저장해야 하는지 구하는 프로그램을 작성하시오.
 *
 * -입력-
 * 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 15)
 *
 * -출력-
 * 첫째 줄에 과정을 N번 거친 후 점의 수를 출력한다.
 *
 * -풀이-
 * 한변에 있는 점의 갯수의 제곱개를 출력하면 된다.
 * 변의 점이 늘어나는 메카니즘은
 * i 번째 점 갯수 = (i - 1) 번째 점 갯수 + ((i - 1) 번째 점 갯수 - 1) = (i - 1) 번째 점 갯수 * 2 - 1 개가 된다.
 */
public class Example_2903_중앙이동알고리즘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = 2;
        for (int i = 0; i < n; i++) {
            p += p - 1;
            // p = p * 2 - 1;
        }
        System.out.print(p * p);
    }
}
