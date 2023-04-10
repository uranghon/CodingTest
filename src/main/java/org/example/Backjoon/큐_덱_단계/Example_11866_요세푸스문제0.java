package org.example.Backjoon.큐_덱_단계;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Example_11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

//        System.out.print(notUseQueue(n, k));
        System.out.print(useQueue(n, k));
    }

    static String notUseQueue(int n, int k) {
        boolean[] arr = new boolean[n + 1];
        arr[0] = true;

        StringBuilder sb = new StringBuilder("<");
        int i = k;
        int cnt = 0;
        while (true) {
            sb.append(i).append(", ");
            arr[i] = true;
            cnt++;
            if(cnt == n)
            {
                sb.delete(sb.length() - 2, sb.length());
                sb.append(">");
                break;
            }

            int kCnt = 0;
            while (kCnt < k)
            {
                i++;
                if(i > n) i -= n;
                if(arr[i]) continue;
                kCnt++;
            }
        }

        return sb.toString();
    }

    static String useQueue(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while (true) {
            int cnt = k - 1;
            while(cnt-- > 0)
            {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(", ");

            if(queue.size() == 1)
            {
                sb.append(queue.poll()).append(">");
                break;
            }
        }
        return sb.toString();
    }
}
