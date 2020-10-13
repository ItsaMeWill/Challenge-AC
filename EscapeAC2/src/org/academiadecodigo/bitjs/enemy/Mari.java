package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mari extends MCS {

    public Mari(){
        super(new Picture(80,80, "resources/player.png"), new Rectangle(80,80,50,50));
    }


    @Override
    public void makeQuestion(Question question, Question correct) {
        super.makeQuestion(question, correct);
    }

}
