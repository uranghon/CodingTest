package org.example.Programmers;

import java.util.HashMap;
import java.util.Map;

public class Lv1_둘만의암호 {
    public static void main(String[] args) {
        내꺼();
        남꺼1();
    }
    static void 내꺼() {
        String s = "zxypq";
        String skip = "cdefghijkl";

        int index = 20;

        String az = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < skip.length(); i++) {
            az = az.replace(String.valueOf(skip.charAt(i)), "");
        }

        Map<Integer, Integer> sIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int mapIndex = (az.indexOf(String.valueOf(s.charAt(i))) + index) % az.length();
            sIndexMap.putIfAbsent(i, mapIndex);
        }
        // A.indexOf(B) 는 A 안에서 B가 몇번째에 등장하는가 찾는거다

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(az.charAt(sIndexMap.get(i)) + "");
        }

        System.out.println(sb.toString());
    }

    static void 남꺼1() {
        String s = "zxypq";
        String skip = "cdefghijkl";

        int index = 20;

        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) { // 해당 문자가 skip 내의 문자가 아니면 idx++. skip 내의 문자면 idx를 ++ 하지 않음으로써 한칸 더 갈 수 있다.
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        System.out.println(answer.toString());
    }
}
