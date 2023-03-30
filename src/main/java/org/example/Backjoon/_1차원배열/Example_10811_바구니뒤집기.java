package org.example.Backjoon._1차원배열;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다.
 * 바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ..., 가장 오른쪽 바구니를 N번째 바구니라고 부른다.
 * 도현이는 앞으로 M번 바구니의 순서를 역순으로 만들려고 한다.
 * 도현이는 한 번 순서를 역순으로 바꿀 때, 순서를 역순으로 만들 범위를 정하고, 그 범위에 들어있는 바구니의 순서를 역순으로 만든다.
 * 바구니의 순서를 어떻게 바꿀지 주어졌을 때, M번 바구니의 순서를 역순으로 만든 다음,
 * 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
 * 둘째 줄부터 M개의 줄에는 바구니의 순서를 역순으로 만드는 방법이 주어진다.
 * 방법은 i j로 나타내고, 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 역순으로 만든다는 뜻이다. (1 ≤ i ≤ j ≤ N)
 * 도현이는 입력으로 주어진 순서대로 바구니의 순서를 바꾼다.
 *
 * 모든 순서를 바꾼 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.
 */
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
