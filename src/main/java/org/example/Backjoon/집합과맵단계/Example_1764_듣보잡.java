package org.example.Backjoon.집합과맵단계;

import java.io.*;
import java.util.*;

/**
 * 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
 *
 * -- 입력 --
 * 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
 * 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
 * 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
 * 듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
 *
 * -- 출력 --
 * 듣보잡의 수와 그 명단을 사전순으로 출력한다.
 *
 *
 */
public class Example_1764_듣보잡 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
//        mine1();
        mine2();
        bw.flush();
    }

    private static void mine1() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> name = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            name.add(br.readLine());
        }

        name.sort((s1, s2) -> s1.compareTo(s2));

        List<String> newName = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(Collections.binarySearch(name, str) > -1) newName.add(str);
        }
        newName.sort((s1, s2) -> s1.compareTo(s2));
        bw.write(newName.size() + "\n");
        for (int i = 0; i < newName.size(); i++) {
            bw.write(newName.get(i));
            bw.newLine();
        }
    }

    private static void mine2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> name = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            name.add(br.readLine());
        }

        List<String> newName = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(name.contains(str)) newName.add(str);
        }
        newName.sort((s1, s2) -> s1.compareTo(s2));
        bw.write(newName.size() + "\n");
        for (int i = 0; i < newName.size(); i++) {
            bw.write(newName.get(i));
            bw.newLine();
        }
    }
}
