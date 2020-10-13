package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture face;
    private Rectangle rectangle;

    public Player(int x, int y){
        this.face = new Picture(x,y,"resources/rsz_1cyan.png");
        this.rectangle = new Rectangle(x, y, 50, 50);
    }

    public void moveUp(){

        this.face.translate(0,-10);
        this.rectangle.translate(0,-10);
       // this.position.setRow(position.getRow() -10);
    }
    public void moveDown(){
       this.face.translate(0,10);
        this.rectangle.translate(0,10);
       // this.position.setRow(position.getRow() + 10);
    }

    public void moveRight(){
        this.face.translate(10,0);
        this.rectangle.translate(10,0);
       // this.position.setCol(position.getCol() + 10);
    }

    public void moveLeft(){
        this.face.translate(-10,0);
        this.rectangle.translate(-10,0);
       // this.position.setCol(position.getCol() - 10);
    }


    public Picture getFace(){
        return this.face;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }



    public int answerQuestion(){
        return 0;
    }



}
