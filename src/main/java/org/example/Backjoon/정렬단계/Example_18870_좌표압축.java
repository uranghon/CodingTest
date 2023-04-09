package org.example.Backjoon.정렬단계;

import java.io.*;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
 * X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 *
 * 첫째 줄에 N이 주어진다.
 * 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 *
 * 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 *
 * -풀이-
 * 1.
 * 구성요소
 * 1) (값, 인덱스) 가지는 클래스X 타입 리스트 xList
 *    (리스트인 이유는 정렬이 Collections.sort 가 제일 빨라서)
 * 2) 압축X 를 가질 배열 iArr 로 구성.
 * 순서
 * 1) n번 만큼 값과 인덱스를 xList에 추가
 * 2) xList를 값 기준 오름차 순 정렬
 * 3) xList의 맨왼쪽값(최솟값)의 인덱스와 같은 인덱스의 iArr의 값은 0. (더 작은 값이 없으므로)
 * 4) xList의 요소를 하나씩 체크하면서 바로 앞 요소의 값와 같은 값을 가졌으면 해당 인덱스의 iArr 값도 동일
 * 5) xList의 요소를 하나씩 체크하면서 바로 앞 요소의 값와 달라지면 해당 인덱스의 iArr 의 값은 이전값 + 1
 * 6) iArr 출력
 *
 * 2. x 노드 클래스 활용
 *
 */
public class Example_18870_좌표압축 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        mine1();
//        mine2(); // 제일 빠름

//        mine4();
    }

    static void mine1() throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> xList = new ArrayList<>(n);
        int[] xList2 = new int[n];
        Map<Integer, Integer> xMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++)
        {
//            xList.add(num);
            xList.add(xList2[i] = Integer.parseInt(st.nextToken()));
        }

//        List<Integer> list = List.copyOf(xList);

        Collections.sort(xList);

        int idx = 0;
//        int min = xList.get(0) - 1;

//        for (int i = 0; i < xList.size(); i++)
//        {
//            if(xMap.get(xList.get(i)) == null)
//                xMap.put(xList.get(i), idx++);
////            if(xMap.getOrDefault(xList.get(i), min) == min)
////                xMap.put(xList.get(i), idx++);
//        }

//        Iterator<Integer> iterator = xList.stream().distinct().iterator();
//        while (iterator.hasNext())
//        {
//            xMap.put(iterator.next(), idx++);
//        }

        for (int i = 0; i < xList.size(); i++)
        {
            if(!xMap.containsKey(xList.get(i)))
                xMap.put(xList.get(i), idx++);
        }

        StringBuilder sb = new StringBuilder();
//        for (Integer x : list) {
////        while(iterator.hasNext())
////            sb.append(xMap.get(iterator.next())).append(" ");
//            sb.append(xMap.get(x)).append(" ");
//        }
        for (int i = 0; i < xList2.length; i++) {
            sb.append(xMap.get(xList2[i])).append(" ");
        }
