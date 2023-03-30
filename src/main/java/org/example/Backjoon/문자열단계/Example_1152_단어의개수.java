package org.example.Backjoon.문자열단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example_1152_단어의개수 {
    public static void main(String[] args) throws IOException {
        test();
    }
    static void test() throws IOException {
        //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] chars = br.readLine().trim().toCharArray();
//        int cnt = 0;
//        for(char c : chars)
//        {
//            if(c == 32) cnt++;
//        }
//
//        System.out.print(cnt > 0 ? cnt + 1 : cnt);
//
//        br.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(st.countTokens());
//        String[] strArr = br.readLine().trim().split(" ");
//        System.out.println(Arrays.toString(strArr));
//        if (strArr[0].isEmpty()) System.out.println(0);
//        else System.out.println(strArr.length);
    }
}
