package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

abstract public class MCS {

    private Picture face;
    private Rectangle rectangle;
    private Question question;

    public MCS(Picture face, Rectangle rectangle){
        this.face = face;
        this.rectangle = rectangle;
    }

    public void makeQuestion(Question question, Question correct) {

        //create the question screen and write the question

        Rectangle questionScreen = new Rectangle(10, 10, 500, 500);
        questionScreen.fill();
        Text questionMc = new Text(10, 10, question.getQuestion());
        questionMc.setColor(Color.WHITE);
        questionMc.draw();

        //write the answers

        Text answer1 = new Text(100, 100, question.getAnswer1());
        Text answer2 = new Text(20, 120, question.getAnswer2());
        Text answer3 = new Text(20, 140, question.getAnswer3());
        answer1.setColor(Color.WHITE);
        answer2.setColor(Color.WHITE);
        answer3.setColor(Color.WHITE);
        answer1.grow(10,10);

        answer1.draw();
        answer2.draw();
        answer3.draw();

    }

    public Picture getFace() {
        return face;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
