package org.academiadecodigo.bitjs.enemy;

public enum Question {


    QUESTION1(" Quantos tipos de variáveis existem em JAVA? ", "1) 3 tipos. Int, Boolean, String. ",
            "2) 2 tipos. Referência e primitivos","3) Infinitos"),
    QUESTION2(" O que é a JVM ? ", "", "asdas","asda");


    private String question;
    private String answer1;
    private String answer2;
    private String answer3;

    Question(String question, String answer1, String answer2, String answer3){

        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;

    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
