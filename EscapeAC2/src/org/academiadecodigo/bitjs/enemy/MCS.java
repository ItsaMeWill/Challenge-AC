package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

abstract public class MCS {

    private Picture face;
    private Rectangle rectangle;
    private Picture quizScreen;


    public MCS(Picture face, Rectangle rectangle) {
        this.face = face;
        this.rectangle = rectangle;

    }


    public void makeQuestion(Picture quizScreen) {
            this.quizScreen = quizScreen;
            quizScreen.draw();

}

    public Picture getQuizScreen() {
        return this.quizScreen;
    }

    public Picture getFace() {
        return face;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


}
