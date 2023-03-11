package org.example.Backjoon.약수_배수_소수;

import java.io.*;

public class Example_5086_배수와약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true)
        {
            String[] sArr = br.readLine().split(" ");
            int a = Integer.parseInt(sArr[0]);
            int b = Integer.parseInt(sArr[1]);

            if(a == 0 && b == 0) break;
            else if (a == 0 || b == 0) bw.write("neither");
            else if(a % b == 0) bw.write("multiple");
            else if(b % a == 0) bw.write("factor");
            else bw.write("neither");

            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
