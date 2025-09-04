package Arrays;

public class FirstMissingPositive {
    public static void main(String arg[]) {
        int arr[] = {3, 2, -6, 1, 0};
        System.out.println(firstMissing(arr, arr.length));
    }
    public static int firstMissing(int[] arr, int n) {
        int i = 0;
        while(i < n) {
            if(arr[i] > 0 && arr[i] <= n && (arr[i] != arr[arr[i] - 1])) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
            else
                i++;
        }
        for(int j = 0; j < n; j++) {
            if(arr[j] != j + 1)
                return j + 1; //return missing element
        }
        return n + 1;//every element is at its right place 
	}
}
