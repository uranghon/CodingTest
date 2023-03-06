package org.example.Programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lv0_옹알이1 {
    public static void main(String[] args) {
        mine();
        others1();
    }
    static void mine() {
        String[] babbling = {"yemaye", "uuuma", "ye", "yewmaoo", "ayaa", ""};
        String[] able = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String str1 : babbling) {
            for(String str2 : able)
            {
                str1 = str1.replaceFirst(str2, "#");
            }

            if(str1.replace("#", "").isEmpty())
            {
                answer++;
            }
        }
        System.out.println("mine answer = " + answer);
    }
    static void others1() {
        String[] babbling = {"yemaye", "uuuma", "yewoo", "yewmaoo", "ayaa", ""};
        int answer = 0;
//        Pattern pattern = Pattern.compile("^((aya|ye|woo|ma)?((aya|ye|woo|ma)?((aya|ye|woo|ma)?(aya|ye|woo|ma)?)))$");
//        Pattern p = Pattern.compile("^(?:((aya(?!.*aya))|(ye(?!.*ye))|(woo(?!.*woo))|(ma(?!.*ma)))?){0,4}$");
        Pattern p = Pattern.compile("^(aya(?!.*aya)|ye(?!.*ye)|woo(?!.*woo)|ma(?!.*ma))*$");
        for (String str : babbling) {
            Matcher m = p.matcher(str);
            if(m.matches())
            {
                answer++;
            }
        }

        System.out.println("others1 answer = " + answer);
    }
}
