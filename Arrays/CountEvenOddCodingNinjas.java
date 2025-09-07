package Arrays;

import java.util.Arrays;

public class CountEvenOddCodingNinjas {
    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 2};
        System.out.println(Arrays.toString(countEvenOdd(arr,arr.length)));
    }
    public static int[] countEvenOdd(int[] arr, int n) {
        int evenCount = 0, oddCount = 0;
        Arrays.sort(arr);  // sort so duplicates are adjacent

        for (int i = 0; i < n; i++) {
            // count only if it's the first element OR different from the previous one
            if (i == 0 || arr[i] != arr[i - 1]) {
                if (arr[i] % 2 == 0)
                    evenCount++;
                else
                    oddCount++;
            }
        }

        return new int[]{oddCount, evenCount};
    }
}
