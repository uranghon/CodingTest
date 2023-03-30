package org.example.Backjoon._2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다.
 * 주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다.
 * 각 줄의 시작과 마지막에 빈칸은 없다.
 *
 * 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다.
 */
public class Example_10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = 0;
        char[][] cArr = new char[5][15];
        for (int i = 0; i < 5; i++) {
            cArr[i] = br.readLine().toCharArray();
            maxLength = maxLength < cArr[i].length ? cArr[i].length : maxLength;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < maxLength; j++) {
            for (int i = 0; i < 5; i++) {
                if (j >= cArr[i].length) continue;

                sb.append(cArr[i][j]);
            }
        }

        System.out.print(sb);
    }
}
