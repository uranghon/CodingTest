package org.example.Programmers;

import java.util.*;

/**
 * 내꺼가 남꺼1 보다 시행시간 에서 훨씬 짧다. 나는 2n^2 이고, 남꺼1 dms n^3 이다.
 */
public class Lv1_대충만든자판 {
    public static void main(String[] args) {
        남꺼2();
    }

    static void 내꺼() {
        String[] keymap = {"ASDFESASQW", "BFDVSEGA", "SDFQBOKHIT"};
        String[] targets = {"PPAP", "P", "DIFOS"}; // 2+9+2+6+1
        int[] answer = new int[targets.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            char[] keyChars = keymap[i].toCharArray();
            for (int j = 0; j < keyChars.length; j++) {
                if (map.get(keyChars[j] + "") == null) {
                    map.put(keyChars[j] + "", j + 1);
                } else {
                    if (map.get(keyChars[j] + "") > j + 1) map.put(keyChars[j] + "", j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            char[] targetChars = targets[i].toCharArray();
            for (int j = 0; j < targetChars.length; j++) {
                if (map.get(targetChars[j] + "") != null) {
                    answer[i] += map.get(targetChars[j] + "");
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static void 남꺼1() {
        String[] keymap = {"ASDFESASQW", "BFDVSEGA", "SDFQBOKHIT"};
        String[] targets = {"PPAP", "P", "DIFOS"}; // 2+9+2+6+1
        int[] answer = new int[targets.length];

        Set<String> set = new HashSet<>(Arrays.asList(keymap));
        set.remove("");

        // ppap 를 keymap 이랑 비교
        // p 를 keymap 이랑 비교
        // difos 를 keymap 이랑 비교
        for (int i = 0; i < targets.length; i++) { // targets
            // ppap 를 한개씩 짤라서 keymap 에서 어디인가 가져오기.
            for (int l = 0; l < targets[i].length(); l++) { // char
                int k = 101;

                for (String j : set) { // set
                    int index = j.indexOf(targets[i].charAt(l));
// String 의 indexOf는 매개변수 문자가 검색스트링 안에서 가장 처음 매칭되는 위치를 반환한다. 없으면 -1 반환한다.
                    if (index == -1) continue; // keymap 하나씩이랑 비교해야하니까.
//                    if (index == -1) break;
                    else if (index < k) k = index;
                }


                if (k == 101) { // targets[i]의 l번째 글자를 를 keymap 이랑 비교했을 때, 매칭되는게 1개도 없으면 해당 targets[i] 의 결과는 -1 이 된다.
                    answer[i] = -1;
                    break;
                } else answer[i] += (k + 1);
            }
        }

        System.out.println("answer = " + Arrays.toString(answer));
    }

    static void 남꺼2() {
        String[] keymap = {"ASDFESASQW", "BFDVSEGA", "SDFQBOKHIT"};
        String[] targets = {"PPAP", "P", "DIFOS"};

        int[] minTouch = new int['Z' - 'A' + 1]; // A~Z 의 최소접근 위치를 나타내는 int 형 배열. int[0] 은 'A' , int[1] 은 'B' 꺼 어떻게 찾냐? char - 'A'
        Arrays.fill(minTouch, 200);
        // keymap 에서 하나씩 읽고, 그걸 또 한글자씩 읽어서 최소접근값 minTouch 에 넣는다. Map을 배열로 구현한거나 마찬가지
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                minTouch[key.charAt(i) - 'A'] = Math.min(minTouch[key.charAt(i) - 'A'], i + 1);
            }
        }
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            boolean canMake = true;
            for (int j = 0; j < target.length(); j++) {
                if (minTouch[target.charAt(j) - 'A'] == 200) {
                    canMake = false;
                    break;
                }
                sum += minTouch[target.charAt(j) - 'A'];
            }
            answer[i] = canMake ? sum : -1;
        }
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
