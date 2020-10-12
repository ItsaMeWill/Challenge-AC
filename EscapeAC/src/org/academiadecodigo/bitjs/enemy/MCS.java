package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.bitjs.rooms.RoomPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MCS {


    private Picture face;
    private RoomPosition position;
    private Rectangle rectangle;

    public MCS(Picture face, RoomPosition position, Rectangle rectangle){
        this.face = face;
        this.position = position;
        this.rectangle = rectangle;
    }

    public Picture getFace() {
        return face;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public RoomPosition getPosition() {
        return position;
    }
}
