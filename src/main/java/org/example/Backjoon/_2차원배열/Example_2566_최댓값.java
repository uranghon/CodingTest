package org.example.Backjoon._2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 9x9 크기의 int 형 2차원 배열이 주어지고, 각 요소에 0~99 사이의 랜덤한 정수값이 들어있을 때,
 * 가장 큰 값과 해당 값의 위치를 출력하시오
 */
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
                    if(maxNum == 99)
                    {
                        blMax = true;
                        break;
                    }
                }
            }

            if (blMax) break;
        }

        System.out.print(maxNum + "\n" + maxi + " " + maxj);
    }
}
