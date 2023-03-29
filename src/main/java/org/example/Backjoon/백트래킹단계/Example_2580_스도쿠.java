package org.example.Backjoon.백트래킹단계;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example_2580_스도쿠 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] sudoku = new int[9][9];
    static int[] rowSum = new int[9];
    static int[] rowUsed = new int[9];
    static int[] colUsed = new int[9];
    static int[][] squareUsed = new int[3][3];
    static int[] rowZeroCnt = new int[9];
    static int[] colSum = new int[9];
    static int[] colZeroCnt = new int[9];

    static int[][] squareSum = new int[3][3];
    static int[][] squareZeroCnt = new int[3][3];
    static int totalZeroCnt = 0;
    static int totalOverNumCtn = 0;
    static final int maxSum = 45;
    static String fullStr = "123456789";

    static StringBuilder sb = new StringBuilder();
    static boolean blExit = false;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) {
//                    totalZeroCnt++;
//                    rowZeroCnt[i]++;
//                    colZeroCnt[j]++;
//                    squareZeroCnt[i / 3][j / 3]++;
                } else {
                    rowUsed[i] |= 1 << sudoku[i][j];
                    colUsed[j] |= 1 << sudoku[i][j];
                    squareUsed[i / 3][j / 3] |= 1 << sudoku[i][j];
                }

//                rowSum[i] += sudoku[i][j];
//                colSum[j] += sudoku[i][j];
//                squareSum[i / 3][j / 3] += sudoku[i][j];
            }
        }

//        while (totalZeroCnt > 0) {
//            int tmp = totalZeroCnt;
//            fillSudokuRow(0);
//            fillSudokuCol(0);
//            fillSudokuSquare(0, 0);
//            if (tmp == totalZeroCnt) break;
//        }
//
//        do {
//            int tmp = totalOverNumCtn;
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    setSudoku(i, j);
//                }
//            }
//            if (tmp == totalOverNumCtn) break;
//        } while (totalOverNumCtn > 0);
//
//        for (int i = 0; i < 9; i++) {
//            System.out.println(Arrays.toString(sudoku[i]));
//        }

        fillSudoku(0, 0);

        System.out.print(sb);
    }

    static void fillSudokuRow(int row) {
        if (row == 9) return;
//        if(rowZeroCnt[row] == 0) return;
        if (rowZeroCnt[row] == 1) {
            for (int col = 0; col < 9; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = maxSum - rowSum[row];

                    rowSum[row] += sudoku[row][col];
                    rowZeroCnt[row]--;

                    colSum[col] += sudoku[row][col];
                    colZeroCnt[col]--;

                    squareSum[row / 3][col / 3] += sudoku[row][col];
                    squareSum[row / 3][col / 3]--;

                    totalZeroCnt--;
                }
            }
        }

        fillSudokuRow(row + 1);
    }

    static void fillSudokuCol(int col) {
        if (col == 9) return;
//        if(colZeroCnt[col] == 0) return;

        if (colZeroCnt[col] == 1) {
            for (int row = 0; row < 9; row++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = maxSum - colSum[col];

                    rowSum[row] += sudoku[row][col];
                    rowZeroCnt[row]--;

                    colSum[col] += sudoku[row][col];
                    colZeroCnt[col]--;

                    squareSum[row / 3][col / 3] += sudoku[row][col];
                    squareSum[row / 3][col / 3]--;

                    totalZeroCnt--;
                }
            }
        }

        fillSudokuCol(col + 1);
    }

    static void fillSudokuSquare(int row, int col) {
        if (col == 9) {
            row += 3;
            col = 0;
        }

        if (row == 9) return;

        if (squareZeroCnt[row / 3][col / 3] == 1) {
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (sudoku[i][j] == 0) {
                        sudoku[i][j] = maxSum - squareSum[i / 3][j / 3];

                        rowSum[i] += sudoku[i][j];
                        rowZeroCnt[i]--;

                        colSum[j] += sudoku[i][j];
                        colZeroCnt[j]--;

                        squareSum[i / 3][j / 3] += sudoku[i][j];
                        squareSum[i / 3][j / 3]--;

                        totalZeroCnt--;
                    }
                }
            }
        }

        fillSudokuSquare(row, col + 3);
    }

    static void setSudoku(int row, int col) {
        if (sudoku[row][col] > 0 && sudoku[row][col] < 10) return;

        String tmp = new String(fullStr);
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] > 0 && sudoku[row][i] < 10) {
                tmp = tmp.replace(sudoku[row][i] + "", "");
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] > 0 && sudoku[i][col] < 10) {
                tmp = tmp.replace(sudoku[i][col] + "", "");
            }
        }

        for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
            for (int j = 3 * (col / 3); j < 3 * (col / 3) + 3; j++) {
                if (sudoku[i][j] > 0 && sudoku[i][j] < 10) {
                    tmp = tmp.replace(sudoku[i][j] + "", "");
                }
            }
        }

        if (sudoku[row][col] == 0 && tmp.length() > 1) {
            totalOverNumCtn++;
        } else if (sudoku[row][col] > 9 && tmp.length() == 1) {
            totalOverNumCtn--;
        }
        sudoku[row][col] = Integer.parseInt(tmp);
    }

    static void dfsSudoku2(int row, int col) {
        if (sudoku[row][col] > 0 && sudoku[row][col] < 10) return;

        String[] split = String.valueOf(sudoku[row][col]).split("");

        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == col) {
                    sudoku[row][j] = Integer.parseInt(split[i]);
                } else if (j != col && sudoku[row][j] > 10) {
                    sudoku[row][j] = Integer.parseInt((sudoku[row][j] + "").replace(split[i], ""));
                }
            }
        }


