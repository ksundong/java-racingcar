package study.racingcar;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String racingParticipantByName = inputView.inputRacingParticipantByName();
        int tryNo = inputView.inputTryNo();

        RacingContest racingContest = new RacingContest(racingParticipantByName, tryNo);

        while (racingContest.isPlaying()) {
            racingContest.play();
            RacingResult racingResult = racingContest.gerResult();
            outputView.printRacingResult(racingResult);
        }
        List<Car> winners = racingContest.findWinners();
        outputView.printWinner(winners);

    }
}