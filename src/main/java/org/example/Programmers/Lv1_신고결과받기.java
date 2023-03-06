package org.example.Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Lv1_신고결과받기 {
    public static void main(String[] args) {
        내꺼();
        내꺼2();
    }

    static void 내꺼() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

//        int[] answer = new int[id_list.length];
        int k = 2;

//        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());  // report 중복 제거
        List<String> reportList = new ArrayList<>(new HashSet<>(Arrays.asList(report)));  // report 중복 제거
//        Map<String, ArrayList<String>> reportByIdMap = new HashMap<>(); // id 와 해당id가 신고한 id 목록
        Map<String, Integer> reportedCountMap = new HashMap<>(); // id별 신고당한 횟수

        for (String s : reportList) {
            reportedCountMap.put(s.split( " ")[1], reportedCountMap.getOrDefault(s.split(" ")[1], 0) + 1);
        }

        int[] answer = Arrays.stream(id_list).map(id -> {

            return reportList.stream().filter(s -> s.split(" ")[0].equals(id)).collect(Collectors.toList()).stream()
                    .filter(s -> (reportedCountMap.getOrDefault(s.split(" ")[1], 0) >= k))
                    .count();

            /*int i = 0;
            for (String s : reportList.stream().filter(s -> s.split(" ")[0].equals(id)).collect(Collectors.toList())) {
                if (reportedCountMap.get(s.split(" ")[1]) >= k) i++;
            }
            return i;*/

        }).mapToInt(Long::intValue).toArray();


        System.out.println("answer = " + Arrays.toString(answer));
    }

    static void 내꺼2() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] answer = new int[id_list.length];

        List<String> reportList = new ArrayList<>(new HashSet<>(Arrays.asList(report)));  // report 중복 제거
        Map<String, ArrayList<String>> reportByIdMap = new HashMap<>(); // id 와 해당id가 신고한 id 목록
        Map<String, Integer> reportedCountMap = new HashMap<>(); // id별 신고당한 횟수

        for (String s : id_list) {
            reportByIdMap.put(s, new ArrayList<>()); // id별로 신고목록 초기화
            reportedCountMap.put(s, 0); // id별 신고당한 횟수 초기화
        }

        for (int i = 0; i < reportList.size(); i++) {
            String[] reportSplit = reportList.get(i).split(" "); // 신고를 신고id 와 피신고id 로 나눔.

            ArrayList<String> strings = reportByIdMap.get(reportSplit[0]); // 신고id 의 신고리스트 불러옴.
            strings.add(reportSplit[1]); // 기존 신고리스트에 지금 읽은 신고내용 추가.
            reportByIdMap.put(reportSplit[0], strings); // 추가한걸 다시 연결시켜줌.

            reportedCountMap.put(reportSplit[1], reportedCountMap.get(reportSplit[1]) + 1); // 지금 신고당한 id 의
        }

        for (int i =0; i < id_list.length ; i++)
        {
            ArrayList<String> strings = reportByIdMap.get(id_list[i]);
            if (!strings.isEmpty()) {
                for (String s : strings) {
                    if (reportedCountMap.get(s) >= k) {
                        answer[i]++;
                    }
                }
            }
        }

        System.out.println("answer = " + Arrays.toString(answer));
    }
}
