package org.academiadecodigo.bitjs.rooms;

import org.academiadecodigo.bitjs.enemy.MCS;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.*;

public class MacRoom extends Room{

    private MCS ricardo = new MCS(new Picture(80,80,"src/org/academiadecodigo/bitjs/resources/rsz_1player.png"),new RoomPosition(80,80));

    public MacRoom(){
        super(50,50, new Picture(10,10,"src/org/academiadecodigo/bitjs/resources/MacRoom.png"));
        super.init();
        ricardo.getFace().draw();

    }

    public MCS getRicardo() {
        return ricardo;
    }

    //TODO override interface methods

}
