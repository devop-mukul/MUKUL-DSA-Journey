package Arrays;

public class Equilibrium_Index {
    public static void main(String []arg) {
        int arr[] = {2, -1, 1, 1};
        System.out.println(arrayEquilibriumIndex(arr));
    }
    public static int arrayEquilibriumIndex(int[] arr){  
		int n = arr.length, right_Sum = 0, left_Sum = 0;
		for(int i = 0; i < n; i++) {
			right_Sum += arr[i];
		}
		for(int i = 0; i < n; i++) {
			if(left_Sum == (right_Sum - left_Sum - arr[i]))
				return i;
			left_Sum += arr[i];
		}
		return -1;
	}
}
