package racingcar;

import java.util.List;
import racingcar.util.InputConverter;
import racingcar.util.MovementDecider;

public class Application {
    public static void main(String[] args) {
        List<Car> carsInRace = InputConverter.parseCarNames();
        int endTime = InputConverter.getInt();

        MovementDecider movementDecider = new MovementDecider();

        Race race = new Race(movementDecider, endTime, carsInRace);
        race.play();

        race.printWinners();
    }
}