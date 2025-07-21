import java.util.List;

public class Question {
    private String question;
    private String correctAnswer;
    private List<String> allOptions;

    public Question(String question, String correctAnswer, List<String> allOptions) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.allOptions = allOptions;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getAllOptions() {
        return allOptions;
    }
}