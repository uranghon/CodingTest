package org.example.Backjoon.백트래킹단계;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Example_9663_NQueen {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static boolean[][] queen;
    static int[] queen2;
    static int cnt = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        queen = new boolean[n][n];
        queen2 = new int[n];
//        nQueen(0);
//        System.out.print(cnt);
        nQueen2(0);
        System.out.print(cnt2);
    }

    static void nQueen(int row) throws IOException {
        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (chkQueen(row - 1, i, 1)) continue;

            queen[row][i] = true;
            nQueen(row + 1);
            queen[row][i] = false;
        }
    }

    static boolean chkQueen(int row, int col, int depth) {
        if (row < 0) return false;

        if (col >= depth && queen[row][col - depth]) return true;
        if (queen[row][col]) return true;
        if (col + depth < n && queen[row][col + depth]) return true;

        return chkQueen(row - 1, col, depth + 1);
    }

    static void nQueen2(int row) {
        if (row == n) {
            cnt2++;
            return;
        }

        for (int i = 0; i < n; i++) {
            queen2[row] = i;
            if (chkQueen2(row)) continue;
            nQueen2(row + 1);
        }
    }

    static boolean chkQueen2(int row) {
        for (int i = 0; i < row; i++) { // 이건 컬럼이 아니라 로우다.
            // 같은컬럼이거나 뎊스만큼 컬럼도 차이날 때
            if(queen2[row] == queen2[i] || row - i == Math.abs(queen2[row] - queen2[i])) return true;
        }
        return false;
    }
}

class NQueens {
    static int N;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        count = 0;
        positionQueen(0, 0, 0, 0);
        System.out.printf("%d", count);
    }

    /**
     * 단계별로 안되는 애들을 누적시켜나가네
     * boardRow 는 수직. 자리 잡은애 컬럼 누적
     *  : 첫재쭐에서 체크되면 일단 걔에가 다음줄에 걸린애 또 or 연산자로 추가하고, 걔를 또 넘겨서 그 다음 row 에서도 추가하고 쭉쭉쭉
     * powL 은 우하단 누적
     *  : 첫재쭐 애의 우하단 안되니까 체크하고, 다음줄 가면 퀸이 놓여진 컬럼의 우하단이랑 전 줄에서 체크했던 비트의 우하단 역시 당연히 안되니까 체크
     *    그 다음줄에선 위의 2개에서 체크됐던 애들의 우하단이랑 현재 줄에서 퀸 놓여진거의 우하단 해서 체크. 이걸 쭉쭉
     * powR 은 좌하단 방향 누적
     *  : 첫재쭐 애의 좌하단 안되니까 체크하고, 다음줄 가면 퀸이 놓여진 컬럼의 좌하단이랑 전 줄에서 체크했던 비트의 좌하단 역시 당연히 안되니까 체크
     *    그 다음줄에선 위의 2개에서 체크됐던 애들의 좌하단이랑 현재 줄에서 퀸 놓여진거의 좌하단 해서 체크. 이걸 쭉쭉
     */
    static void positionQueen(int row, int boardRow, int powL, int powR) {
        // BASE
        if (row == N) {
            // boardRow가 111..11 로만 돼있다면 ok! count++
            if (boardRow == (1 << N) - 1) {
                count++;
            }
            return;
        }

        // RECURSIVE
        for (int col = 0; col < N; col++) {
            int cannotPosition = boardRow | powL | powR;
            if (((1 << col) & cannotPosition) != 0) {
                continue;
            }
// (boardRow에 퀸을 놓고 / 다음 row로 / 놓으면 안되는 영역을 왼아래로 / 놓으면 안되는 영역을 오른아래로)
            positionQueen(row + 1, boardRow | (1 << col), (powL | (1 << col)) << 1, (powR | (1 << col)) >>> 1);

        }
    }
}

class NQueens2 {
    static int n;
    static int cnt = 0;
    static boolean[] chkUp; // 수직 체크
    static boolean[] ckRightUp; // 우상단 체크
    static boolean[] chkLeftUp; // 좌상단 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        chkUp = new boolean[n];
        // n개의 열이 있을 때, 좌상단이던 우상단이던 쭉쭉 밀려서 최대한 도달할 수 있는 곳은 2*n -1 번째
        ckRightUp = new boolean[2 * n - 1];
        chkLeftUp = new boolean[2 * n - 1];

        nQueen(0);
        System.out.println(cnt);
    }

    private static void nQueen(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 알았다.
            // i + row 이나 i + N - 1 - row 이나
            // 시작점 자체를 옮기는 용도네.
            // 예를들어 isUsed2[i + row] 는 N 이 4 일때,
            // 0~3 만 체크함.
            // |FFFF|FFFF
            // 만약에 첫번째 줄에서 1번지에 queen 을 놨다?
            // 일단 |FTFF|FFF 가 되겠지. 근데 이제 후에 row 를 +1 해서 재귀로 넘어갔을 때,
            // 기본 체크가 1부터 시작이기 때문에
            // F|TFFF|FF
            // 이런 모양새가 된다.
            // 0번지에는 우상단 대각선에 퀸이 있어서 놓으실 수 없어요! 라는 뜻이된다. 예를들어 이번 행에서 퀸을 놓지 않고 또 넘어갈 경우
            // FT|FFFF|F
            // 가 되어 이번 행의 모든 자리의 우상단에 퀸은 없습니다 가 되어 돌을 전부 놓을 수 있다.
            // 비트로 하는거마냥 한칸씩 밀어버리는 방식이랑 같다고 보면 된다.

            if (chkUp[i] || ckRightUp[i + row] || chkLeftUp[i + n - 1 - row]) continue;

            chkUp[i] = true;
            ckRightUp[i + row] = true;
            chkLeftUp[i + n - 1 - row] = true;

            nQueen(row + 1);

            chkUp[i] = false;
            ckRightUp[i + row] = false;
            chkLeftUp[i + n - 1 - row] = false;
        }
    }
}