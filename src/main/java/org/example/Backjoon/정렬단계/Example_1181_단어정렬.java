package org.example.Backjoon.정렬단계;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
