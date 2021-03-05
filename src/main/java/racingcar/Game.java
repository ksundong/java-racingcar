package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {

  private Random random;
  private List<Car> cars;

  public Game(Random random) {
    this.random = random;
  }

  public void initializeCars(int size) {
    List<Car> newCars = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      newCars.add(new Car());
    }

    this.cars = Collections.unmodifiableList(newCars);
  }

  public int getCarSize() {
    return cars.size();
  }

  public void moveCars(int rounds) {
    return;
  }

  public String getCarsStatus() {
    return "";
  }
}
