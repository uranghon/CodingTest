package org.example;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        String str = "ljes=njak";
        String regex = "c=|c-|dz=|d-|lj|nj|s=|(?<!d)z=|(?!c=|c-|dz=|d-|lj|nj|s=|(?<!d)z=).";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        int c = 0;
        while (m.find())
        {
            System.out.println("찾은거 : " + m.group());
            c++;
        }
        System.out.print(c);
    }


}

