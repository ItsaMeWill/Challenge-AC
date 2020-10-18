package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {

    private boolean hasKey;
    private Picture key;
    private Picture face;
    private Picture[] beers = new Picture[3];
    private Rectangle rectangle;
    private int health = 3;
    private int currentAnswer = 0;
    private int currentRoom;
    private int currentMove;
    private KeyboardEvent left = new KeyboardEvent();
    private KeyboardEvent right = new KeyboardEvent();
    private KeyboardEvent down = new KeyboardEvent();
    private KeyboardEvent up = new KeyboardEvent();
    private KeyboardEvent one = new KeyboardEvent();
    private KeyboardEvent two = new KeyboardEvent();
    private KeyboardEvent three = new KeyboardEvent();

    public Player(int x, int y) {
        this.face = new Picture(x, y, "resources/rsz_1cyan.png");
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
         rectangle.delete();
         face.draw();
         rectangle.draw();
    }

        public Picture getFace () {
            return this.face;
        }

        public Rectangle getRectangle () {
            return rectangle;
        }

    public int getCurrentAnswer() {
        return currentAnswer;
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public int getHealth() {
        return health;
    }

    public void setCurrentAnswer(int currentAnswer){
        this.currentAnswer = currentAnswer;

    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void selectedAnswers(KeyboardEvent keyboardEvent) {

        if (keyboardEvent == one) {

            this.currentAnswer = 1;

        }

        if (keyboardEvent == two) {

            this.currentAnswer = 2;

        }

        if (keyboardEvent == three) {

            this.currentAnswer = 3;

        }

    }
    public void collisionDetector(Rectangle[] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            if (collide(rectangle, obstacles[i])) {
                switch (currentMove) {
                    case 0:
                        moveUp();
                        break;
                    case 1:
                        moveDown();
                        break;
                    case 2:
                        moveLeft();
                        break;
                    case 3:
                        moveRight();
                        break;
                }
            }
        }

    }
    public void moving(KeyboardEvent keyboardEvent) {

        switch (currentRoom) {
            case 1:
                collisionDetector(Game.macRoomObstacles);
                break;
            case 2:
                collisionDetector(Game.pizzaRoomObstacles);
                break;
            case 3:
                collisionDetector(Game.relvinhaRoomObstacles);
                break;
            case 4:
                collisionDetector(Game.breakRoomObstacles);
                break;

        }


        if (keyboardEvent == down &&  rectangle.getY() < 435) {
            moveDown();
            currentMove = 0;
        }
        if (keyboardEvent == up && rectangle.getY() > 30) {
            moveUp();
            currentMove = 1;
        }
        if (keyboardEvent == right && rectangle.getX() < 435) {
            moveRight();
            currentMove = 2;
        }
        if (keyboardEvent == left && rectangle.getX() > 30) {
            moveLeft();
            currentMove = 3;
        }


    }

    public void moves() {

        Keyboard keyboard = new Keyboard(this);

        one.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        one.setKey(KeyboardEvent.KEY_1);
        keyboard.addEventListener(one);

        two.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        two.setKey(KeyboardEvent.KEY_2);
        keyboard.addEventListener(two);

        three.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        three.setKey(KeyboardEvent.KEY_3);
        keyboard.addEventListener(three);

        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(up);

        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);

    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        moving(keyboardEvent);
        selectedAnswers(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
    public boolean collide(Rectangle r1, Rectangle r2) {

        if (r1.getX() > r2.getX() + r2.getWidth() || r1.getX() + r1.getWidth() < r2.getX() ||
                r1.getY() > r2.getY() + r2.getHeight() || r1.getY() + r1.getHeight() < r2.getY()) {
            return false;
        }
        return true;
    }
    public boolean deadVerifier() {
        if (health == 0) {
            return true;
        }
        return false;
    }
}



