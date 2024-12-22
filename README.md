# Quiz Management System On Java

## Description
This is a software system designed to manage quizzes effectively. It provides functionalities for admins to create and manage a quiz bank with multiple-choice questions (MCQs) and for students to take quizzes from the bank. The system supports role-based login, with distinct functionalities for admin and student users.

### Features:
- Admins can add multiple MCQs with four options and their answer keys to a `quiz.json` file.
- Students can log in to take a 10-question MCQ quiz randomly generated from the quiz bank.
- Results are provided based on student performance, with feedback messages.

---

## Tools
- **IDE**: IntelliJ IDEA
- **Build Tool**: Gradle

---

## How to Run

1. **Setup Project**:
   - Clone the repository and open it in IntelliJ IDEA.
   - Ensure Gradle is properly configured and dependencies are resolved.

2. **Prepare Resources**:
   - Create a `users.json` file in the `src/resources/` directory with admin and student credentials:
     ```json
     [
       {
         "username": "admin",
         "password": "1234",
         "role": "admin"
       },
       {
         "username": "niloy",
         "password": "1234",
         "role": "student"
       }
     ]
     ```
   - Create a `quiz.json` file in the same directory with initial questions:
     ```json
     [
       {
         "question": "Which is not part of system testing?",
         "option 1": "Regression Testing",
         "option 2": "Sanity Testing",
         "option 3": "Load Testing",
         "option 4": "Unit Testing",
         "answerkey": 4
       }
     ]
     ```

3. **Run the Application**:
   - Execute the main class.
   - Login with appropriate credentials:
     - Admin: `username: admin`, `password: 1234`
     - Student: `username: niloy`, `password: 1234`

4. **Admin Role**:
   - Admins can add multiple questions to the quiz bank by providing questions, options, and answer keys.

5. **Student Role**:
   - Students can start a quiz consisting of 10 random questions. Scores are calculated based on correct answers.

---

## Output Examples

### Admin Login
```plaintext
System:> Enter your username
User:> admin
System:> Enter password
User:> 1234
System:> Welcome admin! Please create new questions in the question bank.
```

### Student Login
```plaintext
System:> Enter your username
User:> salman
System:> Enter password
User:> 1234
System:> Welcome niloy to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.
```

### Quiz Output
```plaintext
[Question 1] Which is not part of system testing?
1. Regression Testing
2. Sanity Testing
3. Load Testing
4. Unit Testing
Student:> 4

[Question 2] Which is whitebox testing technique?
1. Equivalent Partitioning
2. Boundary value testing
3. Decision table testing
4. Adhoc Testing
Student:> 3

Quiz finished! Your score: 8/10
Excellent! You have got 8 out of 10.
Would you like to start again? Press 's' for start or 'q' for quit.
```

---

## Video Section
A demonstration video for better understanding:
[Click here to watch the video](https://drive.google.com/file/d/1U2fotQTcmuZitHUgO2nnGj90F2JkHr6Q/view?usp=sharing)
---

## Contact
For any questions or issues, feel free to open an issue in the repository or contact me via [GitHub](https://github.com/niloycsejnu) or [Email](niloydatta0011@gmail.com)

