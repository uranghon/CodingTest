package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
