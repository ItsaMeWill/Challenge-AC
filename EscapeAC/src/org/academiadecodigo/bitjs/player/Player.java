package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.rooms.RoomPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bitjs.rooms.Room;
public class Player {

    private Picture face;

    private RoomPosition position;

    public Player(){
        this.face = new Picture(60,60,"src/org/academiadecodigo/bitjs/resources/rsz_1cyan.png");
        this.face.draw();
        this.position = new RoomPosition(60,60);
    }

    public void moveUp(){
        this.face.translate(0,-20);
        this.position.setRow(position.getRow() - 20);
    }
    public void moveDown(){
        this.face.translate(0,20);
        this.position.setRow(position.getRow() + 20);
    }

    public void moveRight(){
        this.face.translate(20,0);
        this.position.setCol(position.getCol() + 20);
    }

    public void moveLeft(){
        this.face.translate(-20,0);
        this.position.setCol(position.getCol() - 20);
    }


    public Picture getFace(){
        return this.face;
    }

    public RoomPosition getPosition(){
        return this.position;
    }

    public int answerQuestion(){
        return 0;
    }



}
