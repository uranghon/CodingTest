package org.example.Backjoon.브루트포스단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
 * 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
 * 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
 * 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 *
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
 * 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 *
 */
public class Example_1018_체스판다시칠하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        mine(n, m);
//        mine2(n, m);
//        others(n, m);
    }

    static void mine(int n, int m) throws IOException {

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int row = 0;
        int col = 0;
        int check = 0;
        int min = 64;

        while (row <= n - 8) {
            while (col <= m - 8) {
                check = 0;
                char c = board[row][col];
//                char c1 = board[row][col];
//                char c2 = c1 == 'W' ? 'B' : 'W';

                for (int i = row; i < row + 8; i++) {
//                    for (int j = col; j < col + 8; j += 2) {
                    for (int j = col; j < col + 8; j++) {
                        if (board[i][j] != c) check++;
//                        if(board[i][j] != c1) check++;
//                        if(board[i][j + 1] != c2) check++;
                        c = c == 'W' ? 'B' : 'W';
                    }
                    c = c == 'W' ? 'B' : 'W'; // 위에 보면 마지막 컬럼에서 작업후에 또 바꾸니까 여기서 다시 바꿔줘야함.
//                    c1 = c1 == 'W' ? 'B' : 'W';
//                    c2 = c1 == 'W' ? 'B' : 'W';
                }

                check = Math.min(check, 64 - check);
                min = Math.min(min, check);

                if (min == 0) {
                    System.out.print(0);
                    return;
                }

                col++;
            }
            col = 0;
            row++;
        }

        System.out.print(min);
    }

    /**
     * W, B 대신 TRUE, FALSE 로 받는 방법.
     * 알고리즘 자체는 mine 이랑 같다.
     */
    static void mine2(int n, int m) throws IOException {

        boolean[][] board = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (br.read() == 'W') board[i][j] = true;
            }
            br.read();
        }

        int row = 0;
        int check = 0;
        int min = 64;

        while (row <= n - 8) {
            int col = 0;
            while (col <= m - 8) {
                check = 0;
                boolean blTF = board[row][col];

                for (int i = row; i < row + 8; i++) {
                    for (int j = col; j < col + 8; j++) {
                        if (board[i][j] != blTF) check++;
                        blTF = !blTF;
                    }
                    blTF = !blTF;
                }

                check = Math.min(check, 64 - check);
                min = Math.min(min, check);

                if (min == 0) {
                    System.out.print(0);
                    return;
                }

                col++;
            }
            row++;
        }

        System.out.print(min);
    }

    static void others(int n, int m) throws IOException {

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int row = 0;
        int cnt = 0;
        int min = 64;

        char[][] chkBoard = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

        while (row <= n - 8) {
            int col = 0;
            while (col <= m - 8) {
                cnt = 0;
                for (int i = row; i < row + 8; i++) {
                    for (int j = col; j < col + 8; j++) {
                        if (board[i][j] != chkBoard[i % 2][j - col]) cnt++;
                    }
                }

                cnt = Math.min(cnt, 64 - cnt);
                min = Math.min(min, cnt);

                if (min == 0) {
                    System.out.print(0);
                    return;
                }

                col++;
            }
            row++;
        }

        System.out.print(min);
    }
}
