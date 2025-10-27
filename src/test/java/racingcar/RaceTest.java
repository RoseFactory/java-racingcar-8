package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.MovementDecider;
import racingcar.util.RaceFormatter;

class RaceTest {

    @Test
    void 가장_많이_진행한_Car가_winner() {
        // given
        Car winner1 = getCarWithPosition("winner 1", 5);
        Car winner2 = getCarWithPosition("winner 2", 5);
        Car loser = getCarWithPosition("loser", 3);
        Race race = new Race(new MovementDecider(), new RaceFormatter("-"), 0, List.of(winner1, winner2, loser));

        // when
        List<Car> winners = race.getWinners();

        // then
        assertThat(winners).containsAll(List.of(winner1, winner2));
    }

    private Car getCarWithPosition(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.goForward();
        }

        return car;
    }
}