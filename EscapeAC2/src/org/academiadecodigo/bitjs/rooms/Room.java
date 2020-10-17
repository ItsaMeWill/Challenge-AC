package org.academiadecodigo.bitjs.rooms;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.*;

public abstract class Room{

    private Rectangle field;
    private Picture picture;
    private int width;
    private int height;
    private int col;
    private int row;
    private int cellsize = 10;

    private int PADDING = 10;

    public Room(int col, int row, Picture picture){
        this.col = col;
        this.row = row;
        this.picture = picture;
        this.width = col * cellsize;
        this.height = row * cellsize;
    }

    public void init(){
        this.field = new Rectangle(10,10,this.width,this.height);
        field.draw();
        this.picture.draw();
    }

    public Rectangle getField(){
        return this.field;
    }

    public Picture getPicture() {
        return picture;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


}
