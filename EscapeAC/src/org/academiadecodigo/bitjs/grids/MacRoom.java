package org.academiadecodigo.bitjs.grids;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import org.academiadecodigo.simplegraphics.pictures.Picture;



public class MacRoom extends Room{
    Obstacles obstacles;
    Rectangle tables = new Rectangle(150,190,250,300);

    @Override
    public void init(){
       super.setPicture(new Picture(10,10,"src/org/academiadecodigo/bitjs/resources/MacRoom.png"));
       super.setRectangle(new Rectangle(10,10,500,500)); //graphic rectangle
       super.getRectangle().fill();
       super.getPicture().draw();
       tables.fill();

    }


    //TODO override interface methods

}
