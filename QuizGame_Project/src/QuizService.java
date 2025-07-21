import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class QuizService {

    public List<Question> fetchQuestions(int amount) {
        List<Question> questionList = new ArrayList<>();
        String apiUrl = "https://opentdb.com/api.php?amount=" + amount + "&type=multiple";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            JSONParser parser = new JSONParser();
            JSONObject response = (JSONObject) parser.parse(new InputStreamReader(conn.getInputStream()));
            JSONArray results = (JSONArray) response.get("results");

            for (Object obj : results) {
                JSONObject questionObj = (JSONObject) obj;
                String questionText = htmlDecode((String) questionObj.get("question"));
                String correctAnswer = htmlDecode((String) questionObj.get("correct_answer"));

                JSONArray incorrectArray = (JSONArray) questionObj.get("incorrect_answers");
                List<String> options = new ArrayList<>();
                for (Object o : incorrectArray) {
                    options.add(htmlDecode(o.toString()));
                }
                options.add(correctAnswer);
                Collections.shuffle(options);

                questionList.add(new Question(questionText, correctAnswer, options));
            }

        } catch (Exception e) {
            System.out.println("Error fetching questions: " + e.getMessage());
        }

        return questionList;
    }

    private String htmlDecode(String input) {
        return input.replace("&quot;", """)
                    .replace("&#039;", "'")
                    .replace("&amp;", "&")
                    .replace("&lt;", "<")
                    .replace("&gt;", ">");
    }
}