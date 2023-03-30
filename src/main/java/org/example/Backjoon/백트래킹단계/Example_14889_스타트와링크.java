package org.example.Backjoon.백트래킹단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example_14889_스타트와링크 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] arr;
    static int startCnt = 1;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int iStart = 1;
        int iLink = 0;
        int[] arrStart = new int[n / 2];
        int[] arrLink = new int[n / 2];
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (i < j) arr[i][j] += num;
                else arr[j][i] += num;
            }
        }

//        dfs(iStart, iLink, 1);
        visit[0] = true;
        dfs(arrStart, arrLink, visit, 1, 1);
        System.out.print(min);
    }

    static void dfs(int start, int link, int col) {
        if (startCnt < n / 2) {
            for (int i = col; i < n; i++) {
                if ((start & 1 << i) == 0) {
                    start |= 1 << i;
                    startCnt++;
                    dfs(start, link, i + 1);
                    startCnt--;
                    start ^= 1 << i;
                }
            }
        } else {
            for (int i = 1; i < n; i++) {
                if ((start & 1 << i) == 0) link |= 1 << i;
            }
            int diff = Math.abs(sumStat(start) - sumStat(link));
            min = Math.min(min, diff);
        }
    }

    static int sumStat(int team) {
        int row = 0;
        int col = 0;
        int stat = 0;

        for (int i = 0; i < n; i++) {
            if ((team & 1 << i) > 0) {
                row = i;
                for (int j = i + 1; j < n; j++) {
                    if ((team & 1 << j) > 0) {
                        col = j;
                        stat += arr[row][col];
                    }
                }
            }
        }

        return stat;
    }

    static void dfs(int[] start, int[] link, boolean[] visit, int col, int idx) {
        if (idx < n / 2) {
            for (int i = col; i < n; i++) {
                start[idx++] = i;
                visit[i] = true;
                dfs(start, link, visit, i + 1, idx);
                if(min == 0) return;
                start[--idx] = 0;
                visit[i] = false;
            }
        } else {
            int linkIdx = 0;
            for (int i = 1; i < n; i++) {
                if (!visit[i]) link[linkIdx++] = i;
            }
            min = Math.min(min, diffStat(start, link));
        }
    }

    static int diffStat(int[] start, int[] link) {
        int startStat = 0;
        int linkStat = 0;

        for (int i = 0; i < n / 2 - 1; i++) {
            for (int j = i + 1; j < n / 2; j++) {
                startStat += arr[start[i]][start[j]];
                linkStat += arr[link[i]][link[j]];
            }
        }

        return Math.abs(startStat - linkStat);
    }
}

class Others1 {
    private static int N;
    private static int[] sumRow, sumColumn;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        sumRow = new int[N];
        sumColumn = new int[N];

        int sumTotal = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                sumTotal += num;
                sumRow[i] += num;
                sumColumn[j] += num;
            }
        }

        comb(0, 0, sumTotal);

        System.out.println(result);
        br.close();
    }

    /**
     * row, col 쭉쭉 선을 긋다보면 교차되는 부분이 발생한다.
     * 이 교차되는 부분이 해당 idx 팀의 능력치가 된다.
     * 얘네만큼 한번 더 빼는거다.
     *
     * 결국에 남는건 선택된 idx 들의 교차지점의 합을 뺀 값과
     * 안선택된 idx 들의 교차지점 값의 합이다.
     *
     * ex) n = 4 일 때,
     * idx 1 과 4 를 그으면
     * 12 13 14
     * 21 31 41
     * 41 42 43
     * 14 24 34
     * 지점이 빠지는데, 이를 묶으면
     * 12 21
     * 13 31
     * 14 41 14 41
     * 24 42
     * 34 43
     * 이 되고,
     * 남는 부분은
     * 23 32
     * 이다.
     * 전체에서 위를 남는 부분 뺴고 다 빼면
     * (23 32) - (14 41) 이 되고, 이게 1,4번 인원과 2,3번 인원의 능력치 합의 차와 같다.
     */
    private static void comb(int index, int cnt, int sumTotal) {
        if (cnt == (N / 2)) {
            result = Math.min(result, Math.abs(sumTotal));
            return;
        } else if (index == N) {
            return;
        }
        comb(index + 1, cnt + 1, sumTotal - sumRow[index] - sumColumn[index]);
        comb(index + 1, cnt, sumTotal);
    }
}