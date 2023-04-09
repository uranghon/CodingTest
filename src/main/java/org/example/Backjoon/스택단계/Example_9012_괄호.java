package org.example.Backjoon.스택단계;

import java.io.*;
import java.util.Stack;

/**
 * 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
 * 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
 * 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
 * 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
 * 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
 * 예를 들어 “(())()”와 “((()))” 는 VPS 이지만
 * “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
 *
 * 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
 */
public class Example_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
//            bw.write(notUseStack(br.readLine()));
            bw.write(useStack(br.readLine()));
            bw.newLine();
        }
        bw.flush();
    }

    static String notUseStack(String str) {
        int cnt1 = 0;
        int cnt2 = 0;
        boolean isVps = true;
        char[] vps = str.toCharArray();

        for (char c : vps) {
            if(c == '(') cnt1++;
            else if(c == ')') cnt2++;

            if(cnt2 > cnt1) break;
        }
        if(cnt1 != cnt2) isVps = false;

        if(isVps) return "YES";
        else return "NO";
    }

    static String useStack(String str) {
        char[] vps = str.toCharArray();
        Stack<Character> vpsStack = new Stack<>();

        for (char c : vps) {
            if(c == '(') vpsStack.push(c);
            else if(vpsStack.isEmpty()) return "NO";
            else vpsStack.pop();
        }

        if(vpsStack.isEmpty()) return "YES";
        else return "NO";
    }
}
