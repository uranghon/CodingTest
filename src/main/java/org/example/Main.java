package org.example;

import javax.swing.plaf.synth.SynthUI;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //1 7 19 37 61   6 12 18 24 6의 배수 2~7까지가 1칸 이내, 8~19 까지 2칸 이내, 20~37 까지 3칸 이내
        // 1,2,3,4
        // 결과 <= 1 이면
        int i = 1;

        while(n > 1)
        {
            i++;
            n = n - 6 * (i - 1);
        }

        System.out.print(i);

        br.close();
    }
}

