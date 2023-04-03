package org.example.Backjoon.재귀단계;

import java.io.*;

/**
 * 정휘는 후배들이 재귀 함수를 잘 다루는 재귀의 귀재인지 알아보기 위해 재귀 함수와 관련된 문제를 출제하기로 했다.
 * 팰린드롬이란, 앞에서부터 읽었을 때와 뒤에서부터 읽었을 때가 같은 문자열을 말한다.
 * 팰린드롬의 예시로 AAA, ABBA, ABABA 등이 있고, 팰린드롬이 아닌 문자열의 예시로 ABCA, PALINDROME 등이 있다.
 *
 * 펜린드롬 문자열이면 1을 반환하고, 아니면 0을 반환한다.
 * isPalindrome 결과값이랑 recursion 호출 횟수를 출력하자.
 */
public class Example_25501_재귀의귀재 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char[] cArr = br.readLine().toCharArray();
            int[] iArr = new int[2];
            isPalindrome(cArr, 0, cArr.length - 1, iArr);
            bw.write(iArr[0] + " " + iArr[1]);
            bw.newLine();
        }
        bw.flush();
    }

    static int recursion(char[] s, int l, int r) {
        if (l >= r) return 1;
        else if (s[l] != s[r]) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    static int isPalindrome(char[] s) {
        return recursion(s, 0, s.length - 1);
    }

    static void isPalindrome(char[] cArr, int l, int r, int[] iArr) {
        iArr[1]++;
        if (l >= r) iArr[0] = 1;
        else if (cArr[l] != cArr[r]) iArr[0] = 0;
        else isPalindrome(cArr, l + 1, r - 1, iArr);
    }
}
