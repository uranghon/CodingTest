package org.example.Backjoon.그리디알고리즘단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Example_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] city = new int[n];
        int[] dist = new int[n];
        long costSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dist.length - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city.length; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        long minCost  = 1_000_000_000;
        for (int i = 0; i < city.length - 1; i++) {
            minCost = Math.min(minCost, city[i]);
            costSum += minCost * dist[i];
        }

        System.out.print(costSum);
    }
}
