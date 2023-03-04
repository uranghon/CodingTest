package org.example.Programmers;

import java.util.Arrays;

public class lv1_바탕화면정리 {
    public static void main(String[] args) {
        String[] wallpaper = {"..", "#."};

        int x = 0; // 행
        int y = 0; // 열
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;

        for (String s : wallpaper) {
            for(char c : s.toCharArray())
            {
                if(c == '#')
                {
                    lux = x < lux ? x : lux;
                    luy = y < luy ? y : luy;
                    rdx = x + 1 > rdx ? x + 1 : rdx;
                    rdy = y + 1 > rdy ? y + 1 : rdy;
                }
                y++;
            }
            x++;
            y = 0;
        }

        lux = lux >= rdx ? 0 : lux;
        luy = luy >= rdy ? 0 : luy;

        int[] answer = {0, 0, 0, 0};
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx;
        answer[3] = rdy;
        System.out.println(Arrays.toString(answer));
    }
}
