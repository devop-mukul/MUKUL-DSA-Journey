package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        List<int[]> pairs = pairSum(arr, 5);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == s) {
                    if(arr[i] > arr[j])
                        result.add(new int[]{arr[j], arr[i]});    
                    else
                        result.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        result.sort((a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            else {
                return Integer.compare(a[1], b[1]);
            }
        });
        return result;
    }
}
