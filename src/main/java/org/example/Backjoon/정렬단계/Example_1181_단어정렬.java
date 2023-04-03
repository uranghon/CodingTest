package org.example.Backjoon.정렬단계;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 *
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 *
 * -풀이-
 * 1. 단어 받는 클래스를 comparable 을 구현하는 클래스로 만든다음에 비교문을 오버라이딩 한다.
 * 2. 정렬문에다가 알아서 잘 맞게 정렬조건 적는다.
 */
public class Example_1181_단어정렬 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

    }

    static void mine1() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] sArr = new String[n];

        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        Arrays.stream(sArr)
                .distinct()
                .sorted((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length())
                .forEach(s -> sb.append(s+"\n"));

        System.out.println(sb);
    }

    static void mine2() throws IOException {
        int n = Integer.parseInt(br.readLine());

        Set<String> wordSet = new HashSet<>();
        while (n-- > 0) {
            wordSet.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        wordSet.stream()
                .sorted((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length())
                .forEach(s -> sb.append(s+"\n"));

        System.out.println(sb);
    }
}
