package org.example.Backjoon.재귀단계;

import java.io.*;

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
