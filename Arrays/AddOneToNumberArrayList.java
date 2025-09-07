package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumberArrayList {
    public static void main(String arg[]) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(9, 9));
        System.out.println(addOneToNumber(arr));
    }

    public static ArrayList<Integer> addOneToNumber(ArrayList<Integer> arr) {
        // remove leading zeroes
        while (!arr.isEmpty() && arr.get(0) == 0) 
            arr.remove(0);

        int n = arr.size();
        int carry = 1; // since we want to add one

        for (int i = n - 1; i >= 0; i--) {
            int sum = arr.get(i) + carry;
            if (sum < 10) {
                arr.set(i, sum);
                return arr;
            } else {
                arr.set(i, 0);
                carry = 1;
            }
        }

        // if still carry left
        if (carry == 1)
            arr.add(0, 1);

        return arr;
    }
}
