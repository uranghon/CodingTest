package org.example.Backjoon.큐_덱_단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example_5430_AC {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] ins = br.readLine().toCharArray();
            int size = Integer.parseInt(br.readLine());
            LinkedList<String> list = new LinkedList<>();

            Pattern p = Pattern.compile("(?<=\\D)\\d+");
            Matcher m = p.matcher(br.readLine());

            while (m.find()) {
                list.add(m.group());
            }
            boolean blLeft = true;
            boolean blError = false;
            for (int c = 0; c < ins.length; c++) {
                if (ins[c] == 'R') {
                    blLeft = !blLeft;
                }
                else {
                    if(list.isEmpty()) {
                        blError = true;
                        break;
                    }

                    if (blLeft) list.pollFirst();
                    else list.pollLast();
                }
            }

            if(blError)
            {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder("[");
            int lSize = list.size();
            for (int ls = 0; ls < lSize; ls++) {
                if(blLeft) sb.append(list.pollFirst()).append(",");
                else sb.append(list.pollLast()).append(",");

                if(ls == lSize - 1) sb.deleteCharAt(sb.length() - 1);
            }

            sb.append("]");
            System.out.println(sb);
        }
    }
}
