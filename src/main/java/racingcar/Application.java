package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        List<String> names = inputParser.getInputNames();
        Integer round = inputParser.getRound();

        RacingManager racingManager = new RacingManager();
        racingManager.updateRacingCars(names);
        racingManager.updateTotalRounds(round);

        racingManager.playGame();
        racingManager.printWinners();
    }
}
