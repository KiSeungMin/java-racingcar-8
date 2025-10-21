package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private List<RacingCar> racingCars;
    private Integer totalRounds;
    private Integer currentRound;
    private final Integer RANDOM_VALUE_LOWER_BOUND = 4;

    public RacingManager() {
        this.racingCars = new ArrayList<>();
        this.totalRounds = 0;
        this.currentRound = 0;
    }

    public void updateRacingCars(List<String> carNames) {
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
        while (currentRound < totalRounds) {
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

    public List<RacingCar> getWinners() {
        racingCars.sort((r1, r2) -> r2.getPosition() - r1.getPosition());
        int maxPosition = racingCars.getFirst().getPosition();

        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public void printWinners() {
        List<RacingCar> winners = getWinners();
        String message = "최종 우승자 : ";

        for (RacingCar winner : winners) {
            message = message.concat(winner.getName() + ", ");
        }

        System.out.println(message.substring(0, message.length() - 2));
    }

}
