package org.example.Backjoon.동적계획법1단계;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 재귀 호출만 생각하면 신이 난다! 아닌가요?
 * 다음과 같은 재귀함수 w(a, b, c)가 있다.
 *
 * if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
 *     1
 *
 * if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
 *     w(20, 20, 20)
 *
 * if a < b and b < c, then w(a, b, c) returns:
 *     w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
 *
 * otherwise it returns:
 *     w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
 *
 * 위의 함수를 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. (예를 들면, a=15, b=15, c=15)
 * a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.
 *
 * 입력은 세 정수 a, b, c로 이루어져 있으며, 한 줄에 하나씩 주어진다. 입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다.
 *
 * 입력으로 주어진 각각의 a, b, c에 대해서, w(a, b, c)를 출력한다. (-50 ≤ a, b, c ≤ 50)
 *
 * 예시
 * 입력 : 1 1 1
 * 출력 : w(1, 1, 1) = 2
 *
 * -풀이-
 * 띡 보아하니 20 넘어가는건 컷이네? 0보다 작은것도 컷이고?
 * 그러면 0~20 까지 공간을 가진 3차원 배열로 처리 가능하다.
 *
 */
public class Example_9184_신나는함수실행 {
    static int[][][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[21][21][21];
        w2();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            bw.write("w(" + a + ", "+ b + ", " + c + ") = ");

            if (a <= 0 || b <= 0 || c <= 0)
            {
                bw.write("1\n");
            }
            else if (a > 20 || b > 20 || c > 20) {
                bw.write(arr[20][20][20] + "\n");
            }
            else
            {
                bw.write(arr[a][b][c] + "\n");
            }
        }
        bw.flush();
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
        {
            return 1;
        }
        else if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        else if (a < b && b < c) {
            return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        else
        {
            return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    }

    static void w2() {
        for (int ai = 0; ai <= 20; ai++) {
            for (int bi = 0; bi <= 20; bi++) {
                for (int ci = 0; ci <= 20; ci++) {
                    if (ai <= 0 || bi <= 0 || ci <= 0)
                    {
                        arr[ai][bi][ci] = 1;
                    }
                    else if (ai < bi && bi < ci) {
                        arr[ai][bi][ci] = arr[ai][bi][ci - 1] + arr[ai][bi - 1][ci - 1] - arr[ai][bi - 1][ci];
                    }
                    else
                    {
                        arr[ai][bi][ci] = arr[ai - 1][bi][ci] + arr[ai - 1][bi - 1][ci] + arr[ai - 1][bi][ci - 1] - arr[ai - 1][bi - 1][ci - 1];
                    }
                }
            }
        }
    }
}
