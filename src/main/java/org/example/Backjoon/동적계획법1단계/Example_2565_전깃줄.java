package org.example.Backjoon.동적계획법1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다.
 * 합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.
 *
 * 예를 들어, < 그림 1 >과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄,
 * A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.
 *
 * 전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때,
 * 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100 이하의 자연수이다.
 * 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다.
 * 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.
 *
 * 첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
 *
 * 위 설명 에시)
 * 입력
 * 8
 * 1 8
 * 3 9
 * 2 2
 * 4 1
 * 6 4
 * 10 10
 * 9 7
 * 7 6
 *
 * 출력
 * 3
 *
 * -풀이-
 * 일단 들어온거 A 기준 오름차순정렬한다.
 * 그 다음에 B를 가장 긴 증가하는 부분수열 을 구한다.
 * 나머지가 지우는 값이다.
 * 왜 증가하는 부분수열이면 되냐?
 * A를 일단 오름차순 정렬했으니까 A에서 숫자 커질때 연결된 B도 커지면 전깃줄이 만나지 않기 때문이다.
 */
public class Example_2565_전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = -1;
        dp[0][1] = -1;

        Arrays.sort(dp, (a1,a2) -> a1[0] - a2[0]);

        for (int i = 1; i <= n; i++) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if(dp[i][1] > dp[i2][1])
                {
                    dp[i][2] = Math.max(dp[i][2], dp[i2][2] + 1);
                }
            }
        }
        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[i][2], max);
        }

        System.out.print(n - max);
    }
}

