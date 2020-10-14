package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ricardo extends MCS {

    private Question question;
    private String correctAnswer;
    private Question questions;
    private Rectangle rectangle;

        public Ricardo(){
            super(new Picture(80,80, "resources/rsz_1player.png"),
                    new Rectangle(80,80,50,50));

        this.question = Question.QUESTION1;
        this.correctAnswer = Question.QUESTION1.getAnswer2();
        }


    public void makeQuestion(Question question) {
        super.makeQuestion(question,new Text(100, 100, question.getAnswer1()),new Text(100, 200, question.getAnswer2()),new Text(100, 300, question.getAnswer1()));
    }

    public Question getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}



