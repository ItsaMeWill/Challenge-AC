package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Jojo extends MCS{

    private Question question;
    private int correctAnswer;


    public Jojo(){
        super(new Picture(80,80, "resources/player.png"), new Rectangle(80,80,50,50));

        this.correctAnswer =3;

    }

    public void makeQuestion(Question question) {
        super.makeQuestion(
                new Picture(10,10,"resources/9teenbattle.png"));
    }

    public Question getQuestion() {
        return question;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

