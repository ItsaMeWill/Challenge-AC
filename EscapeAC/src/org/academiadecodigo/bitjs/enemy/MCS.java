package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.bitjs.rooms.RoomPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MCS {


    private Picture face;
    private RoomPosition position;

    public MCS(Picture face, RoomPosition position){
        this.face = face;
        this.position = position;

    }

    public Picture getFace() {
        return face;
    }

    public RoomPosition getPosition() {
        return position;
    }
}
