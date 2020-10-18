package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Jojo extends MCS {
    int correctAnswer;
    public Jojo(){
        super(new Picture(330,360, "resources/jojoface2.1.png"), new Rectangle(330,360,50,50));
        this.correctAnswer = 3;
    }
    public void makeQuestion() {
        super.makeQuestion((new Picture(10,10,"resources/jojobattle1final.png")));
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

