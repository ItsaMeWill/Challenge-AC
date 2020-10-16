package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ricardo extends MCS {

    private Question question;
    private int correctAnswer;

    private Rectangle rectangle;

        public Ricardo(){
            super(new Picture(150,80, "resources/rsz_1player.png"),
                    new Rectangle(150,80,50,50));

        this.question = Question.QUESTION1;
        this.correctAnswer = 2;
        }


    public void makeQuestion(Question question) {
        super.makeQuestion(question,new Text(100, 100, question.getAnswer1()),
                new Text(100, 200, question.getAnswer2()),new Text(100, 300, question.getAnswer1()),new Picture(10,10,"resources/9teenbattle.png"));
    }

    public Question getQuestion() {
        return question;
    }

    public int getCorrectAnswer() {
        return 2;
    }
}



