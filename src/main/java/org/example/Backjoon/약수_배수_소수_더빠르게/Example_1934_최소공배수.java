package org.example.Backjoon.약수_배수_소수_더빠르게;

import java.io.*;
import java.util.*;

/**
 * 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다.
 * 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
 *
 * 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
 *
 * -풀이-
 * 두 수의 최소공배수는 두 수를 곱한값을 두 수의 최대공약수로 나눈 값이다.
 * 즉, 유클리드 호제법으로 두 수의 최대공약수를 구하면 쉽게 해결된다.
 */
public class Example_1934_최소공배수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
//        mine1(n);
//        mine2(n);
//        mine3(n);
//        mine4(n);
//        mine5(n);
//        mine6(n);
        others2(n);
        bw.flush();
    }

    static void mine1(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int dvsr = 2;
            int minCommonMultiple = 1;
            while (true) {
                if (a % dvsr == 0 && b % dvsr == 0) {
                    a /= dvsr;
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                } else if (a % dvsr == 0) {
                    a /= dvsr;
                    minCommonMultiple *= dvsr;
                } else if (b % dvsr == 0) {
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                } else {
                    dvsr++;
                }

                if (a == 1 && b == 1) break;
            }
            bw.write(minCommonMultiple + "\n");
        }
    }

    static void mine2(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int dvsr = 2;
            int minCommonMultiple = 1;
            while (true) {
                if (a % dvsr == 0 && b % dvsr == 0) {
                    a /= dvsr;
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                } else if (a % dvsr == 0) {
                    a /= dvsr;
                    minCommonMultiple *= dvsr;
                } else if (b % dvsr == 0) {
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                } else {
                    dvsr++;
                }

                if (a == 1 && b == 1) break;
            }
            bw.write(minCommonMultiple + "\n");
        }
    }

    static void mine3(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dvsr = 2;
            int minCommonMultiple = 1;
            while (true) {
                if (a % dvsr == 0 && b % dvsr == 0) {
                    a /= dvsr;
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                } else if (a % dvsr == 0) {
                    a /= dvsr;
                    minCommonMultiple *= dvsr;
                } else if (b % dvsr == 0) {
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                } else {
                    dvsr++;
                }

                if (a == b) {
                    minCommonMultiple *= a;
                    break;
                } else if (a == 1) {
                    minCommonMultiple *= b;
                    break;
                } else if (b == 1) {
                    minCommonMultiple *= a;
                    break;
                }
            }
            bw.write(minCommonMultiple + "\n");
        }
    }

    static void mine4(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dvsr = 2;
            int minCommonMultiple = 1;

            while (a != b && a > 1 && b > 1) {
                while (a % dvsr == 0 && b % dvsr == 0) {
                    a /= dvsr;
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                }

                while (a % dvsr == 0) {
                    a /= dvsr;
                    minCommonMultiple *= dvsr;
                }

                while (b % dvsr == 0) {
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                }

                dvsr++;
            }
            minCommonMultiple *= a <= b ? b : a;
            bw.write(minCommonMultiple + "\n");
        }
    }

    static void mine5(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dvsr = Math.min(a, b);
            int minCommonMultiple = 1;
            while (dvsr > 1) {
                if(a % dvsr == 0 && b % dvsr == 0)
                {
                    a /= dvsr;
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                    dvsr = Math.min(a, b);
                }
                else
                {
                    dvsr--;
                }
            }
            minCommonMultiple *= a * b;
            bw.write(minCommonMultiple + "\n");
        }
    }

    static void mine6(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dvsr = 2;
            int minCommonMultiple = 1;
            while (dvsr > 1) {
                while (a % dvsr == 0 && b % dvsr == 0) {
                    a /= dvsr;
                    b /= dvsr;
                    minCommonMultiple *= dvsr;
                }
                dvsr++;
                if(dvsr > (a < b ? a : b)) break;
            }
            minCommonMultiple *= a * b;
            bw.write(minCommonMultiple + "\n");
        }
    }

    /**
     * 두 수의 최소공배수는
     * 두 수를 곱한 값에서 두 수의 최대 공약수를 나눈 값이다.
     */
    static void others(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ab = a * b;
            int dvsr = Math.min(a, b);
            while (dvsr > 1) {
                if(a % dvsr == 0 && b % dvsr == 0) break;
                dvsr--;
            }
            bw.write(ab / dvsr + "\n");
        }
    }
    /**
     * 두 수의 최소공배수는
     * 두 수를 곱한 값에서 두 수의 최대 공약수를 나눈 값이다.
     * 두 수의 a, b 의 최대 공야구는
     * a > b 일 때, b 와 (a % b) 의 최대 공약수와 같다.
     * (= 작은수와 (큰수를 작은수로 나눈 나머지) 의 최대 공약수와 같다.)
     * 나머지가 0이 될때까지.. 즉 작은수가 최대 공약수가 될때까지 반복하면 a, b 의 최대 공약수를 구할 수 있다.
     */
    static void others2(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write((a * b) / getGCD(a, b) + "\n");
        }
    }

    // 최대공약수 외우자.
    static int getGCD(int a, int b)
    {
        if(b == 0) return a;
        else return getGCD(b, a % b);
    }
}

// 24 32
// 32 24
// 24 8
// 8 0
// 0 8
// 8