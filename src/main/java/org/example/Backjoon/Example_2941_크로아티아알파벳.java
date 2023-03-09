package org.example.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        mine(str);
        others(str);
    }

    static void mine(String str) {
        String regex = "c=|c-|dz=|d-|lj|nj|s=|(?<!d)z=";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        int c = 0;
        while (m.find())
        {
            str = str.replaceFirst(m.group(), "");
            c++;
        }

        c += str.length();

        System.out.print(c);
    }

    static void mine2(String str) {
        String regex = "c=|c-|dz=|d-|lj|nj|s=|(?<!d)z=|(?!c=|c-|dz=|d-|lj|nj|s=|(?<!d)z=).";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        int c = 0;
        while (m.find())
        {
            c++;
        }
        System.out.print(c);
    }
    static void others(String str) {
        String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < 8; i++) {
            while (str.contains(alpha[i])) {
                str = str.replace(alpha[i], "a");
                // 그러네 어짜피 저기 속하지 않는 1글자로 바꾸고, 문자열 길이 출력하면 되네. 참고로 더 큰놈이 앞에 있어야함. dz= 랑 z= 중에 큰놈이 dz= 니까 얘부터
            }
        }
        System.out.println(str.length());
    }
}
