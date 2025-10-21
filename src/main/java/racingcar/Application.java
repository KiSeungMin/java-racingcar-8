package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        ArrayList<String> names = inputParser.getInputNames();
        Integer round = inputParser.getRound();

        System.out.println("names: " + names);
        System.out.println("round: " + round);
    }
}
