package org.example.Backjoon.심화2단계;

import java.io.*;
import java.util.*;

public class Example_20920_영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> wordMap = new HashMap<>();
        Set<WordNote> wordSet = new HashSet<>();
        List<WordNote> wordList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {

//                WordNote wn = new WordNote(word);
//                int idx = wordList.indexOf(wn);
//
//                if (idx < 0) {
//                    wn.cnt++;
//                    wordList.add(wn);
//                } else {
//                    wordList.get(idx).cnt++;
//                }

                Integer cnt = wordMap.getOrDefault(word, 0);
                wordMap.put(word, cnt + 1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordMap.entrySet());
        Collections.sort(entryList, (o1, o2) -> {
                    if (o1.getValue() != o2.getValue()) return o2.getValue() - o1.getValue();
                    else if (o1.getKey().length() != o2.getKey().length()) return o2.getKey().length() - o1.getKey().length();
                    else return o1.getKey().compareTo(o2.getKey());
                }
        );

//        Collections.sort(wordList);

//        for (WordNote wordNote : wordList) {
//            bw.write(wordNote.word);
//            bw.newLine();
//        }

        for (Map.Entry<String, Integer> entry : entryList) {
            bw.write(entry.getKey());
            bw.newLine();
        }

        bw.flush();
    }

    static class WordNote implements Comparable<WordNote> {
        private String word;
        private int cnt;

        public WordNote(String word) {
            this.word = word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WordNote wordNote = (WordNote) o;
            return this.word.equals(wordNote.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

        @Override
        public int compareTo(WordNote o) {
            if (this.cnt != o.cnt) return o.cnt - this.cnt;
            else if (this.word.length() != o.word.length()) return o.word.length() - this.word.length();
            else return this.word.compareTo(o.word);
        }
    }
}
