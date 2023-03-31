package org.example.Backjoon.시간복잡도단계;

import java.util.Scanner;

public class Example_24267_알고리즘수행시간6 {
    /**
     * 오늘도 서준이는 알고리즘의 수행시간 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
     * 입력의 크기 n이 주어지면 MenOfPassion 알고리즘 수행 시간을 예제 출력과 같은 방식으로 출력해보자.
     * MenOfPassion 알고리즘은 다음과 같다.
     *
     * MenOfPassion(A[], n) {
     *     sum <- 0;
     *     for i <- 1 to n - 2
     *         for j <- i + 1 to n - 1
     *             for k <- j + 1 to n
     *                 sum <- sum + A[i] × A[j] × A[k]; # 코드1
     *     return sum;
     * }
     *
     * 첫째 줄에 코드1 의 수행 횟수를 출력한다.
     * 둘째 줄에 코드1 의 수행 횟수를 다항식으로 나타내었을 때, 최고차항의 차수를 출력한다. 단, 다항식으로 나타낼 수 없거나 최고차항의 차수가 3보다 크면 4를 출력한다.
     */

    // 이야 설명 굿
    // 위 내용은 n개의 숫자중에서 서로다른 3개의 숫자를 뽑는 문제이다.
    // 기본적으로 n(n-1)(n-2) 이다.
    // 근데, 순서가 상관없는 찾기방법과 같다. (같은 숫자의 조합이면 같은 걸로 치는 방법)
    // 순열이 아니라 조합이라는 거다.
    // n!/(n-3)!3!
    // (왜? 앞에 있는 수가 무조건 더 작음. 123 은 되는데, 321은 안됨. 312도 안됨. 이런애들 무시된다는 뜻)
    // 3! 만큼 나누기 해줘야 한다.
    // 3! = 6 이다.
    // 따라서 n(n-1)(n-2)/6 이다.
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        mine(n);
        others(n);
    }

    static void mine(long n) {
        long i = 1;
        long j = n - 2;
        long sum = 0;
        while (i <= (n - 2) / 2) {
            sum += i * j * 2;
            i++;
            j--;
        }

        if (n % 2 != 0 && n > 2) sum += i * j;

        System.out.println(sum + "\n3");
//        System.out.println(sum);
    }

    static void others(long n) {
        System.out.println((n * (n - 1) * (n - 2)) / 6 + "\n3");
    }
}
