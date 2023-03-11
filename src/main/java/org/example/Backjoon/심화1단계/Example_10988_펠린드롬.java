package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example_10988_펠린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder(str.substring(str.length() - (str.length() / 2)));

        if(sb.reverse().toString().equals(str.substring(0, str.length() / 2))) System.out.println(1);
        else System.out.println(0);

//        int isP = 1;
//        for (int i = 0; i < str.length() / 2; i++) {
//            if(str.charAt(i) != str.charAt(str.length() - i - 1))
//            {
//                isP = 0;
//                break;
//            }
//        }
//        System.out.print(isP);
    }
}
