package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        1,2,4,7,11,16
        // 1,3,6,10,15
        int target = 0;
        int level = 0;
        while(target < n)
        {
            target += ++level;
        }
        // 홀수 분자1, 분모 1,3,5,7, ...
        // 짝수 분모1, 분자 2,4,6,8, ...
        int diff = target - n;
        int child = 1;
        int parent = 1;
        if (level % 2 == 0) {
            child = level - diff;
            parent += diff;

        } else {
            child += diff;
            parent = level - diff;
        }

        System.out.print(child + "/" + parent);
    }
}
