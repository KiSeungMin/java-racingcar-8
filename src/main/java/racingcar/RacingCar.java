package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private Integer position;
    private final String name;
    private Integer randomValue;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
        this.randomValue = 0;
    }

    public RacingCar(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public void addPosition() {
        this.position += 1;
    }

    public void addPosition(Integer amount) {
        this.position += amount;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void printCurrentPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public void updateRandomValue() {
        this.randomValue = Randoms.pickNumberInRange(0, 9);
    }

    public void moveIfRandomValueMoreThan(Integer lowerBound) {
        if (randomValue > lowerBound) {
            this.addPosition(1);
        }
    }
}
