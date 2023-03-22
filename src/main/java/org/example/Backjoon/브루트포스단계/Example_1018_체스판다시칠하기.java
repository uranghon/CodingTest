package org.example.Backjoon.브루트포스단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_1018_체스판다시칠하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

//        mine(n, m);
//        mine2(n, m);
        others(n, m);
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
                    c = c == 'W' ? 'B' : 'W';
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
