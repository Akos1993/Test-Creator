package com.akos;

import java.util.*;

public class Questions {
    private List<String> questions = new ArrayList<>();
    private Map<String,Map<String,Boolean>> answers;

    public void fillQuestions(String question, List<String> answers, String right) {
        Map<String,Boolean> rightAnswer = new HashMap<>();
        questions.add(question);
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).equals(right)) {
                rightAnswer.put(answers.get(i),true);
            }else{
                rightAnswer.put(answers.get(i),false);
            }
        }
        this.answers.put(question,rightAnswer);
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public void setAnswers(Map<String, Map<String, Boolean>> answers) {
        this.answers = answers;
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
            System.out.println("Provide the "+ i + "Question");
            String question = in.nextLine();
            in.nextLine();
            String right ="";
            int j = 0;
            while(!isExit) {
                System.out.println("Provide the answers");
                answers.add(in.nextLine());
                in.nextLine();
                System.out.println("Is this the correct answer? 1 yes / 0 no");
                if (in.nextByte() == 1) {
                    right = answers.get(j);
                }
                System.out.println("Want to add more answers?");
                isExit = in.nextByte() == 1;
                in.nextLine();
                j++;
            }
            questions.fillQuestions(question,answers,right);
            i++;
            System.out.println("Want to put more questions?");
            isExit = in.nextByte() == 1;
        }

    }
}
