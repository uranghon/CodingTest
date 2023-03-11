package org.example.Backjoon._1차원배열;

import java.io.*;
import java.util.StringTokenizer;

public class Example_10811_바구니뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = br.readLine().split(" +");
        int n = Integer.parseInt(sArr[0]);
        int m = Integer.parseInt(sArr[1]);
        int[] iArr = new int[n + 1];
        iArr[0] = 0;
        for (int i = 1; i <= n; i++) {
            iArr[i] = i;
        }
        StringTokenizer st;
        int fr = 0;
        int to = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " +");
            fr = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            for (int j = fr; j <= (fr + to) / 2; j++) {
                int tmp = iArr[j];
                iArr[j] = iArr[fr + to - j];
                iArr[fr + to - j] = tmp;
            }
        }

        /*
        * 이야 나처럼 반 짤라서 하는거 말고 또 똑똑한 방법 있네
        *
        * 예를들어 첫번째 줄이 100 100 이다. 사실 뒤에 100은 상관없고
        * 첫번째 100이니까 배열 크기가 100까지리인건데, 이걸 배열1이라 하자.
        * 이걸 이제 2번째 줄부터 변환 작업 있을건데 예를 들어 2번째 줄이 3~80 이다.
        * 그러면 3~80 만큼의 길이를 가진 배열2를 만들어. 80-3+1 만큼의 크기를 가졌겠지.
        * 그리고 여기에 기존배열의 3~80까지(실제로는 배열1[2]~배열1[79]가 될거임)의 값을 넣어줘. 그러면 그 구간만큼의 값이 복사된거지!
        * 그다음에 이제 배열2를 역순으로 뽑아서 배열1에 넣어줘. 배열2[80-3+1-1] 부터 배열2[0] 까지 배열1[2] 부터 배열1[79] 까지 들어가는거지
        * 키야~~ 이 방식!
        *   s=sc.nextInt();
            e=sc.nextInt();
            int[] arr2 = new int[e-s+1];
            for(int j=0; j<arr2.length; j++) arr2[j]=arr[e-1-j];
            for(int j=0; j<arr2.length; j++) arr[s-1+j]=arr2[j];
        * */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            bw.write(iArr[i] + " ");
        }
        bw.close();
        br.close();
    }
}
