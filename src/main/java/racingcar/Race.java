package racingcar;

import java.util.List;
import racingcar.util.MovementDecider;
import racingcar.util.RaceFormatter;

public class Race {

    private final MovementDecider movementDecider;
    private final RaceFormatter raceFormatter;

    private final int endTime;
    private int currentTime = 0;
    private final List<Car> cars;

    public Race(MovementDecider movementDecider, RaceFormatter raceFormatter, int endTime, List<Car> cars) {
        this.movementDecider = movementDecider;
        this.raceFormatter = raceFormatter;
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

        // 이벤트 버스를 이용하면 side-effect를 완전히 없앨 수 있으나, 복잡성 증가로 구현 x
        raceFormatter.formatRaceStatus(cars);
    }

    // Race 내부적으로만 사용하고, 단순 출력이기에 테스트할 필요가 없다고 판단하여 직접 출력
    private void printCurrentStatus() {
        System.out.println(raceFormatter.formatRaceStatus(cars));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                              .mapToInt(Car::getPosition)
                              .max()
                              .orElseThrow();

        return cars.stream()
                   .filter(c -> c.getPosition() == maxPosition)
                   .toList();
    }
}
