package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.Car;

public class InputConverter {

    public static List<Car> parseCarNames(String input) {
        List<String> nameList = Arrays.asList(input.split(","));

        nameList.stream()
            .filter(n -> n.length() > 5)
            .findAny()
            .ifPresent(n -> {
                throw new IllegalArgumentException();
            });

        return nameList.stream()
                       .map(Car::new)
                       .toList();
    }

    public static int parseEndTime(String input) {
        return Integer.parseInt(input);
    }
}