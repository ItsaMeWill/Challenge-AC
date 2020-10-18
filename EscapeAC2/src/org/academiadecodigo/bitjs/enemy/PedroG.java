package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PedroG extends MCS {
private int correctAnswer;
    public PedroG(){
        super(new Picture(50,50, "resources/PedroFace.png"), new Rectangle(50,50,50,50));
        correctAnswer = 1;
    }
    public void makeQuestion() {
        super.makeQuestion((new Picture(10,10,"resources/pedrobattle1final_.png")));
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
