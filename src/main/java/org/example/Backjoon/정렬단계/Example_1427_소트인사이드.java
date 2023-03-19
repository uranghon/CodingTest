package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example_1427_소트인사이드 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
//        mine1();
//        mine2();
    }
    private static void mine1() throws IOException {
        int[] cntArr = new int[10];

        int n = 0;
        while ((n = br.read() - '0') > -1)
        {
            cntArr[n]++;
        }

        for (int i = cntArr.length - 1; i >= 0; i--) {
            int j = cntArr[i];
            while (j-- > 0)
            {
                bw.write(i + "");
            }
        }

        bw.flush();
    }

    private static void mine2() throws IOException {
        // 기본 정렬은 오름차순이다. 즉 좌우 값을 비교했을 때, 왼쪽이 작다는 뜻이고, 비교값이 음수라는 뜻이다.
        // -> 정렬기준에 넣는 람다식은 람다식 출력값이 음수가 되도록 정렬하라는 뜻이다.

        String str = br.readLine();
        Arrays.stream(str.split("")).sorted(Comparator.reverseOrder()).forEach(System.out::print);
//        str.chars().mapToObj(i -> new Character((char)i)).sorted((c1, c2) -> c2.compareTo(c1)).forEach(System.out::print);
//        Stream.of(str.split("")).sorted((s1, s2) -> s2.compareTo(s1)).forEach(System.out::print);

//        StringBuilder sb = new StringBuilder();
//        Stream.of(str.split("")).sorted((s1, s2) -> s2.compareTo(s1)).forEach(sb::append);
//        System.out.print(sb);
    }
}

