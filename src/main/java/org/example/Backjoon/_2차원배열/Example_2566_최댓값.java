package org.example.Backjoon._2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_2566_최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean blMax = false;
        int maxNum = -1;
        int maxi = 0;
        int maxj = 0;

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= 9; j++)
            {
                int num = Integer.parseInt(st.nextToken());

                if (num > maxNum) {
                    maxNum = num;
                    maxi = i;
                    maxj = j;
                    if(maxNum == 100)
                    {
                        blMax = true;
                        break;
                    }
                }
            }

            if (blMax) break;
        }

        System.out.print(maxNum + "\n" + maxi + " " + maxj);

        br.close();
    }
}
