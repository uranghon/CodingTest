package org.example.Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lv1_대충만든자판 {
    public static void main(String[] args) {
        String[] keymap = {"ASDFESASQW", "BFDVSEGA", "SDFQBOKHIT"};
        String[] targets = {"PPAP","P","DIFOS"}; // 2+9+2+6+1
        int[] answer = new int[targets.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            char[] keyChars = keymap[i].toCharArray();
            for (int j = 0; j < keyChars.length; j++) {
                if(map.get(keyChars[j] + "") == null)
                {
                    map.put(keyChars[j] + "", j + 1);
                }
                else
                {
                    if(map.get(keyChars[j] + "") > j + 1) map.put(keyChars[j] + "", j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            char[] targetChars = targets[i].toCharArray();
            for (int j = 0; j < targetChars.length; j++) {
                if(map.get(targetChars[j] + "") != null)
                {
                    answer[i] += map.get(targetChars[j] + "");
                }
                else
                {
                    answer[i] = -1;
                    break;
                }
            }
        }
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
