package org.academiadecodigo.bitjs.rooms;

import org.academiadecodigo.bitjs.enemy.MCS;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.*;

public class MacRoom extends Room{

    private MCS ricardo = new MCS(new Picture(90,50,"resources/rsz_1player.png"), new Rectangle(90, 50, 50, 50));

    public MacRoom(){
        super(50,50, new Picture(10,10,"resources/MacRoom.png"));
        super.init();

    }

    public MCS getRicardo() {
        return ricardo;
    }

    //TODO override interface methods

}
