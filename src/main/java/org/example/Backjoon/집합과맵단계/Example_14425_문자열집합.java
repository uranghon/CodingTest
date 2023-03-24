package org.example.Backjoon.집합과맵단계;

import java.io.*;
import java.util.*;

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
