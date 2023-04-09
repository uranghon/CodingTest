package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 * 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 *
 * -입력-
 * 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
 * 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
 * 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
 * 입력은 가입한 순서로 주어진다.
 *
 * -출력-
 * 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
 *
 * -풀이-
 * 1. 나이와 이름 정보를 가지는 클래스를 Comparable 을 구현하여 생성
 * 2. 해당 클래스 객체를 가지는 리스트를 생성
 * 3. 리스트를 정렬
 */
public class Example_10814_나이순정렬 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        mine1();
    }

    static void mine1() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Person> pList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Person p = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
            pList.add(p);
        }

//        Stream.of(pList).sorted();
//        pList.sort((p1, p2) -> p1.age - p2.age);
//        pList.so;
//        pList.s;
//        pList.sort(Person::compareTo);
        Collections.sort(pList);
//        pList.sort(Person::compareTo);
//        pList.sort(Comparator.reverseOrder());
//        pList.sort(Comparator.naturalOrder());
//        Stream.of(pList).sorted();
//        pList.stream().sorted()
//        pList.stream().sorted();

//        pList.stream().sorted();
//        pList.stream().sorted(Person::compareTo);
//        Collections.sort(pList, (p1, p2) -> p1.age - p2.age);

        for (Person p : pList) {
            sb.append(p.toString()).append("\n");
        }

        System.out.println(sb);
    }

    static void mine2() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] age = new int[n];
        String[] name = new String[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            age[i] = Integer.parseInt(st.nextToken());
            name[i] = st.nextToken();
        }
//        Arrays.sort(age);
        mergeSort(age, name, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(age[i]).append(" ").append(name[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void mine3() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Person[] pArr = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pArr[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

//        Arrays.sort(pArr);
//        Arrays.sort(pArr, (p1, p2) -> p1.age - p2.age);
//        Arrays.stream(pArr).sorted();
        Stream.of(pArr).sorted();
//        Stream.of(pArr).sorted((p1, p2) -> p1.age - p2.age);
//        mergeSort(age, name, 0, n - 1);
        for (int i = 0; i < n; i++) {
            sb.append(pArr[i].age).append(" ").append(pArr[i].name).append("\n");
        }

        System.out.println(sb);
    }
    static void mergeSort(int[] age, String[] name, int fr, int to) {
        if (fr == to) return;

        int mid = (fr + to) / 2;

        mergeSort(age, name, fr, mid);
        mergeSort(age, name, mid + 1, to);

        int[] tmpAge = Arrays.copyOfRange(age, fr, to + 1);
        String[] tmpName = Arrays.copyOfRange(name, fr, to + 1);

        int leftIdx = 0; // fr - fr
        int rightIdx = mid + 1 - fr;
        int curIdx = fr;

        while (leftIdx <= mid - fr && rightIdx <= to - fr) {
            if (tmpAge[leftIdx] <= tmpAge[rightIdx]) {
                age[curIdx] = tmpAge[leftIdx];
                name[curIdx++] = tmpName[leftIdx++];
            } else {
                age[curIdx] = tmpAge[rightIdx];
                name[curIdx++] = tmpName[rightIdx++];
            }
        }

        while (leftIdx <= mid - fr) {
            age[curIdx] = tmpAge[leftIdx];
            name[curIdx++] = tmpName[leftIdx++];
        }
    }
}

class Person implements Comparable<Person> {
//class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}