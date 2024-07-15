package baseball;
import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        char[] user_input;
        int restart = 0;
        while (restart != 2) {
            String correctAnswer = Integer.toString(r.nextInt(10));
            String temp = "";
            while (true) {
                temp = Integer.toString(r.nextInt(10));
                if (!correctAnswer.contains(temp)) correctAnswer += temp;
                if (correctAnswer.length() == 3) break;
            }
            System.out.println("생성된 숫자: " + correctAnswer); // 디버깅용

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                temp = s.next();
                if (temp.chars().filter(c -> (0 <= c - '0' && c - '0' <= 9)).count() != 3) {
                    throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
                }
                user_input = temp.toCharArray();
                int strike = 0;
                int ball = 0;
                // 스트라이크 찾는 로직
                for (int i = 0; i < user_input.length; i++) {
                    if (correctAnswer.indexOf(user_input[i]) == i) {
                        strike++;
                    }
                    else if (correctAnswer.indexOf(user_input[i]) != -1) {
                        ball++;
                    }
                }
                if (ball != 0 || strike != 0) {
                    if (ball != 0) {
                        System.out.print(ball + "볼 ");
                    }
                    if (strike != 0) {
                        System.out.print(strike + "스트라이크");
                    }
                }
                else {
                    System.out.print("낫싱");
                }
                System.out.println();

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    restart = s.nextInt();
                    break;
                }
            }
        }
        s.close();
    }
}