//        for (Integer x : xList) {
//            sb.append(xMap.get(x)).append(" ");
//        }



        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    /** 제일 빠름
     * 구성요소
     * 1. (값, 인덱스) 가지는 클래스X 타입 리스트 xList
     *    (리스트인 이유는 정렬이 Collections.sort 가 제일 빨라서)
     * 2. 압축X 를 가질 배열 iArr 로 구성.
     *
     * 순서
     * 1. n번 만큼 값과 인덱스를 xList에 추가
     * 2. xList를 값 기준 오름차순 정렬
     * 3. xList의 맨왼쪽값(최솟값)의 인덱스와 같은 인덱스의 iArr의 값은 0. (더 작은 값이 없으므로)
     * 4. xList의 요소를 하나씩 체크하면서 바로 앞 요소의 값와 같은 값을 가졌으면 해당 인덱스의 iArr 값도 동일
     * 5. xList의 요소를 하나씩 체크하면서 바로 앞 요소의 값와 달라지면 해당 인덱스의 iArr 의 값은 이전값 + 1
     * 6. iArr 출력
     *
     */
    static void mine2() throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<X> xList = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            xList.add(new X(Integer.parseInt(st.nextToken()), i));
        }

        Collections.sort(xList);

        int[] iArr = new int[n];
        int smallCnt = 0;
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            X cur = xList.get(i);
            if (cur.x != prev) {
                prev = cur.x;
                iArr[cur.idx] = smallCnt++;
            } else {
                iArr[cur.idx] = smallCnt - 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < iArr.length; i++) {
            sb.append(iArr[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static void mine3() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] iArr = new int[n];
        List<int[]> xList = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int[] tmpArr = {Integer.parseInt(st.nextToken()), i};
            xList.add(tmpArr);
        }

        Collections.sort(xList, (a, b) -> a[0] - b[0]);

//        for (int i = 0; i < iArr.length; i++) {
//            if(i == 0)
//            {
//                iArr[xList.get(i)[1]] = 0;
//            }
//            else
//            {
//                if (xList.get(i)[0] == xList.get(i - 1)[0]) {
//                    iArr[xList.get(i)[1]] = iArr[xList.get(i - 1)[1]];
//                }
//                else
//                {
//                    iArr[xList.get(i)[1]] = iArr[xList.get(i - 1)[1]] + 1;
//                }
//            }
//        }

        int smallCnt = 0;
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] cur = xList.get(i);
            if (cur[0] != prev) {
                prev = cur[0];
                iArr[cur[1]] = smallCnt++;
            } else {
                iArr[cur[1]] = smallCnt - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            sb.append(iArr[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static void mine4() throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<Integer> xList = new ArrayList<>(n);
        List<Integer> newXList = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            xList.add(num);
            newXList.add(num);
        }

        Collections.sort(newXList);

        int[] idxArr = new int[n];
        int hasSmall = 0;
        idxArr[hasSmall] = newXList.get(0);
        for (int i = 1; i < newXList.size(); i++) {
            if(newXList.get(i) > idxArr[hasSmall])
            {
                hasSmall++;
                idxArr[hasSmall] = newXList.get(i);
            }
        }

        int preInteger = Integer.MIN_VALUE;
        int x2 = -1;

        for (Integer i : xList) {
            if(preInteger < i)
            {
                x2 = findIdx(i, x2 + 1, hasSmall, idxArr);
            } else if (preInteger > i) {
                x2 = findIdx(i, 0, x2 - 1, idxArr);
            }

            preInteger = i;
            bw.write(x2 + " ");
        }

        bw.flush();
    }

    static int findIdx(int i, int fr, int to, int[] idxArr) {
        int idx = (fr / 2) + (to / 2);

        while (i != idxArr[idx])
        {
            if (i < idxArr[idx]) {
                to = idx - 1;
            } else if (i > idxArr[idx]) {
                fr = idx + 1;
            }

            idx = (fr + to) / 2;
        }

        return idx;
    }
}

class X implements Comparable<X> {
    int x;
    int idx;

    public X(int x, int idx) {
        this.x = x;
        this.idx = idx;
    }

    @Override
    public int compareTo(X o) {
        return this.x - o.x;
    }
}

/** 트리 활용
 *
 *
 */
class Others3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        XTree[] numTreeArr = new XTree[N];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        XTree tree = new XTree(Integer.parseInt(st.nextToken()));
        numTreeArr[0] = tree;
        for (int i = 1; i < N; i++) {
            numTreeArr[i] = tree.addXTree(Integer.parseInt(st.nextToken()));
        }
        bf.close();
        tree.setLeftXCnt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(tree.leftXCnt);
        for (int i = 1; i < N; i++) {
            sb.append(" ").append(numTreeArr[i].leftXCnt);
        }
        System.out.print(sb);
    }
    static class XTree {
        int x;
        int leftXCnt;
        XTree leftX;
        XTree rightX;

        public XTree(int x) {
            this.x = x;
        }

        public XTree addXTree(int x) {
            if(this.x > x)
            {
                if(leftX == null)
                {
                    leftX = new XTree(x);
                    return leftX;
                }
                return leftX.addXTree(x);
            }
            else if(this.x < x)
            {
                if(rightX == null)
                {
                    rightX = new XTree(x);
                    return rightX;
                }
                return rightX.addXTree(x);
            }
            else
            {
                return this;
            }
        }

        int setLeftXCnt(int leftXCnt) {
            if (leftX != null) {
                leftXCnt = leftX.setLeftXCnt(leftXCnt);
            }
            this.leftXCnt = leftXCnt++;

            if (rightX != null) {
                leftXCnt = rightX.setLeftXCnt(leftXCnt);
            }
            return leftXCnt;
        }
    }

}

