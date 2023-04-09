package org.example.Backjoon.집합과맵단계;

import java.io.*;
import java.util.*;

/**
 * 총 N개의 문자열로 이루어진 집합 S가 주어진다.
 * 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
 *
 * -- 입력 --
 * 첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
 * 다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
 * 다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
 * 입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
 *
 * -- 출력 --
 * 첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.
 *
 * -풀이-
 * set이던 map이던 뭐던 해서 M개의 문자열을 contains 체크해서 있으면 +1 씩 해서 출력
 */
public class Example_14425_문자열집합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        mine2();
    }

    // n + m*n
    static void mine1() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Set<String> nSet = new HashSet<>(n);
        int m = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            nSet.add(br.readLine());
        }
        int cnt = 0;
        while (m-- > 0) {
            if(nSet.contains(br.readLine())) cnt++;
        }
        System.out.print(cnt);
    }

    // n + nlogn + mlogm
    static void mine2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<String> nlist = new ArrayList<>(n);
        while (n-- > 0) {
            nlist.add(br.readLine());
        }

        nlist.sort((s1, s2) -> s1.compareTo(s2));

        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (m-- > 0) {
            if(Collections.binarySearch(nlist, br.readLine()) > -1) cnt++;
//            if(chkContains(nlist, br.readLine(), 0, nlist.size() - 1)) cnt++;
        }
        System.out.print(cnt);
    }

    static boolean chkContains(List<String> nlist, String str, int fr, int to)
    {
        if(fr >= to) return nlist.get(fr).equals(str);

        int mid = (fr / 2) + (to / 2);
        int equalsNum = nlist.get(mid).compareTo(str);
        if(equalsNum == 0) return true;
        else if(equalsNum < 0) return chkContains(nlist, str, mid + 1, to);
        else return chkContains(nlist, str, fr, mid - 1);
    }
}
