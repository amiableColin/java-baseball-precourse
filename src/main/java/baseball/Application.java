package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        while (true) {
            Game game = new Game();
            game.play();
            if (!isRestart()) return;
        }
    }

    private static boolean isRestart() {
        int restart = 0;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String temp = Console.readLine();
        validateIsIntegers(temp);

        restart = Integer.parseInt(temp);
        validateOneOrTwo(restart);

        return restart == 1;
    }

    private static void validateIsIntegers(String temp) {
        if (temp.chars().filter(c -> (0 <= c - '0' && c - '0' <= 9)).count() < 1) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    private static void validateOneOrTwo(int restart) {
        if (restart != 1 && restart != 2) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }
}
