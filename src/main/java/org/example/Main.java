package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;

public class Main {
    public static void main(String[] args) throws IOException {
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
}
