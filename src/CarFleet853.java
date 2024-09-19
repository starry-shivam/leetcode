import utils.ExecDuration;

import java.util.Arrays;
import java.util.Comparator;

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

    private static class Car {
        int remainingDistance;
        double timeToArrive;

        public Car(int remainingDistance, double timeToArrive) {
            this.remainingDistance = remainingDistance;
            this.timeToArrive = timeToArrive;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            double duration = (double) (target - position[i]) / speed[i];
            cars[i] = new Car(target - position[i], duration);
        }

        Arrays.sort(cars, Comparator.comparingInt(a -> a.remainingDistance));
        int fleets = 0;
        double lastArrivalTime = 0;

        for (Car car : cars) {
            if (car.timeToArrive > lastArrivalTime) {
                lastArrivalTime = car.timeToArrive;
                fleets++;
            }
        }
        return fleets;
    }
}
