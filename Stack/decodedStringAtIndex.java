package Stack;

public class decodedStringAtIndex {
    public static void main(String[] args) {
        decodedStringAtIndex solver = new decodedStringAtIndex();

        // Test Case 1
        String s1 = "leet2code3";
        int k1 = 10;
        System.out.println("Test 1: " + solver.decodeAtIndex(s1, k1)); // Expected: "o"

        // Test Case 2
        String s2 = "ha22";
        int k2 = 5;
        System.out.println("Test 2: " + solver.decodeAtIndex(s2, k2)); // Expected: "h"

        // Test Case 3
        String s3 = "a2345678999999999999999";
        int k3 = 1;
        System.out.println("Test 3: " + solver.decodeAtIndex(s3, k3)); // Expected: "a"
    }
    public String decodeAtIndex(String s, int k) {
        
        int n = s.length();

        long len = 0;
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) len *= ch - '0';
            else len++;
        }

        int idx = n - 1;
        while(idx >= 0){
            k = (int)(k % len);
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)) len = len / Integer.parseInt(String.valueOf(ch));
            else if (k != 0) len--;
            else {
                return String.valueOf(ch);
            }
            idx--;
        }

        return "";
    }
}
