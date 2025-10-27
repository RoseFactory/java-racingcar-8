package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.Car;

public class InputConverter {

    public static List<Car> parseCarNames() {
        String input = Console.readLine();

        List<String> nameList = Arrays.asList(input.split(","));
        return nameList.stream()
                       .map(Car::new)
                       .toList();
    }

    public static int getInt() {
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}