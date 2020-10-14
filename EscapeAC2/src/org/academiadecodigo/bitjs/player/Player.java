package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture face;
    private Picture[] beers = new Picture[3];
    private Rectangle rectangle;
    private int maxHealth, currentHealth;

    public Player(int x, int y){
        this.face = new Picture(x,y,"resources/rsz_1cyan.png");
        this.rectangle = new Rectangle(x, y, 50, 50);
        this.maxHealth = 3;
    }

    public void createBeers(){
        beers[0] = new Picture(50,470,"resources/rsz_beer.png");
        beers[1] = new Picture(100,470,"resources/rsz_beer.png");
        beers[2] = new Picture(150,470,"resources/rsz_beer.png");
        for (int i = 0; i < beers.length; i++){
            beers[i].draw();
        }
    }

    public void beerToHealth(){
        switch (currentHealth){
            case 2: beers[2].delete();
            case 1: beers[1].delete();
            case 0: beers[0].delete();
        }
        if (currentHealth == 0){
            //call gameover screen
        }

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
