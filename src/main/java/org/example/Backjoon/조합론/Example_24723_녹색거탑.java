package org.example.Backjoon.조합론;

import java.util.Scanner;

public class Example_24723_녹색거탑 {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println((int) Math.pow(2, n));
        greenTour(n);
        System.out.println(cnt);
    }

    static void greenTour(int floor) {
        if (floor == 0)
        {
            cnt++;
            return;
        }

        floor--;
        greenTour(floor);
        greenTour(floor);
    }
}
