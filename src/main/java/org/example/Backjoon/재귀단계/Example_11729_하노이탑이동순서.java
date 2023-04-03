package org.example.Backjoon.재귀단계;

import java.io.*;

/**
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.
 * 각 원판은 반경이 큰 순서대로 쌓여있다.
 * 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
 *
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 *
 * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
 *
 * -풀이-
 * 맥스값은 목적지로 딱 한번 이동하면 됨.
 * 맥스값이 이동하기 위해선 맥스값 위 애들이 일단 한번 목적지 아닌곳으로 쌓이고,
 * 맥스값이 목적지로 이동한 후
 * 앞서 이동했던 애들이 또 목적지로 쭉 와야함.
 * 이게 재귀형식으로 1짜리 원판까지 내려간다고 보면 됨.
 *
 * 이걸 식으로 표현하면
 * 맥스값 위 애들이 목적지가 아닌 곳으로 쭉 이동하는 횟수를 n 이라 했을 때,
 * 2n + 1 이 된다.
 */
public class Example_11729_하노이탑이동순서 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] hanoiArr;
    static int[] idxArr = new int[4];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        // 전체 이동 횟수 : 이전꺼 * 2 + 1 또는 2^n - 1
        // 전체가 짝수일때 홀수판은 오른쪽, 짝수판은 왼쪽 이동. 원판체크는 좌측이동
        // 전체가 홀수일때 홀수판은 왼쪽, 짝수판은 오른쪽 이동. 원판체크는 우측이동

        sb.append((int) Math.pow(2, n) - 1).append("\n");

//        hanoiArr = new int[4][n + 1];
//        for (int i = n; i > 0; i--) {
//            hanoiArr[1][n - i + 1] = i;
//        }
//        idxArr[1] = n;

//        if(n % 2 == 0) hanoiEven(n, 1);
//        else hanoiOdd(n, 1);

        hanoi(n, 1, 2, 3);
//        bw.write(Arrays.toString(hanoiArr[3]));
//        bw.write(sb.toString());
//        bw.flush();
        System.out.print(sb);
    }

    static void hanoiEven(int n, int idx) {
        int idxL = idx > 1 ? idx - 1 : 3;
        int idxR = idx < 3 ? idx + 1 : 1;

        if (idxArr[idx] == 0) hanoiEven(n, idxL);
        if (idxArr[3] == n) return;

        int num = hanoiArr[idx][idxArr[idx]];
        int numL = hanoiArr[idxL][idxArr[idxL]];
        int numR = hanoiArr[idxR][idxArr[idxR]];

        if (num % 2 > 0) { // n 짝수, 홀수원판
            if (num < numR || numR == 0) {
                sb.append(idx).append(" ").append(idxR).append("\n");
                hanoiArr[idxR][++idxArr[idxR]] = num;
                hanoiArr[idx][idxArr[idx]--] = 0;
                hanoiEven(n, idx);
            } else {
                hanoiEven(n, idxL);
            }
        } else { // n 짝수, 짝수원판
            if (num < numL || numL == 0) {
                sb.append(idx).append(" ").append(idxL).append("\n");
                hanoiArr[idxL][++idxArr[idxL]] = num;
                hanoiArr[idx][idxArr[idx]--] = 0;
                hanoiEven(n, idx);
            } else {
                hanoiEven(n, idxL);
            }
        }
    }

    static void hanoiOdd(int n, int idx) {
        int idxL = idx > 1 ? idx - 1 : 3;
        int idxR = idx < 3 ? idx + 1 : 1;

        if (idxArr[idx] == 0) hanoiOdd(n, idxR);
        if (idxArr[3] == n) return;

        int num = hanoiArr[idx][idxArr[idx]];
        int numL = hanoiArr[idxL][idxArr[idxL]];
        int numR = hanoiArr[idxR][idxArr[idxR]];

        if (num % 2 > 0) { // n 홀수, 홀수원판
            if (num < numL || numL == 0) {
                sb.append(idx).append(" ").append(idxL).append("\n");
                hanoiArr[idxL][++idxArr[idxL]] = num;
                hanoiArr[idx][idxArr[idx]--] = 0;
                hanoiOdd(n, idx);
            } else {
                hanoiOdd(n, idxR);
            }
        } else { // n 홀수, 짝수원판
            if (num < numR || numR == 0) {
                sb.append(idx).append(" ").append(idxR).append("\n");
                hanoiArr[idxR][++idxArr[idxR]] = num;
                hanoiArr[idx][idxArr[idx]--] = 0;
                hanoiOdd(n, idx);
            } else {
                hanoiOdd(n, idxR);
            }
        }
    }

    /**
     * 이야 이거 좋네.
     * 이전꺼의 2배 + 1을 제대로 구현했네
     *
     * 맥스값은 목적지로 딱 한번 이동하면 됨.
     *
     * 맥스값이 이동하기 위해선 자기 위 애들이 일단 한번 목적지 아닌곳으로 쌓이고
     * 맥스값 이동한 후
     * 앞서 이동했던 애들이 또 자기한테 쭉 와야함.
     *
     * 이게 재귀형식으로 1짜리 원판까지 내려간다고 보면 됨.
     */
    public static void hanoi(int n, int from, int other, int to) {
        if (n == 0) return;

        hanoi(n - 1, from, to, other);

        sb.append(from).append(" ").append(to).append('\n');

        hanoi(n - 1, other, from, to);
    }
}
