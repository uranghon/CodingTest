package org.example.Backjoon.집합과맵단계;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져.
 * N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수인데, 자연수가 뭔지는 알지? 모르면 물어봐도 괜찮아.
 * 나는 언제든지 질문에 답해줄 준비가 되어있어.
 *
 * 둘째 줄부터 N개의 줄에 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력으로 들어와.
 * 포켓몬의 이름은 모두 영어로만 이루어져있고, 또, 음... 첫 글자만 대문자이고, 나머지 문자는 소문자로만 이루어져 있어.
 * 아참! 일부 포켓몬은 마지막 문자만 대문자일 수도 있어.
 * 포켓몬 이름의 최대 길이는 20, 최소 길이는 2야.
 * 그 다음 줄부터 총 M개의 줄에 내가 맞춰야하는 문제가 입력으로 들어와.
 * 문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고, 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력해야해.
 * 입력으로 들어오는 숫자는 반드시 1보다 크거나 같고, N보다 작거나 같고, 입력으로 들어오는 문자는 반드시 도감에 있는 포켓몬의 이름만 주어져.
 */
public class Example_1620_나는야포켓몬마스터이다솜 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] strNM = br.readLine().split(" ");
        int n = Integer.parseInt(strNM[0]);
        int m = Integer.parseInt(strNM[1]);

        mine1(n, m); // 수정본. map 1개, 배열 1개 사용. 빠름
//        mine2(n, m); // 원본. map 2개에 정규식 사용. 좀 더 느림
        bw.flush();
    }

    private static void mine1(int n, int m) throws IOException {
        HashMap<String, Integer> mapStr = new HashMap<>(n);
        String[] pArr = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            pArr[i] = name;
            mapStr.put(name, i);
        }

        while (m-- > 0) {
            String str = br.readLine();
            if (str.charAt(0) > '9') bw.write(mapStr.get(str) + "\n");
            else bw.write(pArr[Integer.parseInt(str)] + "\n");
        }
    }

    private static void mine2(int n, int m) throws IOException {
        HashMap<Integer, String> mapInt = new HashMap<>(n);
        HashMap<String, Integer> mapStr = new HashMap<>(n);
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            mapInt.put(i, name);
            mapStr.put(name, i);
        }

        Pattern p = Pattern.compile("[0-9]+");

        while (m-- > 0) {
            String str = br.readLine();
            Matcher matcher = p.matcher(str);
            if (matcher.matches()) {
                bw.write(mapInt.get(Integer.parseInt(str)) + "\n");
            }
            else
            {
                bw.write(mapStr.get(str) + "\n");
            }
        }
    }
}
