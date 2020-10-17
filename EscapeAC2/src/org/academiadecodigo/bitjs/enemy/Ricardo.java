package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ricardo extends MCS {

    private Question question;
    private String correctAnswer;


    public Ricardo() {
        super(new Picture(80, 80, "resources/rsz_1player.png"),
                new Rectangle(80, 80, 50, 50));
        this.question = Question.QUESTION1;
        this.correctAnswer = Question.QUESTION1.getAnswer2();
    }


    public void makeQuestion(Question question) {
        super.makeQuestion(new Picture(10, 10, "resources/9teenbattle.png"));
    }

    public Question getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}



