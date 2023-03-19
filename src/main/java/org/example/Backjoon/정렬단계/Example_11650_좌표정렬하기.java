package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.*;
//import java.util.stream.Stream;

public class Example_11650_좌표정렬하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
//        mine1();
        mine2();
    }

    static void mine1() throws IOException {
        int n = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<Integer>> xyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::new).toArray();

            ArrayList<Integer> orDefault = xyMap.getOrDefault(arr[0], new ArrayList<>());
            orDefault.add(arr[1]);
            xyMap.put(arr[0], orDefault);
        }
        StringBuilder sb = new StringBuilder();

        xyMap.keySet().stream().sorted().forEach((k) -> {
                    ArrayList<Integer> integers = xyMap.get(k);
                    integers.sort((a, b) -> a - b);
                    integers.forEach(a -> sb.append(k + " " + a + "\n"));
                }
        );

        System.out.println(sb);
    }

    static void mine2() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] iArr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            iArr[i][0] = Integer.parseInt(s[0]);
            iArr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(iArr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int[] ints : iArr) {
            bw.write(ints[0] + " " + ints[1] + "\n");
        }

        bw.flush();
    }
}
