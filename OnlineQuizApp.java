package quiz;

import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create question list
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"A) this", "B) super", "C) extends", "D) implement"},
                3
        ));
        questions.add(new Question(
                "What is the default value of an int in Java?",
                new String[]{"A) 0", "B) null", "C) undefined", "D) 1"},
                1
        ));
        questions.add(new Question(
                "Which method is the entry point of a Java program?",
                new String[]{"A) start()", "B) run()", "C) main()", "D) init()"},
                3
        ));

        int score = 0;

        //  Loop through questions
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);

            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer;
            try {
                answer = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Skipping question.");
                sc.nextLine();
                continue;
            }

            //  Check answer
            if (answer == q.correctOption) {
                System.out.println(" Correct!");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + q.correctOption);
            }
        }

        // 4. Display final score
        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println(" Excellent! Perfect score.");
        } else if (score >= questions.size() / 2) {
            System.out.println(" Good job! Keep practicing.");
        } else {
            System.out.println(" Needs improvement. Try again.");
        }

        sc.close();
    }
}

