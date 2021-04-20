package com.akos;

import java.util.*;

class Answers {
    private List<String> answers = new ArrayList<>();
    private int indexOfCorrect;

    public List<String> getAnswers() {
        return answers;
    }

    public int getIndexOfCorrect() {
        return indexOfCorrect;
    }

    public void rightAnswer (String correct) {
        indexOfCorrect = answers.indexOf(correct);
    }

    public void addAnswer (String answer) {
        answers.add(answer);
    }

    public boolean isRight (String answer) {
        return answers.indexOf(answer) == indexOfCorrect;
    }
}

public class Questions {
    private String name;
    private Map<String, Answers> answers;

    public void fillQuestions(String question, Answers answers, String name) {
        this.name = name;
        this.answers.put(question, answers);
    }

    public String getName() {
        return name;
    }

    public Map<String, Answers> getAnswers() {
        return answers;
    }


    public void questionInput () {
        Scanner in = new Scanner(System.in);
        boolean isExit = false;
        int i = 1;

        while (!isExit) {
            Answers answers = new Answers();
            System.out.println("Provide the " + i + ". " + "Question");
            String question = in.nextLine();
            in.nextLine();
            String right = "";
            int j = 1;
            System.out.println("Provide name for the test");
            String name = in.nextLine();
            while (!isExit) {
                System.out.println("Provide answer no." + j);
                answers.addAnswer(in.nextLine());
                System.out.println("Is this the correct answer? 1 yes / 0 no");
                if (in.nextByte() == 1) {
                    right = answers.getAnswers().get(j-1);
                    answers.rightAnswer(right);
                }
                System.out.println("Want to add more answers? 1 yes / 0 no");
                isExit = in.nextByte() == 0;
                in.nextLine();
                j++;
            }
            fillQuestions(question,answers,name);
            i++;
            System.out.println("Want to put more questions? 1 yes / 0 no");
            isExit = in.nextByte() == 0;
        }

    }
}