//        for (int i = 0; i < 9; i++) {
//            if (sudoku[i][col] > 0 && sudoku[i][col] < 10) {
//                tmp = tmp.replace(sudoku[i][col] + "", "");
//            }
//        }
//
//        for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
//            for (int j = 3 * (col / 3); j < 3 * (col / 3) + 3; j++) {
//                if (sudoku[i][j] > 0 && sudoku[i][j] < 10) {
//                    tmp = tmp.replace(sudoku[i][j] + "", "");
//                }
//            }
//        }
//
//        if(sudoku[row][col] == 0 && tmp.length() > 1)
//        {
//            totalOverNumCtn++;
//        }
//        else if(sudoku[row][col] > 9 && tmp.length() == 1)
//        {
//            totalOverNumCtn--;
//        }
//        sudoku[row][col] = Integer.parseInt(tmp);
    }

    static void fillSudoku(int row, int col) {
        if (col == 9) {
            fillSudoku(row + 1, 0);
        } else if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            blExit = true;
            return;
        } else if (sudoku[row][col] > 0) {
            fillSudoku(row, col + 1);
        } else {
            for (int k = 1; k <= 9; k++) {
//                if (!checkSudoku(row, col, k)) continue;
                if ((rowUsed[row] & 1 << k) > 0 || (colUsed[col] & 1 << k) > 0 || (squareUsed[row / 3][col / 3] & 1 << k) > 0) continue;

                sudoku[row][col] = k;

                rowUsed[row] |= 1 << k;
                colUsed[col] |= 1 << k;
                squareUsed[row / 3][col / 3] |= 1 << k;

                fillSudoku(row, col + 1);
                if (blExit) return;

                sudoku[row][col] = 0;
                rowUsed[row] ^= 1 << k;
                colUsed[col] ^= 1 << k;
                squareUsed[row / 3][col / 3] ^= 1 << k;

            }
        }
    }

    static boolean checkSudoku(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == num) return false;
            if (sudoku[row][i] == num) return false;
        }

        for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
            for (int j = 3 * (col / 3); j < 3 * (col / 3) + 3; j++) {
                if (sudoku[i][j] == num) return false;
            }
        }

        return true;
    }
}
