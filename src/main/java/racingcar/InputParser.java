package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public ArrayList<String> getInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = readLine();

        ArrayList<String> names = new ArrayList<>(List.of(inputNames.split(",")));
        for (String name : names) {
            checkNameIsValid(name);
        }

        return names;
    }

    public Integer getRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수 입력은 숫자여야 합니다.");
        }
    }

    public void checkNameIsValid(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여아 합니다.");
        }
    }
}
