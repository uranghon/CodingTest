package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

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
    // 1번 RT, TR
    // 2번 CF, FC
    // 3번 JM, MJ
    // 4번 AN, NA
    // 3,2,1,0,1,2,3 : 점수
    // 1,2,3,4,5,6,7 : 선택지
    // survey.  index : 몇번질문, survey[index] : 질문이 어떤 지표를 어떤 방식으로 채점하는애인지. ex) RT는 비동의쪽이 R, 동의쪽이 T
    // choices. index : 몇번질문, choices[index] : 뭐골랐는지

}

