package org.example;

import javax.lang.model.util.ElementScanner6;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        int s = 0;
        for(char c : charArray)
        {
            s += dialNum(c);
        }

        System.out.println(s + charArray.length);
        br.close();
    }

    static int dialNum(char c) {
        int num = 0;
        switch (c) {
            case 'A' :
            case 'B' :
            case 'C' :
                num = 2;
                break;
            case 'D' :
            case 'E' :
            case 'F' :
                num = 3;
                break;
            case 'G' :
            case 'H' :
            case 'I' :
                num = 4;
                break;
            case 'J' :
            case 'K' :
            case 'L' :
                num = 5;
                break;
            case 'M' :
            case 'N' :
            case 'O' :
                num = 6;
                break;
            case 'P' :
            case 'Q' :
            case 'R' :
            case 'S' :
                num = 7;
                break;
            case 'T' :
            case 'U' :
            case 'V' :
                num = 8;
                break;
            case 'W' :
            case 'X' :
            case 'Y' :
            case 'Z' :
                num = 9;
                break;
        }
        return num;
    }
}
