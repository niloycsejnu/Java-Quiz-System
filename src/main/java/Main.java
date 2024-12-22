import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("System:> Enter your username:");
        String username = scanner.nextLine();

        System.out.print("System:> Enter your password:");
        String password = scanner.nextLine();

        UserService userService = new UserService();
        String role = userService.validateUser(username, password);

        if (role == null) {
            System.out.println("Invalid username or password!");
        } else if (role.equals("admin")) {
            System.out.println("System:> Welcome admin! Please create new questions in the question bank.");
            Admin admin = new Admin();
            admin.addQuestions();
        } else if (role.equals("student")) {
            System.out.println("System:> Welcome to the quiz! We will throw you 10 questions.Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
            Student student = new Student();
            student.takeQuiz();
        }
    }
}
