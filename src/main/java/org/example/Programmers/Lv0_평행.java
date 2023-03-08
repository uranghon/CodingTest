package org.example.Programmers;

public class Lv0_평행 {
    public static void main(String[] args) {
        int[][] dots = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};
        int answer = 0;

        if( Double.compare((double)(dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]), (double)(dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0])) == 0 )
        {
            answer++;
        } else if( Double.compare((double)(dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]), (double)(dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0])) == 0 )
        {
            answer++;
        }
        else if( Double.compare((double)(dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]), (double)(dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0])) == 0 )
        {
            answer++;
        }

        System.out.println("answer = " + answer);
    }
}
