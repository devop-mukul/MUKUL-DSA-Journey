package StringMatching;

public class rotateString {
    public static void main(String[] args) {
        rotateString solver = new rotateString();
        System.out.println(solver.rotateString1("abcde", "cdeab")); // true
        System.out.println(solver.rotateString1("abcde", "abced")); // false
        System.out.println(solver.rotateString1("aa", "aa"));       // true
        System.out.println(solver.rotateString1("", ""));           // true
    }
    public boolean rotateString1(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
