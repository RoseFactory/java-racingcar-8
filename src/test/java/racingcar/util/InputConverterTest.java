package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class InputConverterTest {

    @Test
    void 정상_차이름() {
        // given
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<Car> cars = InputConverter.parseCarNames();

        // then
        List<String> carNames = cars.stream()
                                    .map(Car::getName)
                                    .toList();
        assertThat(carNames).containsAll(List.of("pobi", "woni", "jun"));
    }

    @Test
    void 다섯글자_초과_차이름_예외_발생() {
        // given
        String input = "pobi,javajigi";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        assertThatThrownBy(InputConverter::parseCarNames)
            .isInstanceOf(IllegalArgumentException.class);
    }
}