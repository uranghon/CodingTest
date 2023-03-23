package org.example.Backjoon.브루트포스단계;

import java.io.*;

/** 얘는 특별한 무언가 필요없다. 걍 burte force 로 하자.
 *  그리고 읽기는 1개 읽어도 BufferedReader 쓰는게 Scanner 보다 한참 빠르다.
 *  근데 쓰기는 1개 쓸거면 굳이 BufferedWriter 안쓰고 System.out.print 쓰면 된다.
 */

public class Example_1436_영화감독슘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 666;

        while (n > 0) {
            if(chk666(num)) n--;
            num++;
        }

        System.out.print(--num);
    }

    static boolean chk666(int num) {
        int six3 = 0;
        while (num > 665) {
            if (num % 1000 == 666) return true;
            num /= 10;
        }
        return false;
    }
}
