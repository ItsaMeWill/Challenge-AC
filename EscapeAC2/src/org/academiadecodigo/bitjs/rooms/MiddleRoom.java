package org.academiadecodigo.bitjs.rooms;

import org.academiadecodigo.simplegraphics.pictures.*;
public class MiddleRoom extends Room{

    public MiddleRoom(){
        super(/*50,50,*/ new Picture(10,10,"resources/anotherRoom.png"));
        super.init();
    }

    //TODO override interface methods
}
