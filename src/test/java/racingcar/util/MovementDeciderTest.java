package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

class MovementDeciderTest {

    @Test
    void 전진확률_약_60_퍼센트() {
        // given
        MovementDecider movementDecider = new MovementDecider();

        // when
        int forwardCount = 0;
        for (int i = 0; i < 1000; i++) {
            boolean canGoForward = movementDecider.shouldGoForward();
            if(canGoForward) forwardCount++;
        }

        // then
        assertThat(forwardCount).isCloseTo(600, Percentage.withPercentage(5));
    }
}