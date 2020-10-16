package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private boolean hasKey;
    private Picture key;
    private Picture face;
    private Picture[] beers = new Picture[3];
    private Rectangle rectangle;
    private int maxHealth;
    private int currentHealth = 3;



    public Player(int x, int y) {
        this.face = new Picture(x, y, "resources/rsz_1cyan.png");
        this.rectangle = new Rectangle(x, y, 50, 50);
        this.maxHealth = 3;
        this.currentHealth = this.maxHealth;
    }


    public void createBeers(){
        beers[0] = new Picture(40,460,"resources/Beer.png");
        beers[1] = new Picture(90,460,"resources/Beer.png");
        beers[2] = new Picture(140,460,"resources/Beer.png");
        for (int i = 0; i < beers.length; i++){

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
        this.currentHealth--;
        if (currentHealth == 2) beers[2].delete();
        if (currentHealth == 1) beers[1].delete();
        if (currentHealth == 0) beers[0].delete();
        if (currentHealth == 0){

            //call gameover screen
        }

    }

    public void moveUp() {

        this.face.translate(0, -10);
        this.rectangle.translate(0, -10);

    }

    public void moveDown() {
        this.face.translate(0, 10);
        this.rectangle.translate(0, 10);

    }

    public void moveRight() {
        this.face.translate(10, 0);
        this.rectangle.translate(10, 0);
    }

    public void moveLeft(){
        this.face.translate(-10, 0);
        this.rectangle.translate(-10, 0);
    }

        public void refresh(){
         face.delete();
         face.draw();
        }

        public Picture getFace () {
            return this.face;
        }

        public Rectangle getRectangle () {
            return rectangle;
        }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}



