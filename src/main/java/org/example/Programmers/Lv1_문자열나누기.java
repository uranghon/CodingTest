package org.example.Programmers;

import java.util.ArrayList;
import java.util.List;

public class Lv1_문자열나누기 {

    static String s = "abracadabra";
    public static void main(String[] args) {
        mine1();
        mine2();
        others();
    }

    static void mine1() {
        List<String> list = new ArrayList<>();

        char firstC = s.charAt(0);
        int splitIndex = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < s.length(); i++) {
            //0 , 1 / 2에 짜름, 3 / 4에 짜름 , 5
            // ba / na /
            if(a == b && a > 0)
            {
                list.add(s.substring(splitIndex, i));
                splitIndex = i;
                firstC = s.charAt(i);
                a = 0;
                b = 0;
            }

            if(firstC == s.charAt(i)) a++;
            else b++;
        }
        list.add(s.substring(splitIndex, s.length()));

        System.out.println(list.size());
    }

    static void mine2() {
        int answer = 0;

        char firstC = s.charAt(0);
        int a = 0;
        int b = 0;

        for (int i = 0; i < s.length(); i++) {
            if(a == b && a > 0)
            {
                answer++;
                firstC = s.charAt(i);
                a = 0;
                b = 0;
            }

            if(firstC == s.charAt(i)) a++;
            else b++;
        }
        answer++;
        System.out.println(answer);
    }

    static void others() {
        int answer = 0;

        char prev = '1';
        int same = 0, different = 0;
        for (char c : s.toCharArray()) {
            if (prev == '1') {
                prev = c;
                same++;
                answer++;
            } else if (prev == c) {
                same++;
            } else {
                different++;
            }

            if (same == different) {
                prev = '1';
                same = 0;
                different = 0;
            }
        }
        System.out.println(answer);
    }
}
