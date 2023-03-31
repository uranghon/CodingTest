package org.example.Backjoon.심화1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다.
 * 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
 * c=, c-, dz=, d-, lj, nj, s=, z=  나오면 얘넨 저 단위가 알파벳 1개임. 저걸로 조각낼 수 없는 문자들은 1개가 알파벳 1개.
 * 예를 들어, ljes=njak은 lj, e, s=, nj, a, k 로 크로아티아 알파벳 6개이다.
 * 위에 나온 애들은 무조건 저 자체가 1개의 알파벳이다. 분리된걸로 보지 않는다.
 * zz= 면 z,z,= 이 아니라 z, z= 이고, dz= 는 d,z,= 혹은 d,z= 이런게 아니라 dz= 하나다.
 * 보면 dz= 랑 z=가 곂치게 보이는데, dz= 라는 글자가 오면 dz= 가 우선이다.
 *
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 *
 * -풀이-
 * 1. 정규식으로 특수알파벳랑 매칭되는 애들 찾아서 몇개있는지 확인 후 삭제하고 + 남은애들 글자수
 * 2. 정규식으로 특수알파벳+특수알파벳아닌애 찾아서 몇그룹인지 체크
 * 3. 특수알파벳 몇개 안되니까 큰놈(예를 들어 dz=, z= 있을 때, dz= ) 부터 해서 지워나가면서 몇번 지웠는지 체크하고 + 남은 글자수
 */
public class Example_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        mine(str);
        mine2(str);
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
