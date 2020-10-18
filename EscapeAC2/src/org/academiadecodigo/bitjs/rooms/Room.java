package org.academiadecodigo.bitjs.rooms;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.*;

public class Room{

    private Rectangle field;
    private Picture picture;
    private int width;
    private int height;


    public Room(Picture picture){

        this.picture = picture;
        this.width = picture.getWidth();
        this.height = picture.getHeight();
    }

    public void init(){
        this.field = new Rectangle(10,10,this.width,this.height);
        field.draw();
        this.picture.draw();
    }

    public Picture getPicture() {
        return picture;
    }



}
