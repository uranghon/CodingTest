package org.example.Backjoon._2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
 * 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
 * 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
 *
 * - 풀이 -
 * 면적을 계산하는게 아니라 점의 갯수를 구하는 방식으로 한다.
 * 길이가 10인건 점은 11개 인데, 맨 마지막 점은 제외하고 10개 점만 따진다.
 * 가로는 오른쪽, 세로는 위쪽 점을 제외한다.
 * 그러면 10 X 10 자리 색종이는 100개의 점을 가진다.
 */
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
