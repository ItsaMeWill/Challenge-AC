package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.rooms.RoomPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bitjs.rooms.Room;

public class Player {

    private Picture face;
    private Rectangle rectangle;
    private RoomPosition position;

    public Player(){
        this.face = new Picture(200,200,"src/org/academiadecodigo/bitjs/resources/rsz_1cyan.png");
        this.face.draw();
        this.position = new RoomPosition(200,200);
        this.rectangle = new Rectangle(200, 200, 50, 50);
        this.rectangle.draw();
    }

    public void moveUp(){
        this.face.translate(0,-10);
        this.rectangle.translate(0,-10);
        this.position.setRow(position.getRow() -10);
    }
    public void moveDown(){
        this.face.translate(0,10);
        this.rectangle.translate(0,10);
        this.position.setRow(position.getRow() + 10);
    }

    public void moveRight(){
        this.face.translate(10,0);
        this.rectangle.translate(10,0);
        this.position.setCol(position.getCol() + 10);
    }

    public void moveLeft(){
        this.face.translate(-10,0);
        this.rectangle.translate(-10,0);
        this.position.setCol(position.getCol() - 10);
    }


    public Picture getFace(){
        return this.face;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public RoomPosition getPosition(){
        return this.position;
    }

    public int answerQuestion(){
        return 0;
    }



}
