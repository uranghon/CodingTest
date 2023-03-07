package org.example.Programmers;

import java.util.HashMap;
import java.util.Map;

public class Lv1_성격유형검사하기 {

    static String[] survey = {"TR", "RT", "TR"};
    static int[] choices = {7, 1, 3};
    public static void main(String[] args) {
        mine();
        others();
    }

    static void mine() {
        StringBuilder answer = new StringBuilder();

        int[] point = {0, 3, 2, 1, 0, 1, 2, 3};

        Map<String, Integer> sum = new HashMap<>();
        sum.put("R", 0);
        sum.put("T", 0);
        sum.put("C", 0);
        sum.put("F", 0);
        sum.put("J", 0);
        sum.put("M", 0);
        sum.put("A", 0);
        sum.put("N", 0);

        for (int i = 0; i < choices.length; i++) {
            String[] str = survey[i].split("");
            if (choices[i] < 4) {
                sum.put(str[0], sum.get(str[0]) + point[choices[i]]);
            } else {
                sum.put(str[1], sum.get(str[1]) + point[choices[i]]);
            }
        }

        if (sum.get("R") >= sum.get("T")) answer.append("R");
        else answer.append("T");

        if (sum.get("C") >= sum.get("F")) answer.append("C");
        else answer.append("F");

        if (sum.get("J") >= sum.get("M")) answer.append("J");
        else answer.append("M");

        if (sum.get("A") >= sum.get("N")) answer.append("A");
        else answer.append("N");

        System.out.println(answer);
    }

    static void others() {
        String answer = "";
        char [][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int [] score = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> point = new HashMap<Character, Integer>();

        // 점수 기록할 배열 초기화
        for (char[] t : type) {
            point.put(t[0], 0);
            point.put(t[1], 0);
        }

        // 점수 기록
        for (int idx = 0; idx < choices.length; idx++){
            if(choices[idx] > 4){
                point.put(survey[idx].charAt(1), point.get(survey[idx].charAt(1)) + score[choices[idx]]);
            } else {
                point.put(survey[idx].charAt(0), point.get(survey[idx].charAt(0)) + score[choices[idx]]);
            }
        }

        // 지표 별 점수 비교 후 유형 기입
        for (char[] t : type) {
            answer += (point.get(t[1]) <= point.get(t[0])) ? t[0] : t[1];
        }

        System.out.println(answer);
    }
}
