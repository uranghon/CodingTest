package org.example.Backjoon.심화2단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Example_26069_붙임성좋은총총이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> user = new HashSet<>();
        user.add("ChongChong");
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            if(user.contains(arr[0])) user.add(arr[1]);
            else if(user.contains(arr[1])) user.add(arr[0]);
        }
        System.out.print(user.size());

    }
}
