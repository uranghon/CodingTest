package org.example.Backjoon.그리디알고리즘단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 *
 * 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
 * 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
 * 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
 *
 *
 */
public class Example_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
//        System.out.print(mine(str));
        System.out.print(others(str));
    }

    static int mine(String str) {
        char[] chars = str.toCharArray();

        int tmp = 0;
        int num = 0;
        int sum = 0;

        boolean minus = false;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                num += tmp;

                if(minus) sum -= num;
                else sum += num;

                num = tmp = 0;
                minus = true;
            } else if (chars[i] == '+') {
                num += tmp;
                tmp = 0;
            } else {
                tmp *= 10;
                tmp += chars[i] - '0';
            }
        }

        num += tmp;
        if(minus) sum -= num;
        else sum += num;

        return sum;
    }

    /**
     * split 이용. 좋다.
     */
    static int others(String str) {

        String[] splitMinus = str.split("-");
        String[] splitPlus = splitMinus[0].split("\\+");

        int sum = 0;
        for (int i = 0; i < splitPlus.length; i++) {
            sum += Integer.parseInt(splitPlus[i]);
        }

        for (int i = 1; i < splitMinus.length; i++) {
            int tmp = 0;
            splitPlus = splitMinus[i].split("\\+");
            for (int j = 0; j < splitPlus.length; j++) {
                tmp += Integer.parseInt(splitPlus[j]);
            }
            sum -= tmp;
        }

        return sum;
    }
}
