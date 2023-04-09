package org.example.Backjoon.심화2단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Example_25192_인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> user = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String chat = br.readLine();
            if(chat.equals("ENTER")) user.clear();
            else {
                if(!user.contains(chat)){
                    user.add(chat);
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}
