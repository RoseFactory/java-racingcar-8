package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.InputConverter;
import racingcar.util.MovementDecider;
import racingcar.util.RaceFormatter;

public class Application {
    public static void main(String[] args) {
        String nameInput = Console.readLine();
        List<Car> carsInRace = InputConverter.parseCarNames(nameInput);
        String endTimeInput = Console.readLine();
        int endTime = InputConverter.parseEndTime(endTimeInput);

        MovementDecider movementDecider = new MovementDecider();
        RaceFormatter raceFormatter = new RaceFormatter("-");

        Race race = new Race(movementDecider, raceFormatter, endTime, carsInRace);
        race.play();

        System.out.println(raceFormatter.formatWinnerResult(race.getWinners()));
    }
}