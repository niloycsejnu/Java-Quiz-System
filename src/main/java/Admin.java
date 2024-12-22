import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Admin {
    private static final String QUIZ_FILE = "src/main/resources/quiz.json";

    public void addQuestions() {
        Scanner scanner = new Scanner(System.in);
        JSONArray quizData = readQuizData();

        while (true) {
            System.out.println("System:> Input your question:");
            String question = scanner.nextLine();

            System.out.println("System:> Input option 1:");
            String option1 = scanner.nextLine();

            System.out.println("System:> Input option 2:");
            String option2 = scanner.nextLine();

            System.out.println("System:> Input option 3:");
            String option3 = scanner.nextLine();

            System.out.println("System:> Input option 4:");
            String option4 = scanner.nextLine();

            System.out.println("System:> What is the answer key?");
            int answerKey = Integer.parseInt(scanner.nextLine());

            JSONObject questionObj = new JSONObject();
            questionObj.put("question", question);
            questionObj.put("option 1", option1);
            questionObj.put("option 2", option2);
            questionObj.put("option 3", option3);
            questionObj.put("option 4", option4);
            questionObj.put("answerkey", answerKey);

            quizData.put(questionObj);

            System.out.println("System:> Saved successfully! Do you want to add more questions? (press 's' to start and 'q' to quit)");
            String choice = scanner.nextLine();
            if (choice.equals("q")) break;
        }
        saveQuizData(quizData);
    }

    private JSONArray readQuizData() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(QUIZ_FILE)));
            return new JSONArray(content);
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    private void saveQuizData(JSONArray quizData) {
        try {
            Files.write(Paths.get(QUIZ_FILE), quizData.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