/**
 * 완전적게쓰고 빠름
 * 보니까 읽는 부분에서 메모리가 많이 사용됨
 */
class Others
{
    static final InputStream IN = System.in;
    static final int MX = 1000000;

    static int size, sizeUniq;
    static int[] src = new int[MX];
    static int[] sorted = new int[MX];
    static int[] uniqSorted = new int[MX];
    // static Set<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        /*
         * read -- n
         * sort -- nlogn
         * uniq -- n
         * binary search for each coordinate -- n * logn
         * => nlong
         */

        readArr();
        copyAndSort();
        uniq();
        printCompressedCoordinates();
    }

    static void copyAndSort() {
        for (int i = 0; i < size; ++i)
            sorted[i] = src[i];
        Arrays.sort(sorted, 0, size);
    }

    static void readArr() throws IOException {
        size = readInt();
        for (int i = 0; i < size; ++i)
            src[i] = readInt();
    }

    static int readInt() throws IOException {
        int val = 0;
        boolean negative = false;
        do {
            int c = IN.read();
            if (c == ' ' || c == '\n' || c == -1) break;
            if (c == '-') {
                negative = true;
                continue;
            }
            val = 10*val + c-48;
        } while (true);
        return negative ? -val : val;
    }

    static void uniq() {
        uniqSorted[0] = sorted[0];
        int iu = 0;
        for (int is = 1; is < size; ++is) {
            if (sorted[is] != uniqSorted[iu])
                uniqSorted[++iu] = sorted[is];
        }
        sizeUniq = iu + 1;
    }

    static void printCompressedCoordinates() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            int idx = Arrays.binarySearch(uniqSorted, 0, sizeUniq, src[i]);
            sb.append(idx).append(' ');
        }
        System.out.println(sb.toString());
    }
}

class Others2
{
    static final InputStream IN = System.in;
    static final int MX = 1000000;

    static int size, sizeUniq;
    static int[] src = new int[MX];
    static int[] sorted = new int[MX];
    static int[] uniq = new int[MX];
    static Map<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        /*
         * read -- n
         * sort -- nlogn
         * uniq -- n
         * search for each coordinate -- n * 1
         * => nlong
         */

        readArr();
        copyAndSort();
        uniq();
        printCompressedCoordinates();
    }

    static void copyAndSort() {
        for (int i = 0; i < size; ++i)
            sorted[i] = src[i];
        Arrays.sort(sorted, 0, size);
    }

    static void readArr() throws IOException {
        size = readInt();
        for (int i = 0; i < size; ++i)
            src[i] = readInt();
    }

    static int readInt() throws IOException {
        int val = 0;
        boolean negative = false;
        do {
            int c = IN.read();
            if (c == ' ' || c == '\n' || c == -1) break;
            if (c == '-') {
                negative = true;
                continue;
            }
            val = 10*val + c-48;
        } while (true);
        return negative ? -val : val;
    }

    static void uniq() {
        int lastVal = sorted[0];
        hashMap.put(lastVal, 0);
        int iu = 1;
        for (int is = 1; is < size; ++is) {
            if (sorted[is] != lastVal) {
                lastVal = sorted[is];
                hashMap.put(lastVal, iu++);
            }
        }
        sizeUniq = iu;
    }

    static void printCompressedCoordinates() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            int idx = hashMap.get(src[i]);
            sb.append(idx).append(' ');
        }
        System.out.println(sb.toString());
    }
}