package Stack;
public class carFleet {

    public static void main(String[] args) {
    carFleet solver = new carFleet();

    // Example 1
    int target1 = 12;
    int[] position1 = {10, 8, 0, 5, 3};
    int[] speed1 = {2, 4, 1, 1, 3};
    System.out.println("fleets (expected 3): " + solver.carFleet1(target1, position1, speed1));

    // Example 2
    int target2 = 10;
    int[] position2 = {3};
    int[] speed2 = {3};
    System.out.println("fleets (expected 1): " + solver.carFleet1(target2, position2, speed2));

    // Example 3
    int target3 = 100;
    int[] position3 = {0, 2, 4, 6, 8};
    int[] speed3 = {5, 4, 3, 2, 1};
    System.out.println("fleets: " + solver.carFleet1(target3, position3, speed3));
}

    public int carFleet1(int target, int[] position, int[] speed) {
         int res = 0;
       double[] timeArr = new double[target];
       for (int i = 0; i < position.length; i++)
        {
            timeArr[position[i]]= (double)(target - position[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target-1; i >=0 ; i--)
        {
            double cur = timeArr[i];
            if (cur > prev)
            {
                prev = cur;
                res++;
            }
        }
        return res;   
    }
}
