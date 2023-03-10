package org.example.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] blChk = new boolean[100][100];

        int black = 0;

        for (int i = 0; i < n; i++) {
            String[] sArr = br.readLine().split(" ");
            int x = Integer.parseInt(sArr[0]);
            int y = Integer.parseInt(sArr[1]);

            for (int j = x; j < x + 10; j++) {
                //if(j == 100) break; // 넘어가는 경우가 없다고 했었네
                for (int k = y; k < y + 10; k++) {
                    //if(k == 100) break; // 넘어가는 경우가 없다고 했었네
                    if(!blChk[j][k])
                    {
                        black++;
                        blChk[j][k] = true;
                    }
                }
            }
        }

        System.out.print(black);

        br.close();
    }
}
