package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementDecider {

    public boolean shouldGoForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
