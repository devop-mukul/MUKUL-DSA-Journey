class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "is2 sentence4 This1 a3";
        String sorted = sol.sortSentence(input);
        System.out.println("Sorted sentence: " + sorted);
    }
    public String sortSentence(String s) {
        
        String[] words = s.split(" ");
        String[] ans = new String[words.length];
        for (String c: words){
            ans[(int)(c.charAt(c.length() - 1) - '1')] = c.substring(0, c.length() - 1);
        }
        return String.join(" ", ans);
    }
}