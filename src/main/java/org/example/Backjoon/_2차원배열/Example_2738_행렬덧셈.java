package org.example.Backjoon._2차원배열;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.StreamSupport;

/**
 * N * M 크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
 *
 * - 입력 -
 * 첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
 * 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
 * - 출력 -
 * 첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
 */
public class Example_2738_행렬덧셈 {
    public static void main(String[] args) throws IOException{
//        others();
        mine();
    }

    static void mine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[][] a = new String[n][m];
        String[][] b = new String[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                a[i][j] = st.nextToken();
            }
        }

//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            for (int j = 0; j < m; j++) {
//                b[i][j] = st.nextToken();
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                bw.write((Integer.parseInt(a[i][j]) + Integer.parseInt(b[i][j])) + "");
//                if(j < m - 1) bw.write(" ");
//                else bw.newLine();
//            }
//        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                bw.write((Integer.parseInt(a[i][j]) + Integer.parseInt(st.nextToken())) + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }

    static void others() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                bw.write(String.valueOf(a[i][j] + Integer.parseInt(st.nextToken())));
                if(j < m - 1) bw.write(" ");
                else bw.newLine();
            }
        }

        bw.close();
        br.close();
    }
}
