import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class QuizGameGUI extends JFrame {
    private QuizService service;
    private List<Question> questions;
    private int currentIndex = 0;
    private int score = 0;

    private JLabel questionLabel;
    private JButton[] optionButtons;

    public QuizGameGUI(int amount) {
        service = new QuizService();
        questions = service.fetchQuestions(amount);

        setTitle("Quiz Game");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(2, 2));
        optionButtons = new JButton[4];

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JButton();
            optionsPanel.add(optionButtons[i]);
            int finalI = i;
            optionButtons[i].addActionListener(e -> handleAnswer(finalI));
        }

        add(optionsPanel, BorderLayout.CENTER);

        displayQuestion();
    }

    private void displayQuestion() {
        if (currentIndex >= questions.size()) {
            JOptionPane.showMessageDialog(this, "Quiz Over! Your score: " + score);
            System.exit(0);
        }

        Question q = questions.get(currentIndex);
        questionLabel.setText("<html>" + q.getQuestion() + "</html>");
        List<String> options = q.getAllOptions();

        for (int i = 0; i < options.size(); i++) {
            optionButtons[i].setText(options.get(i));
        }
    }

    private void handleAnswer(int index) {
        Question q = questions.get(currentIndex);
        if (q.getAllOptions().get(index).equals(q.getCorrectAnswer())) {
            score++;
        }
        currentIndex++;
        displayQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizGameGUI gui = new QuizGameGUI(5);
            gui.setVisible(true);
        });
    }
}