package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {

    private boolean menu = true;
    private boolean startGame = true;
    private boolean hasKey;
    private Picture key;
    private Picture[] face = new Picture[12];
    private Picture[] beers = new Picture[3];
    private Rectangle rectangle;
    private int health = 3;
    private int moveCounter;
    private int moveSet;
    private boolean isHigh = false;
    private boolean isColliding = false;
    private int currentAnswer = 0;
    private int currentRoom;
    private int currentMove;
    private int movingLeft = 6;
    private int movingRight = 9;
    private int movingDown = 0;
    private int movingUp = 3;
    private KeyboardEvent space = new KeyboardEvent();
    private KeyboardEvent start = new KeyboardEvent();
    private KeyboardEvent exit = new KeyboardEvent();
    private KeyboardEvent left = new KeyboardEvent();
    private KeyboardEvent right = new KeyboardEvent();
    private KeyboardEvent down = new KeyboardEvent();
    private KeyboardEvent up = new KeyboardEvent();
    private KeyboardEvent one = new KeyboardEvent();
    private KeyboardEvent two = new KeyboardEvent();
    private KeyboardEvent three = new KeyboardEvent();
    private Sound gameOverSound = new Sound("/resources/gameover.wav");

    public Player(int x, int y) {
        this.face[0] = new Picture(x, y, "resources/move down 1.png");
        this.face[1] = new Picture(x, y, "resources/move down 2.png");
        this.face[2] = new Picture(x, y, "resources/move down 3.png");
        this.face[3] = new Picture(x, y, "resources/move up 1.png");
        this.face[4] = new Picture(x, y, "resources/move up 2.png");
        this.face[5] = new Picture(x, y, "resources/move up 3.png");
        this.face[6] = new Picture(x, y, "resources/move left 1.png");
        this.face[7] = new Picture(x, y, "resources/move left 2.png");
        this.face[8] = new Picture(x, y, "resources/move left 3.png");
        this.face[9] = new Picture(x, y, "resources/move right 1.png");
        this.face[10] = new Picture(x, y, "resources/move right 2.png");
        this.face[11] = new Picture(x, y, "resources/move right 3.png");

        this.rectangle = new Rectangle(x, y, 50, 50);
    }

    public void createBeers(int health) {
        beers[0] = new Picture(40, 460, "resources/Beer.png");
        beers[1] = new Picture(90, 460, "resources/Beer.png");
        beers[2] = new Picture(140, 460, "resources/Beer.png");

        for (int i = 0; i < health; i++) {
            beers[i].draw();
        }
    }

    public void hasKey() {
        if (deadVerifier() == false) {
            this.hasKey = true;
            this.key = new Picture(440, 440, "resources/key.png");
            this.key.draw();
        }
    }

    public void beerToHealth() {
        this.health--;
        if (health == 2) beers[2].delete();
        if (health == 1) beers[1].delete();
        if (health == 0) beers[0].delete();
        if (health == 0) {
            gameOverSound.play(true);

        }

    }

    public void moveUp() {
        if(isHigh){
            this.moveCounter += 1;
        }
        if (moveCounter == 5) {
            setMoveCounter(0);
            randomMov();
        }
        if (!isColliding) {
            for (int i = 0; i < face.length; i++) {
                this.face[i].translate(0, -10);
                this.face[i].delete();
            }
            this.face[this.movingUp].draw();
            this.movingUp += 1;
            if ( this.movingUp > 5){
                this.movingUp = 3;
            }
            this.rectangle.translate(0, -10);
        }
    }

    public void moveDown() {
        if(isHigh){
            this.moveCounter += 1;
        }
        if (moveCounter == 5) {
            setMoveCounter(0);
            randomMov();
        }
        if (!isColliding) {
            for (int i = 0; i < face.length; i++) {
                this.face[i].translate(0, 10);
                this.face[i].delete();
            }
            this.face[this.movingDown].draw();
            this.movingDown += 1;
            if ( this.movingDown > 2){
                this.movingDown = 0;
            }
            this.rectangle.translate(0, 10);
        }
    }

    public void moveRight() {
        if(isHigh){
            this.moveCounter += 1;
        }
        if (moveCounter == 5) {
            setMoveCounter(0);
            randomMov();
        }
        if (!isColliding) {
            for (int i = 0; i < face.length; i++) {
                this.face[i].translate(10, 0);
                this.face[i].delete();
            }
            this.face[this.movingRight].draw();
            this.movingRight += 1;
            if ( this.movingRight > 11){
                this.movingRight = 9;
            }
            this.rectangle.translate(10, 0);
        }

    }

    public void moveLeft() {
        if(isHigh){
            this.moveCounter += 1;
        }
        if (moveCounter == 5) {
            setMoveCounter(0);
            randomMov();
        }
        if (!isColliding) {
            for (int i = 0; i < face.length; i++) {
                this.face[i].translate(-10, 0);
                this.face[i].delete();
            }
            this.face[this.movingLeft].draw();
            this.movingLeft += 1;
            if ( this.movingLeft > 8){
                this.movingLeft = 6;
            }
            this.rectangle.translate(-10, 0);
        }
    }

    public void refresh(int lastDirection){
        for (int i = 0; i < face.length; i++){
            face[i].delete();
        }
        face[lastDirection].draw();
    }

    public void cannabisOn() {
        this.isHigh = true;
    }

    public boolean getIsHigh() {
        return this.isHigh;
    }

    public void updatePosition(double x, double y) {
        for (int i = 0; i < face.length; i++) {
            face[i].translate(x, y);
        }
        rectangle.translate(x,y);
  }

    public Rectangle getRectangle() {
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

    public int getMoveCounter() {
        return this.moveCounter;
    }

    public int getMoveSet() {
        return this.moveSet;
    }

    public Picture getFace(int direction) {
        return this.face[direction];
    }

    public boolean isColliding() {
        return isColliding;
    }

    public void setColliding(boolean colliding) {
        isColliding = colliding;
    }

    public void setMoveSet(int moveSet) {
        this.moveSet = moveSet;
    }

    public void setMoveCounter(int num) {
        this.moveCounter = num;
    }

    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;

    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void selectedAnswers(KeyboardEvent keyboardEvent) {

        if(keyboardEvent == space) {

            this.menu = false;

        }

        if (keyboardEvent == start){

            this.startGame = false ;

        }

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


        if (keyboardEvent == down && rectangle.getY() < 435) {
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

        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        start.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(start);

        exit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        exit.setKey(KeyboardEvent.KEY_E);
        keyboard.addEventListener(exit);

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

    public void randomMov() {
        switch (this.getMoveSet()) {
            case 0:
                left.setKey(39);
                right.setKey(37);
                up.setKey(40);
                down.setKey(38);
                this.setMoveSet(1);
                break;
            case 1:
                left.setKey(38);
                right.setKey(40);
                up.setKey(39);
                down.setKey(37);
                this.setMoveSet(2);
                break;
            case 2:
                left.setKey(40);
                right.setKey(38);
                up.setKey(37);
                down.setKey(39);
                this.setMoveSet(0);
                break;
        }
    }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
        }

        public boolean collide (Rectangle r1, Rectangle r2){

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


    public boolean isMenu() {
        return menu;
    }

    public boolean isStartGame() {
        return startGame;
    }
}