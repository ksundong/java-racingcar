package autoracing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static autoracing.domain.CarTest.makeCars;
import static autoracing.domain.CarTest.makeCarsWithHistory;
import static autoracing.domain.CarTest.merge;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RacingGameTest {
    @Test
    public void shouldCreateCars() {
        List<Car> cars = makeCars("Mercedes", "Ferrari", "Lamborghini", "McLaren");
        int numberOfCars = cars.size();
        int totalRounds = 5;
        RacingRule rule = () -> true;

        RacingGame game = new RacingGame(totalRounds, cars);
        game.setRule(rule);

        assertThat(game).isNotNull()
                .extracting("totalRounds")
                .containsExactly(totalRounds);

        assertThat(game).extracting("participants")
                .flatExtracting((participants) -> (List<Car>) participants)
                .doesNotContainNull()
                .hasSize(numberOfCars)
                .filteredOn("rule", rule)
                .hasSize(numberOfCars);
    }

    @Test
    public void throwExceptionWhenBadArgumentWasPassedByConstructor() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingGame(0, Arrays.asList(new Car("Audi")));
        }).withMessage("total rounds must be greater than zero.");

        assertThatNullPointerException().isThrownBy(() -> {
            new RacingGame(1, null);
        }).withMessage("participants must not be null.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingGame(1, Collections.emptyList());
        }).withMessage("the number of participants must be greater than zero.");
    }

    @Test
    public void shouldReturnedParticipantsThatHasDrivenLongestDistance() {
        int totalRounds = 4;
        RacingRule mockRule = () -> false;
        List<Location> history4Distance = new ArrayList<>(Arrays.asList(
                Location.STARTING_LINE,
                new Location(1),
                new Location(2),
                new Location(3),
                new Location(4)
        ));
        List<Location> history3Distance = new ArrayList<>(Arrays.asList(
                Location.STARTING_LINE,
                new Location(1),
                new Location(2),
                new Location(3),
                new Location(3)
        ));

        List<Car> expectedWinners = makeCarsWithHistory(mockRule, history4Distance, "Winner1", "Winner2");
        List<Car> expectedLosers = makeCarsWithHistory(mockRule, history3Distance, "Loser1", "Loser1");

        RacingGame game = new RacingGame(totalRounds, merge(expectedWinners, expectedLosers));
        game.start();
        List<Car> winners = game.getWinners();

        assertThat(winners).containsAll(expectedWinners);
        assertThat(winners.stream().map(winner -> winner.getLocation(totalRounds)))
                .extracting("distance")
                .containsOnly(4);
    }
}