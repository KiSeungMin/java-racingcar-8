package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputParser {

    private final Integer ROUND_LIMIT = Integer.MAX_VALUE;
    private final String NAME_EXCEPTION_MESSAGE = "자동차 이름의 길이는 1 이상, 5 이하여야 합니다.";
    private final String ROUND_EXCEPTION_MESSAGE = "라운드의 횟수는 0 ~ " + ROUND_LIMIT + " 사이의 정수이어야 합니다.";


    public List<String> getInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = readLine();

        List<String> names = List.of(inputNames.split(","));
        validateNames(names);

        return names;
    }

    public Integer getRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            Integer round = Integer.parseInt(readLine());
            checkRoundIsValid(round);

            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_EXCEPTION_MESSAGE);
        }
    }

    public void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
    }

    public void validateNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }

        for (String name : names) {
            validateName(name);
        }
    }

    public void checkRoundIsValid(Integer round) {
        if (round > ROUND_LIMIT || round < 0) {
            throw new IllegalArgumentException(ROUND_EXCEPTION_MESSAGE);
        }
    }
}
