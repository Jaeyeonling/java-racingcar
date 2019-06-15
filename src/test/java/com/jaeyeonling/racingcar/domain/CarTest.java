package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final int DEFAULT_POSITION = 1;

    @DisplayName("이동 후 위치 변경 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 4, 35, 41, 23 })
    void move(final int moveCount) {
        // given
        final Car car = new Car();

        // when
        for (int i = 0; i < moveCount; i++) {
            car.moveForward();
        }

        // then
        assertThat(car.getPosition()).isEqualTo(moveCount + DEFAULT_POSITION);
    }
}