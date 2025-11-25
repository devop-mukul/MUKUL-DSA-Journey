package LeetCode;

public class smallestIntegerDivByK {
    public int smallestRepunitDivByK(int k) {
        // int n = 1;
        // int count = 0;
        // while(count <= 1_00000) {
        //     if(n % k == 0) {
        //         return ((Integer.toString(n)).length());
        //     }
        //     n = n * 10 + 1;
        //     count++;
        // }
        // return -1;

        if(k % 2 == 0 || k % 5 == 0) return -1;

        int rem = 0;
        for(int len = 1; len <= k; len++) {
            rem = (rem * 10 + 1) % k;
            if(rem == 0) return len;
        }
        return -1;
    }
    public static void main(String[] arg) {
        smallestIntegerDivByK obj = new smallestIntegerDivByK();
        System.out.println(obj.smallestRepunitDivByK(7));
    }
}
