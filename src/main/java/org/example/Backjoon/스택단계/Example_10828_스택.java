package org.example.Backjoon.스택단계;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Example_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr = br.readLine().split(" ");

            switch (arr[0]) {
                case "push":
//                    stack.add(Integer.parseInt(arr[1]));
                    stack.push(Integer.parseInt(arr[1]));
                    break;
                case "pop":
//                    if(stack.size() > 0) bw.write(stack.removeLast() + "");
                    if(stack.size() > 0) bw.write(stack.pop() + "");
                    else bw.write("-1");
//                    String x = stack.pollFirst() + "";
//                    bw.write(x.equals("null") ? "-1" : x);
//                    int x = stack.pollFirst();
//                    bw.write(x);
                    bw.newLine();
                    break;
                case "size":
                    bw.write(stack.size() + "");
                    bw.newLine();
                    break;
                case "empty":
                    if(stack.isEmpty()) bw.write("1");
                    else bw.write("0");
                    bw.newLine();
                    break;
                case "top":
//                    if(stack.size() > 0) bw.write(stack.getLast() + "");
                    if(stack.size() > 0) bw.write(stack.peekFirst() + "");
//                    if(stack.size() > 0) bw.write(stack.getFirst() + "");
                    else bw.write("-1");
                    bw.newLine();
                    break;
            }
        }
        bw.flush();
    }
}
