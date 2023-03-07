package org.example.Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lv1_햄버거만들기 {
    public static void main(String[] args) {
        Bugger_mine.getCount(); // 1,2,3,1 연속된거는 아님.
        mine();
        others();
    }

    static void mine() {
        int[] ingredient = {1,1,1,2,3,1,2,3,1,2,3,1};
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        for (int i : ingredient) {
            sb.append(i);
        }

        int index = 0;
        while (true)
        {
            if((index = sb.indexOf("1231", index > 1 ? index -2 : index > 0 ? index - 1 : index)) == -1) break;

            sb.delete(index, index + 4);
            answer++;
        }

        System.out.println(answer);
    }
    static void others() {
        int[] ingredient = {1,1,1,2,3,1,2,3,1,2,3,1};
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

class Bugger_mine {
    private static Map<Integer, ArrayList<Integer>> indexMap = new HashMap<>();
    public static void getCount() {
// 빵빵 야채야채야채 고기고기 빵 이면 한다는거야 안한다는거야
        // 일단 안하는거 하고, 다음 하는걸로 할까?
        // 해보니까 안하는거는 실패! 해야한다.
        // 그럼 해야할 때 기준을 중복되는건 뒤에꺼부터 집어가는 식으로 해보자.
        int[] ingredient = {1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1};

        int answer = 0;

        for (int i = 1; i <= 3; i++) {
            indexMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < ingredient.length; i++) {
            if(ingredient[i] == 1)
            {
                int last1 = getLastIndex(1);
                int last2 = getLastIndex(2);
                int last3 = getLastIndex(3);

                if(last1 > -1 && last1 < last2 && last2 < last3)
                {
                    delLastIndex(1);
                    delLastIndex(2);
                    delLastIndex(3);
                    answer++;
                }
                else
                {
                    ArrayList<Integer> indexList = indexMap.get(ingredient[i]);
                    indexList.add(i);
                    indexMap.put(ingredient[i], indexList);
                }
            }
            else
            {
                ArrayList<Integer> indexList = indexMap.get(ingredient[i]);
                indexList.add(i);
                indexMap.put(ingredient[i], indexList);
            }
        }

        System.out.println(answer);
    }

    private static int getLastIndex(int i)
    {
        ArrayList<Integer> indexList = indexMap.get(i);
        if(!indexList.isEmpty()) return indexList.get(indexList.size() - 1);
        else return -1;
    }

    private static void delLastIndex(int i)
    {
        ArrayList<Integer> indexList = indexMap.get(i);
        indexList.remove(indexList.size() - 1);
    }
}
