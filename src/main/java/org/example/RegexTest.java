package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // 전방탐색 (?=문자(열)) 뒤에 문자(열) 이 있는 위치(문자와 문자 사이. 커서라고 봐도 됨)
        // 후방탐색 (?<=문자(열)) 앞에 문자(열) 이 있는 위치(문자와 문자 사이. 커서라고 봐도 됨)
        // 전방부정 (?!문자(열)) 뒤에 문자(열) 이 없는 위치(문자와 문자 사이. 커서라고 봐도 됨)
        // s앞, e앞, o앞, k앞, a앞, e앞, j앞, i앞, n앞, n뒤
        // 후방부정 (?<!문자(열)) 앞에 문자(열) 이 없는 위치(문자와 문자 사이. 커서라고 봐도 됨)
        // s앞, s뒤, e뒤, o뒤, k뒤, D뒤, a뒤, j뒤, i뒤, n뒤

        Pattern pattern = Pattern.compile(".?(?<!Dae)$");
        Matcher matcher = pattern.matcher("seokDaejin");
        boolean found = false;
//        System.out.println(matcher.group());
//        System.out.println(matcher.find() + matcher.group());
//        System.out.println(matcher.find() + matcher.group());

//        for(int i = 0; i<= 10; i ++)
//            System.out.println(i + " : " + matcher.find(i));
        while (matcher.find()) {
            sb.append(matcher.group())
              .append(" 위치s : " + matcher.start())
              .append(" ~ " + matcher.end() + "\n");
            found = true;
        }
        if (!found) {
            sb.append("찾지 못했습니다.");
        }
        System.out.println(sb.toString());

//        String regex = "(?!\\d)\\D?";
//        String input = "AB1B2C3";
//        Pattern pattern2 = Pattern.compile(regex);
//        Matcher matcher2 = pattern2.matcher(input);
//
//        while (matcher2.find()) {
//            System.out.println(matcher2.group());
//        }

        System.out.println("끝");
    }
}
