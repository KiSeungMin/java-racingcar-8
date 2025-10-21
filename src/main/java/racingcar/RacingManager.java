package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RacingManager {
    private ArrayList<RacingCar> racingCars;
    private Integer totalRounds;
    private Integer currentRound;
    private final Integer RANDOM_VALUE_LOWER_BOUND = 4;

    public RacingManager() {
        this.racingCars = new ArrayList<>();
        this.totalRounds = 0;
        this.currentRound = 0;
    }

    public void updateRacingCars(ArrayList<String> carNames) {
        racingCars.clear();
        for (String name : carNames) {
            RacingCar racingCar = new RacingCar(name);
            racingCars.add(racingCar);
        }
    }

    public void updateTotalRounds(Integer totalRounds) {
        this.totalRounds = totalRounds;
    }

    public void playGame() {
        System.out.println("실행 결과");
        while (currentRound <= totalRounds) {
            playRound();
            currentRound += 1;
        }
    }

    public void playRound() {
        moveAllCars();
        printAllCarPositions();
    }

    public void moveAllCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.updateRandomValue();
            racingCar.moveIfRandomValueMoreThan(RANDOM_VALUE_LOWER_BOUND);
        }
    }

    public void printAllCarPositions() {
        for (RacingCar racingCar : racingCars) {
            racingCar.printCurrentPosition();
        }
        System.out.println();
    }

    public void printWinners() {

    }
}
