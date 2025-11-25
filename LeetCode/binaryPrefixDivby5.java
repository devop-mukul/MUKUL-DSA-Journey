package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class binaryPrefixDivby5 {
    public static void main(String[] args) {
        binaryPrefixDivby5 obj = new binaryPrefixDivby5();
        int nums[] = {0, 1, 1};
        System.out.println(obj.prefixesDivBy5(nums));
    }
    public List<Boolean> prefixesDivBy5(int[] nums) {
        /*multiply the old number by 2  
        then add the new digit (0 or 1) */
        List<Boolean> list = new ArrayList<>();
        int rem = 0;
        for(int bit : nums) {
            rem = ((rem << 1) + bit) % 5; //same as rem = (rem * 2 + nums[i]) % 5
            // if(rem == 0)
            //     list.add(true);
            // else
            //     list.add(false);

            list.add(rem == 0);
        }
        return list;
    }
}
