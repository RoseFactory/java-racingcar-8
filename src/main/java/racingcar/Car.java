package racingcar;

public class Car {

    private String name;
    private int position = 0;

    public void goForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
