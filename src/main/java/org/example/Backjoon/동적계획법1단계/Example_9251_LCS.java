package org.example.Backjoon.동적계획법1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
 * 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
 *
 * 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
 *
 * 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
 *
 * -풀이-
 * lcs 풀이 알고리즘 따라서 했음.
 * 예를들어 abcd 와 bacd 가 있을 때, 최장은 acd or bcd 로 3 이다.
 * abcd 라는 완성문자열이랑 랑 bacd 를 비교할 때를 보자.
 * 비교할때는 한쪽의 끝과 다른쪽의 시작부터 비교한다고 생각하자.
 *
 * abcd 의 d 와 bacd 의 b 를 봤을 때 서로 다르다.
 * 그렇다면 이건 abc 와 b 를 비교한것과 같다고 생각하면 된다.
 *
 * 다음 abcd 와 d 와 bacd 의 a 를 비교해보자. 역시 서로 다르다.
 * 이 때, abc 와 ba 를 비교한것 or abcd 와 b 를 비교한것중에 큰쪽이랑 같다고 생각하면 된다.
 * 왜냐? d 랑 a 랑 다르니까 abc 와 ba 를 비교한것에 abc 에 d 를 더한거는 abcd 와 b 를 비교한 것과 같고
 * 혹은 abcd 와 b 를 비교한것에 b에 a 를 더한건 abc와 ba를 비교한것과 같다.
 * 둘 중 더 큰놈을 가져가면 되는거다.
 *
 * 쭉쭉 가서 abcd 의 d 와 bacd 의 d 를 비교해보자. 서로 같다.
 * 이말은 abc 와 bac 를 비교한것 + 1 한것과 같다는 뜻이다.
 */
public class Example_9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int r = 1; r <= arr1.length; r++) {
            for (int c = 1; c <= arr2.length; c++) {
                if (arr1[r - 1] == arr2[c - 1]) {
                    dp[r][c] = dp[r-1][c-1] + 1;
                }
                else {
                    dp[r][c] = Math.max(dp[r][c-1], dp[r-1][c]);
                }
            }
        }

        System.out.print(dp[arr1.length][arr2.length]);
    }
}
