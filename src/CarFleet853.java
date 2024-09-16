import utils.ExecDuration;

import java.util.Stack;

public class CarFleet853 {

    public static void main(String[] args) {
        CarFleet853 obj = new CarFleet853();
        int target = 12;
        int[] position = new int[]{10, 8, 0, 5, 3};
        int[] speed = new int[]{2, 4, 1, 1, 3};
        // Output: 3
        System.out.println(obj.carFleet(target, position, speed));
        ExecDuration.measure(() -> obj.carFleet(target, position, speed));
    }

    public int carFleet(int target, int[] position, int[] speed) {

    }
}
