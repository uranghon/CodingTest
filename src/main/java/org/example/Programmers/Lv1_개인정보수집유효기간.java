package org.example.Programmers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Lv1_개인정보수집유효기간 {
    public static void main(String[] args) {
        내꺼1();
        내꺼2(); // 이놈이 핵심
        남꺼1();
    }

    static void 내꺼1() {
        String today = "2020.11.28";
        String today2 = today.replace(".", "");
        String[] terms = {"A 12"};
        String[] privacies = {"2019.12.01 A"};

        List<Integer> delList = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();

        for (String term : terms) {
            termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] dayAndPrivacy = privacies[i].split(" ");
            String[] day = dayAndPrivacy[0].split("\\.");

            day[0] = String.format("%04d" , Integer.parseInt(day[0]) + ((Integer.parseInt(day[1]) - 1 + termsMap.get(dayAndPrivacy[1])) / 12));
            day[1] = String.format("%02d" ,(Integer.parseInt(day[1]) - 1 + termsMap.get(dayAndPrivacy[1])) % 12 + 1);
            if((day[0] + day[1] + day[2]).compareTo(today2) <= 0)
                delList.add(i + 1);
        }

        System.out.println("delList = " + Arrays.toString(delList.toArray(Integer[]::new)));
    }

    static void 내꺼2() {
        String today = "2022.05.19";
//        String today2 = today.replace(".", "");
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        String[] yyyyMMdd = today.split("\\.");
        LocalDate ldToday = LocalDate.of( Integer.parseInt(yyyyMMdd[0]), Integer.parseInt(yyyyMMdd[1]), Integer.parseInt(yyyyMMdd[2]));

        List<Integer> delList = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();

        for (String term : terms) {
            termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] dayAndPrivacy = privacies[i].split(" ");
            String[] day = dayAndPrivacy[0].split("\\.");

            LocalDate ld = LocalDate.of( Integer.parseInt(day[0]), Integer.parseInt(day[1]), Integer.parseInt(day[2]));

            // 28일까지만 있게 지정해놓은 이유가 날짜관련 함수 사용하라는 의미네
            if(ld.plusMonths(termsMap.get(dayAndPrivacy[1])).compareTo(ldToday) <= 0)
                delList.add(i + 1);
        }

        System.out.println("delList = " + Arrays.toString(delList.toArray(Integer[]::new)));
    }

    static void 남꺼1() {
        String today = "2020.11.28";
        String today2 = today.replace(".", "");
        String[] terms = {"A 12"};
        String[] privacies = {"2019.12.01 A"};

        List<Integer> delList = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();

        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termsMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            // 월의 일자 수가 모두 28일이기에 가능.
            if (getDate(privacy[0]) + (termsMap.get(privacy[1]) * 28) <= date) {
                delList.add(i + 1);
            }
        }

        System.out.println("delList = " + Arrays.toString(delList.toArray(Integer[]::new)));
    }

    private static int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
        // yyyyMMdd 형식은 포기.
        // 년,월,일을 각각 int형으로 바꿈
        // year 는 12개월 * 28일 을 곱해서 총 몇일짜리인지
        // month 도 28일 곱해서 총 몇일인지
        // day 는 그대로
        // 얘가
    }
}
