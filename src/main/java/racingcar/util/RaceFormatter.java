package racingcar.util;

import java.util.List;
import racingcar.Car;

public class RaceFormatter {

    private final String positionIndicator;

    public RaceFormatter(String positionIndicator) {
        this.positionIndicator = positionIndicator;
    }

    public String formatWinnerResult(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                      .map(Car::getName)
                      .toList();

        return "최종 우승자 : " + String.join(", ", winnerNames);
    }

    public String formatRaceStatus(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            String name = car.getName();
            int position = car.getPosition();

            sb.append(name + " : " + positionIndicator.repeat(position));
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
