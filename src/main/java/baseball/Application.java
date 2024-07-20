package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;

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
        try {
            restart = Integer.parseInt(Console.readLine());
            if (restart != 1 && restart != 2) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
            }
        }
        catch (InputMismatchException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
        return restart == 1;
    }
}
