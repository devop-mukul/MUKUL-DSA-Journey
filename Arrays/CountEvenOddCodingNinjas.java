package Arrays;

import java.util.Arrays;

public class CountEvenOddCodingNinjas {
    public static void main(String[] args) {
        // int arr[] = {6, 5, 3, 2, 2};
        int arr[] = {2, 1, 2, 1, 5, 5, 2};
        System.out.println(Arrays.toString(countEvenOdd(arr,arr.length)));
    }
    public static int[] countEvenOdd(int[] arr, int n) {
        for(int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    swap = true;
                }
            }
            if(swap == false)   break;
        }
        int evenCount = 0, oddCount = 0, freq = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] == arr[i - 1]) {
                freq++;
            }
            else {
                if(freq % 2 == 0)   evenCount++;
                else    oddCount++;

                freq = 1;
            }
        }

        if(freq % 2 == 0)   evenCount++; // for handling last remaining element
        else    oddCount++;
        return new int[]{oddCount, evenCount};
    }
}
