package com.akos;

import java.util.*;

public class Questions {
    private List<String> questions = new ArrayList<>();
    private Map<String,Map<String,Boolean>> answers = new HashMap<>();

    public void fillQuestions(String question, List<String> answers, String right) {
        Map<String,Boolean> rightAnswer = new HashMap<>();
        questions.add(question);
        for (String answer : answers) {
            if (answer.equals(right)) {
                rightAnswer.put(answer, true);
            } else {
                rightAnswer.put(answer, false);
            }
        }
        this.answers.put(question,rightAnswer);
    }

}
class QuestionMain {

    public static void main(String[] args) {
        Questions questions = new Questions();
        Scanner in = new Scanner(System.in);
        boolean isExit = false;
        int i = 1;

        while (!isExit) {
            List<String> answers = new ArrayList<>();
            System.out.println("Provide the "+ i + ". " + "Question");
            String question = in.nextLine();
            in.nextLine();
            String right ="";
            int j = 0;
            while(!isExit) {
                System.out.println("Provide answer no." + (j+1));
                answers.add(in.nextLine());
                in.nextLine();
                System.out.println("Is this the correct answer? 1 yes / 0 no");
                if (in.nextByte() == 1) {
                    right = answers.get(j);
                }
                System.out.println("Want to add more answers? 1 yes / 0 no");
                isExit = in.nextByte() == 0;
                in.nextLine();
                j++;
            }
            questions.fillQuestions(question,answers,right);
            i++;
            System.out.println("Want to put more questions? 1 yes / 0 no");
            isExit = in.nextByte() == 0;
        }

    }
}
