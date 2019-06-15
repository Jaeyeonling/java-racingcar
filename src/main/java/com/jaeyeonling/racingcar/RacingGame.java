package com.jaeyeonling.racingcar;

public class RacingGame {

    private final Car[] participants;
    private final MoveStrategy moveStrategy;
    private final int movingCount;

    private int movedCount;

    public RacingGame(final RacingGameOption option) {
        this.participants = option.getParticipants();
        this.moveStrategy = option.getMoveStrategy();
        this.movingCount = option.getMovingCount();
    }

    public void move() {
        if (isComplete()) {
            throw new IllegalStateException("이미 결과가 나온 게임입니다.");
        }

        moveAllCar();
        movedCount++;
    }

    public boolean isComplete() {
        return movedCount == movingCount;
    }

    public RacingGameStatus getStatus() {
        return new RacingGameStatus(this);
    }

    Car[] getParticipants() {
        return participants;
    }

    private void moveAllCar() {
        for (final Car car : participants) {
            moveCar(car);
        }
    }

    private void moveCar(final Car car) {
        if (moveStrategy.isMove()) {
            car.moveForward();
        }
    }
}