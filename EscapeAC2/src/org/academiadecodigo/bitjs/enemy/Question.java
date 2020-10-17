package org.academiadecodigo.bitjs.enemy;

public enum Question {



    QUESTION1(" How much variable types exist in Java ", "1) 3 types. Int, Boolean, String ",
    "2 types, primitives and reference types","Infinite"),
    QUESTION2(" What's JVM ? ", "An Interpreter", "A text editor","A compiler"),
    QUESTION3("An interface : ","make websites prettier",
            "defines the attributes a class must implement",
            "defines the behaviours a class must implement"),
    QUESTION4("NullPointerException means :","Calling the instance method of a null object",
            " class","Calling a null file");


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
