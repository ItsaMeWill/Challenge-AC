package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private boolean hasKey;
    private Picture key;
    private Picture[] face = new Picture[4];
    private Picture[] beers = new Picture[3];
    private Rectangle rectangle;
    private int health = 3;
    private int moveCounter;
    private int moveSet;
    private boolean isHigh = false;
    private boolean isColliding = false;

    public Player(int x, int y) {
        this.face[0] = new Picture(x, y, "resources/up copy.png");
        this.face[1] = new Picture(x,y, "resources/down copy.png");
        this.face[2] = new Picture(x,y, "resources/left copy.png");
        this.face[3] = new Picture(x,y, "resources/right copy.png");
        this.rectangle = new Rectangle(x, y, 50, 50);
    }

    public void createBeers(int health){
        beers[0] = new Picture(40,460,"resources/Beer.png");
        beers[1] = new Picture(90,460,"resources/Beer.png");
        beers[2] = new Picture(140,460,"resources/Beer.png");

        for (int i = 0; i < health; i++){

            beers[i].draw();
        }
    }

    public void lostKey(){
        this.hasKey = false;
        this.key.delete();
    }

    public void hasKey(){
        this.hasKey = true;
        this.key = new Picture(440,440, "resources/key.png");
        this.key.draw();
    }

    public void beerToHealth(){
        this.health--;
        if (health == 2) beers[2].delete();
        if (health == 1) beers[1].delete();
        if (health == 0) beers[0].delete();
        if (health == 0){

            //call gameover screen
        }

    }

    public void moveUp() {
        if (!isColliding) {
            this.moveCounter += 1;
            for (int i = 0; i < face.length; i++) {
                this.face[i].translate(0, -10);
                this.face[i].delete();
            }
            this.face[0].draw();
            this.rectangle.translate(0, -10);
        }
    }

    public void moveDown() {
        if (!isColliding) {
            this.moveCounter += 1;
            for (int i = 0; i < face.length; i++) {
                this.face[i].translate(0, 10);
                this.face[i].delete();
            }
            this.face[1].draw();
            this.rectangle.translate(0, 10);
        }
    }

    public void moveRight() {
        if (!isColliding) {
            this.moveCounter += 1;
            for (int i = 0; i < face.length; i++) {
                this.face[i].translate(10, 0);
                this.face[i].delete();
            }
            this.face[3].draw();
            this.rectangle.translate(10, 0);
        }
    }


    public void moveLeft(){
        if (!isColliding) {
            this.moveCounter += 1;
            for (int i = 0; i < face.length; i++) {
                this.face[i].translate(-10, 0);
                this.face[i].delete();
            }
            this.face[2].draw();
            this.rectangle.translate(-10, 0);
        }
    }

    public void cannabisOn(){
        this.isHigh = true;
    }

    public boolean getIsHigh(){
        return this.isHigh;
    }

    public void updatePosition (double x, double y, int lastDirection) {
        for (int i = 0; i < face.length; i++){
            face[i].translate(x,y);
        }
        face[lastDirection].draw();
    }

    public Rectangle getRectangle () {
        return rectangle;
    }

    public int getHealth() {
        return health;
    }

    public int getMoveCounter(){
        return  this.moveCounter;
    }

    public int getMoveSet(){
        return this.moveSet;
    }

    public Picture getFace(){
        return this.face[0];
    }

    public boolean isColliding() {
        return isColliding;
    }

    public void setColliding(boolean colliding) {
        isColliding = colliding;
    }

    public void setMoveSet(int moveSet){
       this.moveSet = moveSet;
    }

    public void setMoveCounter(int num){
        this.moveCounter = num;
    }

}



