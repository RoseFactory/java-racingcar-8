package racingcar;

import java.util.List;
import racingcar.util.MovementDecider;

public class Race {

    private final MovementDecider movementDecider;

    private final int endTime;
    private int currentTime = 0;
    private final List<Car> cars;

    public Race(MovementDecider movementDecider, int endTime, List<Car> cars) {
        this.movementDecider = movementDecider;
        this.endTime = endTime;
        this.cars = cars;
    }

    public void play() {
        while (currentTime < endTime) {
            proceed();
            printCurrentStatus();

            currentTime++;
        }
    }

    private void proceed() {
        for(Car car : cars) {
            boolean canGoForward = movementDecider.shouldGoForward();

            if(canGoForward) {
                car.goForward();
            }
        }

        printCurrentStatus();
    }

    private void printCurrentStatus() {

    }

    public void printWinners() {

    }

    private List<Car> getWinners() {
        return null;
    }
}
