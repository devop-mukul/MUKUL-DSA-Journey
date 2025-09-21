package HashTable;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class wordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        wordLadder solver = new wordLadder();
        int length = solver.ladderLength(beginWord, endWord, wordList);

        System.out.println("Length of shortest transformation sequence: " + length);
    }

    public int ladderLength(String st, String tar, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(tar)) return 0; 

        Queue<AbstractMap.SimpleEntry<String, Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(st, 1));

        while (!q.isEmpty()) {
            String word = q.peek().getKey();
            int steps = q.peek().getValue();
            q.poll();

            if (word.equals(tar)) return steps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (dict.contains(newWord)) {
                        dict.remove(newWord);
                        q.add(new AbstractMap.SimpleEntry<>(newWord, steps + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}
