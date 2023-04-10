package org.example.Backjoon.큐_덱_단계;

import java.io.*;
import java.util.*;

public class Example_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < nCase; i++) {
            boolean[] hasBig = new boolean[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<PrintData> printQueue = new LinkedList<>();
            List<Integer> priorityArr = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                PrintData pd = new PrintData(priority, j);
                printQueue.add(pd);
                priorityArr.add(priority);
            }

            Collections.sort(priorityArr);
            int cnt = 1;
            while(printQueue.size() > 0)
            {
                if (printQueue.peek().priority == priorityArr.get(priorityArr.size() - 1)) {
                    if(printQueue.peek().idx == idx)
                    {
                        bw.write(cnt + "\n");
                        break;
                    }
                    else
                    {
                        printQueue.poll();
                        priorityArr.remove(priorityArr.size() - 1);
                        cnt++;
                    }
                }
                else
                {
                    printQueue.offer(printQueue.poll());
                }
            }
        }
        bw.flush();
    }

    static class PrintData{
        int priority;
        int idx;

        public PrintData(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
}
