package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.InputMismatchException;

public class Game {

    private String correctAnswer;

    private boolean isGameOver = false;

    public void play() {
        String correctAnswer = generateCorrectAnswer();
        System.out.println("생성된 숫자: " + correctAnswer); // 디버깅용

        while (!isGameOver) {
            AnswerPrompter prompter = new AnswerPrompter();
            ResultEvaluator result = new ResultEvaluator(correctAnswer, prompter.getAnswer());

            System.out.println(result.getResult());

            if (result.getStrike() == 3) {
                endGame();
                return;
            }
        }
    }

    private String generateCorrectAnswer() {
        String correctAnswer = "";

        while (correctAnswer.length() < 3) {
            String temp = Integer.toString(Randoms.pickNumberInRange(1, 10));
            if (!correctAnswer.contains(temp)) correctAnswer += temp;
        }

        return correctAnswer;
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
        this.isGameOver = true;
    }

}
