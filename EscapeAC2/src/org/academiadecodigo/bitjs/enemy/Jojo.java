package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Jojo extends MCS{

    private Question question;
    private String correctAnswer;


    public Jojo(){
        super(new Picture(80,80, "resources/player.png"), new Rectangle(80,80,50,50));
        this.question = Question.QUESTION3;
        this.correctAnswer = Question.QUESTION3.getAnswer2();

    }

    public void makeQuestion(Question question) {
        super.makeQuestion(
                new Picture(10,10,"resources/9teenbattle.png"));
    }

    public Question getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

