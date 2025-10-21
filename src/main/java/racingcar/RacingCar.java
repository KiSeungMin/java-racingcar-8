package racingcar;

public class RacingCar {

    private Integer position;
    private final String name;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
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
}
