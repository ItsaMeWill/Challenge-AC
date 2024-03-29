package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ricardo extends MCS {

    private Question question;
    private int correctAnswer;


    private Rectangle rectangle;

        public Ricardo(){
            super(new Picture(140,50, "resources/rsz_1player.png"),
                    new Rectangle(140,50,50,50));

        this.question = Question.QUESTION1;
        this.correctAnswer = 2;
        }



    public void makeQuestion() {

        super.makeQuestion((new Picture(10,10,"resources/9TEENBATTLE500.png")));
    }

    public Question getQuestion() {
        return question;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}



