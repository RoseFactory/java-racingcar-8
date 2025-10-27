package racingcar;

import java.util.List;
import racingcar.util.InputConverter;
import racingcar.util.MovementDecider;
import racingcar.util.RaceFormatter;

public class Application {
    public static void main(String[] args) {
        List<Car> carsInRace = InputConverter.parseCarNames();
        int endTime = InputConverter.getInt();

        MovementDecider movementDecider = new MovementDecider();
        RaceFormatter raceFormatter = new RaceFormatter("-");

        Race race = new Race(movementDecider, raceFormatter, endTime, carsInRace);
        race.play();

        System.out.println(raceFormatter.formatWinnerResult(race.getWinners()));
    }
}