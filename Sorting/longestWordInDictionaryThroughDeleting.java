import java.util.Arrays;
import java.util.List;

public class longestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");
        longestWordInDictionaryThroughDeleting obj = new longestWordInDictionaryThroughDeleting();
        String result = obj.findLongestWord(s, dictionary);
        System.out.println("Longest word in dictionary through deleting: " + result);
    }
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() != b.length()) 
                return b.length() - a.length();
            return a.compareTo(b);
        });
        
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                return word;
            }
        }
        return "";
    }
    
    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}
