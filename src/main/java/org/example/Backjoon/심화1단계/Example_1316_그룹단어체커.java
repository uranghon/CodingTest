package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 *
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 *
 * -풀이-
 * 1. map 사용하기
 * 2. 알파벳 26개 크기의 boolean형 배열 만들어서 확인하기. 알파벳이 바뀌는데 예전에 나왔던 애면 펑
 */
public class Example_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        mine();
        others();
    }

    static void mine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        Map<Character, Boolean> map = new HashMap<>();
        boolean chk;

        for (int i = 0; i < n; i++) {
            chk = true;
            map.clear();

            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < cArr.length; j++) {
                if (cArr[j] == cArr[j == 0 ? j : j - 1] || !map.getOrDefault(cArr[j], false)) {
                    map.put(cArr[j], true);
                } else {
                    chk = false;
                    break;
                }
            }
            if (chk) cnt++;
        }

        System.out.print(cnt);
        br.close();
    }

    /*
    여기는 알파벳개수만큼의 boolean 배열을 만들어놓고 체크.
    내꺼는 나오는 알파벳을 map에 넣으면서 체크
    */
    static void others() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean[] chk = new boolean[26];
            char before = str.charAt(0);
            chk[before - 'a'] = true;

            int j = 1;
            for (; j < str.length(); j++) {
                char c = str.charAt(j);
                if (chk[c - 'a'] && before != c) {
                    break;
                }
                chk[c - 'a'] = true;
                before = c;
            }
            if (j == str.length()) {
                result++;
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}
