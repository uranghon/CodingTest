package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] keymap = {"ASDFESASQW", "BFDVSEGA", "SDFQBOKHIT"};
        String[] targets = {"PPAP","P","DIFOS"}; // 2+9+2+6+1
        int[] answer = new int[targets.length];

        Set<String> set = new HashSet<>(Arrays.asList(keymap));
        set.remove("");

        for (int i = 0; i < targets.length; i++) { // targets

            for (int l = 0; l < targets[i].length(); l++) { // char
                int k = 101;

                for (String j : set) { // set
                    int index = j.indexOf(targets[i].charAt(l));

                    if (index == -1) continue;
                    else if (index < k) k = index;
                }


                if (k == 101) {
                    answer[i] = -1;
                    break;
                } else answer[i] += (k + 1);
            }
        }

        System.out.println("answer = " + Arrays.toString(answer));
    }
}
