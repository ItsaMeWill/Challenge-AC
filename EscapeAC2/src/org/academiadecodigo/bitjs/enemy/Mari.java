package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mari extends MCS {

    private Question question;
    private String correctAnswer;


    public Mari() {
        super(new Picture(80, 80, "resources/player.png"), new Rectangle(80, 80, 50, 50));
        this.question = Question.QUESTION4;
        this.correctAnswer = Question.QUESTION4.getAnswer1();

    }

    public void makeQuestion(Question question) {
        super.makeQuestion(new Picture(10, 10, "resources/9teenbattle.png"));
    }
}


