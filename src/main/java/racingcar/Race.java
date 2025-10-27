package racingcar;

import java.util.List;
import org.assertj.core.util.Strings;
import racingcar.util.MovementDecider;

public class Race {

    private final MovementDecider movementDecider;

    private final static String POSITION_INDICATOR = "-";

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
        cars.stream()
            .filter(c -> movementDecider.shouldGoForward())
            .forEach(Car::goForward);

        printCurrentStatus();
    }

    private void printCurrentStatus() {
        for (Car car : cars) {
            String name = car.getName();
            int position = car.getPosition();

            System.out.println(name + " : " + POSITION_INDICATOR.repeat(position));
        }
    }

    public void printWinners() {
        List<Car> winners = getWinners();
        List<String> winnerNames = winners.stream()
                                          .map(Car::getName)
                                          .toList();

        System.out.println("최종 우승자 : " + Strings.join(winnerNames));
    }

    private List<Car> getWinners() {
        int maxPosition = cars.stream()
                              .mapToInt(Car::getPosition)
                              .max()
                              .orElseThrow();

        return cars.stream()
                   .filter(c -> c.getPosition() == maxPosition)
                   .toList();
    }
}
