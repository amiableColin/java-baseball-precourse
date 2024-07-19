package baseball;
import java.util.InputMismatchException;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static String generateCorrectAnswer() {
        String correctAnswer = Integer.toString(Randoms.pickNumberInRange(1, 10));
        String temp = "";
        while (true) {
            temp = Integer.toString(Randoms.pickNumberInRange(1, 10));
            if (!correctAnswer.contains(temp)) correctAnswer += temp;
            if (correctAnswer.length() == 3) break;
        }
        return correctAnswer;
    }
    public static void main(String[] args) {
        int restart = 0;

        while (restart != 2) {
            String correctAnswer = generateCorrectAnswer();
            System.out.println("생성된 숫자: " + correctAnswer); // 디버깅용

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String temp = Console.readLine();
                if (temp.chars().filter(c -> (0 <= c - '0' && c - '0' <= 9)).count() != 3) {
                    throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
                }

                ResultEvaluator result = new ResultEvaluator(correctAnswer, temp);
                System.out.println(result.getResult());
                if (result.getStrike() == 3) {
                    System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    try {
                        restart = Integer.parseInt(Console.readLine());
                        if (restart != 1 && restart != 2) {
                            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
                        }
                    }
                    catch (InputMismatchException e) {
                        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
                    }
                    break;
                }
            }
        }
    }
}
