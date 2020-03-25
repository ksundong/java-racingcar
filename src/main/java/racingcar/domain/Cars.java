package racingcar.domain;

import racingcar.policy.MovingPolicy;

import java.util.Collections;
import java.util.List;

public final class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void move(MovingPolicy movingPolicy) {
        for (Car car : cars) {
            car.move(movingPolicy);
        }
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(cars);
    }
}