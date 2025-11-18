import java.util.List;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizService service = new QuizService();

        System.out.println(" Welcome to the Java Quiz Game!");
        System.out.print("Enter number of questions: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<Question> questions = service.fetchQuestions(amount);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getQuestion());

            List<String> options = q.getAllOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((char)('A' + j) + ") " + options.get(j));
            }

            System.out.print("Your answer (A/B/C/D): ");
            String input = scanner.nextLine().trim().toUpperCase();

            int selectedIndex = input.charAt(0) - 'A';
            if (selectedIndex >= 0 && selectedIndex < options.size()) {
                String selectedAnswer = options.get(selectedIndex);
                if (selectedAnswer.equals(q.getCorrectAnswer())) {
                    System.out.println(" Correct!");
                    score++;
                } else {
                    System.out.println(" Wrong! Correct Answer: " + q.getCorrectAnswer());
                }
            } else {
                System.out.println(" Invalid choice.");
            }
        }

        System.out.println("\n🏁 Quiz Over! Your score: " + score + "/" + amount);
        scanner.close();
    }
}