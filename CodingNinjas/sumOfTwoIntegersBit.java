package CodingNinjas;

import java.util.Scanner;

public class sumOfTwoIntegersBit {
    public static void main(String[] args) {
        System.out.println("enter two numbers:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(getSum(a, b));
    }
    public static int getSum(int a, int b) {
        while(b != 0) {
            int temp = (a & b);
            a = a ^ b;
            b = temp << 1;
        }
        return a;
    }
}
