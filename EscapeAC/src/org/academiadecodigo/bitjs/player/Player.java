package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private String name;
    private Picture face;
    private Movement movement;

    public Player(){
        this.face = new Picture(400,350,"src/org/academiadecodigo/bitjs/resources/rsz_cyan.png");
        this.face.draw();
        this.movement = new Movement(this.face);
    }



    public int answerQuestion(){
        return 0;
    }

    public void move(){

    }

}
