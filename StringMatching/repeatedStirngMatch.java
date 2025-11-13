package StringMatching;

public class repeatedStirngMatch {
    public static void main(String[] args) {
    repeatedStirngMatch solver = new repeatedStirngMatch();

    System.out.println(solver.repeatedStringMatch("abcd", "cdabcdab")); // expected 3
    System.out.println(solver.repeatedStringMatch("aa", "a")); // expected 1
    System.out.println(solver.repeatedStringMatch("abc", "wxyz")); // expected -1
}
    public int repeatedStringMatch(String a, String b) {
        String temp = a;
        int repeat = 1;

        while (temp.length() < b.length()) {
            temp += a;
            repeat++;
        }

   
        if (temp.contains(b)) return repeat;
        if ((temp + a).contains(b)) return repeat + 1;

        return -1;
    }
}
