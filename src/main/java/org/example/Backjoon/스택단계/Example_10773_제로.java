package org.example.Backjoon.스택단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> zeroStack = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0) zeroStack.add(num);
            else zeroStack.remove(zeroStack.size() - 1);
        }

        int sum = 0;
        for (Integer integer : zeroStack) {
            sum += integer;
        }
        System.out.print(sum);
    }
}
