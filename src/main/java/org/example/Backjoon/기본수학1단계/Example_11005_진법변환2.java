package org.example.Backjoon.기본수학1단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * Integer.toString(숫자문자열, 몇진법)
 */
public class Example_11005_진법변환2 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

//        System.out.print(Integer.toString(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

//        mine1(n, b);
        mine2(n, b);
        System.out.print(sb);
    }

    private static void mine1(int n, int b) {
        int level = 1;
        while (Math.pow(b, level) <= n)
        {
            level++;
        }

        while (--level >= 0) {
            for (int i = b - 1; i >= 0; i--) {
                if(i == 0) sb.append(0);
                else if(Math.pow(b, level) * i <= n)
                {
                    n -= Math.pow(b, level) * i;
                    if(i > 9) sb.append((char)('A' - 10 + i));
                    else sb.append(i);
                    break;
                }
            }
        }
    }

    private static void mine2(int n, int b) {
        while (n > 0) {
            int num = n % b;
            if(num < 10) sb.append(num);
            else sb.append('A' - 10 + num);
            n /= b;
        }
    }
}
