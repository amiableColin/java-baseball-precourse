package baseball;

public class ResultEvaluator {
    private final String correctAnswer;
    private final String userInput;
    private int strike;
    private int ball;
    public ResultEvaluator(String correctAnswer, String userInput) {
        this.correctAnswer = correctAnswer;
        this.userInput = userInput;
    }

    private void calculateStrikesAndBalls() {

        for (int i = 0; i < this.userInput.length(); i++) {
            if (correctAnswer.charAt(i) == this.userInput.charAt(i)) {
                this.strike++;
            }
            else if (correctAnswer.contains(String.valueOf(this.userInput.charAt(i)))) {
                this.ball++;
            }
        }
    }

    public String getResult() {
        this.calculateStrikesAndBalls();

        if (this.ball == 0 && this.strike == 0) {
            return "낫싱";
        }

        String result = "";
        if (this.ball != 0) {
            result += this.ball + "볼 ";
        }
        if (this.strike != 0) {
            result += this.strike + "스트라이크";
        }
        return result;
    }
    public int getStrike() {return strike;}
    public int getBall() {return ball;}
}
