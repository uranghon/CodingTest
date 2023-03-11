package org.example.Backjoon._2차원배열;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.StreamSupport;

public class Example_2738_행렬덧셈 {
    public static void main(String[] args) throws IOException{
        others();
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

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                b[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write((Integer.parseInt(a[i][j]) + Integer.parseInt(b[i][j])) + "");
                if(j < m - 1) bw.write(" ");
                else bw.newLine();
            }
        }

        bw.close();
        br.close();
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
