package org.example.Backjoon.재귀단계;

import java.io.*;
import java.util.Arrays;

/**
 * 재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
 *
 * 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
 *
 * ***
 * * *
 * ***
 *
 * N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.
 * 예를 들어 크기 27의 패턴은 다음과 같다.
 *
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * ***   ******   ******   ***
 * * *   * ** *   * ** *   * *
 * ***   ******   ******   ***
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * *********         *********
 * * ** ** *         * ** ** *
 * *********         *********
 * ***   ***         ***   ***
 * * *   * *         * *   * *
 * ***   ***         ***   ***
 * *********         *********
 * * ** ** *         * ** ** *
 * *********         *********
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * ***   ******   ******   ***
 * * *   * ** *   * ** *   * *
 * ***   ******   ******   ***
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 *
 * -풀이-
 * 1. 단게를 둬서 가운데를 파내는 식으로 처리하기.
 * 2. 최소단위 패턴을 복사해서 채워넣기
 */
public class Example_2447_별찍기10 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
//        mine1();
        others();
        bw.flush();
    }

    static void mine1() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] stars = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(stars[i], '*');
        }
        makePattern(n, stars, 0, 0);

        bw.write(stars[0]);
        for (int i = 1; i < n; i++) {
            bw.newLine();
            bw.write(stars[i]);
        }
    }

    static void makePattern(int n, char[][] stars, int row, int col) {
        int p = n / 3;
        if (p == 0) return;

        for (int i = row + p; i < row + 2 * p; i++) {
            for (int j = col + p; j < col + 2 * p; j++) {
                stars[i][j] = ' ';
            }
        }

        for (int i = row; i < row + n; i += p) {
            for (int j = col; j < col + n; j += p) {
                if (i != row + p || j != col + p) makePattern(p, stars, i, j);
            }
        }
    }

    static void others() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        recur(arr, n, 0, 0, false);

        bw.write(arr[0]);
        for (int i = 1; i < n; i++) {
            bw.newLine();
            bw.write(arr[i]);
        }
    }

    public static void recur(char[][] arr, int n, int x, int y, boolean check) {
        if (check) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        int count = 0;
        for (int i = x; i < x + n; i += n / 3) {
            for (int j = y; j < y + n; j += n / 3) {
                count++;
                if (count == 5) {
                    recur(arr, n / 3, i, j, true);
                } else {
                    recur(arr, n / 3, i, j, false);
                }
            }
        }
    }
}
