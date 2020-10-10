package org.academiadecodigo.bitjs.grids;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.*;

public abstract class Room implements Grid {

    private Rectangle rectangle;
    private Picture picture;
    private int x;
    private int y;
    private int width;
    private int height;
    private int col;
    private int row;
    private int cellsize = 10;

    private int PADDING = 10;

    public Room(){
        this.x = 0;
        this.y = 0;
    }

    public void setPicture(Picture picture){
       this.picture = picture;
    }

    public void setRectangle(Rectangle rectangle){
        this.rectangle = rectangle;
    }

    public Rectangle getRectangle(){
        return this.rectangle;
    }

    public Picture getPicture(){
        return this.picture;
    }

    //TODO setters

    //TODO getters

}
