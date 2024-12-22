import java.io.FileReader;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Student {

    private static final Scanner scanner = new Scanner(System.in);

    public void takeQuiz() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray quizArray = (JSONArray) parser.parse(new FileReader("src/main/resources/quiz.json"));

            do {
                System.out.println("Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start or 'q' to quit.");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("q")) {
                    System.out.println("Thank you for participating. Goodbye!");
                    break;
                } else if (!choice.equalsIgnoreCase("s")) {
                    System.out.println("Invalid input. Please press 's' to start or 'q' to quit.");
                    continue;
                }

                List<JSONObject> questions = new ArrayList<>();
                for (Object obj : quizArray) {
                    questions.add((JSONObject) obj);
                }

                Collections.shuffle(questions);

                int score = 0;
                for (int i = 0; i < 10; i++) {
                    JSONObject question = questions.get(i % questions.size());

                    System.out.println("[Question " + (i + 1) + "] " + question.get("question"));
                    System.out.println("1. " + question.get("option 1"));
                    System.out.println("2. " + question.get("option 2"));
                    System.out.println("3. " + question.get("option 3"));
                    System.out.println("4. " + question.get("option 4"));

                    System.out.print("Your answer: ");
                    String answer = scanner.nextLine();

                    try {
                        int answerKey = Integer.parseInt(answer);
                        if (answerKey == ((Long) question.get("answerkey")).intValue()) {
                            score++;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid answer. Moving to the next question.");
                    }
                }

                System.out.println("\nQuiz finished! Your score: " + score + "/10");

                if (score >= 8) {
                    System.out.println("Excellent! You have got " + score + " out of 10.");
                } else if (score >= 5) {
                    System.out.println("Good. You have got " + score + " out of 10.");
                } else if (score >= 2) {
                    System.out.println("Very poor! You have got " + score + " out of 10.");
                } else {
                    System.out.println("Very sorry you are failed. You have got " + score + " out of 10.");
                }

                System.out.println("Would you like to start again? Press 's' for start or 'q' to quit.");
                choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("q")) {
                    System.out.println("Thank you for participating. Goodbye!");
                    break;
                }

            } while (true);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
