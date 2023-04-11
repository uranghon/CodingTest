package org.example.Backjoon.큐_덱_단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
 * <p>
 * 지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
 * <p>
 * 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
 * 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
 * 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
 * 큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다.
 * (이 위치는 가장 처음 큐에서의 위치이다.)
 * 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
 * <p>
 * 첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다. N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.
 * 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다. 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.
 * <p>
 * 첫째 줄에 문제의 정답을 출력한다.
 */
public class Example_1021_회전하는큐 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
//
        useList(n, m);
    }

    static void notUseList(int n, int m) throws IOException {
        boolean[] chkArr = new boolean[n + 1];
        int peak = 1;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(peak != num)
            {
                int diff1 = 0;
                int cnt1 = 0;

                int diff2 = 0;
                int cnt2 = 0;

                while(true)
                {
                    diff1++;
                    if(peak + diff1 > n)
                    {
                        diff1 = 1 - peak;
                    }

                    while(chkArr[peak + diff1])
                    {
                        diff1++;
                        if(peak + diff1 > n)
                        {
                            diff1 = 1 - peak;
                        }
                    }

                    diff2++;
                    if(peak - diff2 < 1)
                    {
                        diff2 = peak - n;
                    }

                    while(chkArr[peak - diff2])
                    {
                        diff2++;
                        if(peak - diff2 < 1)
                        {
                            diff2 = peak - n;
                        }
                    }

                    cnt1++;
                    cnt2++;

                    if(peak + diff1 == num)
                    {
                        sum += cnt1;
                        break;
                    }

                    if(peak - diff2 == num)
                    {
                        sum += cnt2;
                        break;
                    }
                }
            }

            if(i + 1 == n) break;

            chkArr[num] = true;
            while (chkArr[num])
            {
                num++;
                if(num > n) num = 1;
            }

            peak = num;
        }

        System.out.print(sum);
    }

    static void useList(int n, int m) throws IOException {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        String[] chkArr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int idx = list.indexOf(Integer.parseInt(chkArr[i]));
            System.out.println(idx);
        }
    }
}
