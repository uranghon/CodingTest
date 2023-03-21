package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

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