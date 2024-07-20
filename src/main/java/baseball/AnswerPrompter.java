package baseball;

import camp.nextstep.edu.missionutils.Console;

public class AnswerPrompter {

    private String answer;

    public AnswerPrompter() {
        this.answer = promptAnswer();
        validateInput();
    }

    private static String promptAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String prompt = Console.readLine();
        return prompt;
    }

    private void validateInput() {
        if (this.answer.chars().filter(c -> (0 <= c - '0' && c - '0' <= 9)).count() != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public String getAnswer() {return answer;}
}
