package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.Mari;
import org.academiadecodigo.bitjs.enemy.Ricardo;
import org.academiadecodigo.bitjs.rooms.MacRoom;
import org.academiadecodigo.bitjs.rooms.MiddleRoom;
import org.academiadecodigo.bitjs.rooms.PizzaRoom;
import org.academiadecodigo.bitjs.sound.src.org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    public boolean initializer;
    public boolean areCollided;
    private Picture movable;
    private Player player;
    private MacRoom macRoom;
    private PizzaRoom pizzaRoom;
    private MiddleRoom middleRoom;


    private Ricardo ricardo;
    private Mari mari;
    private int currentMove;
    private int currentAnswer = 10;
    private int currentRoom;
    private Rectangle tables;
    private Rectangle[] macRoomObstacles = new Rectangle[2];
    private Rectangle[] pizzaRoomObstacles = new Rectangle[1];

    private KeyboardEvent space = new KeyboardEvent();
    private KeyboardEvent left = new KeyboardEvent();
    private KeyboardEvent right = new KeyboardEvent();
    private KeyboardEvent down = new KeyboardEvent();
    private KeyboardEvent up = new KeyboardEvent();
    private KeyboardEvent one = new KeyboardEvent();
    private KeyboardEvent two = new KeyboardEvent();
    private KeyboardEvent three = new KeyboardEvent();
    private Sound soundtrack = new Sound("/resources/soundtrack.wav");
    private Sound ricardoVoice = new Sound("/resources/ricardovoice.wav");
    private Sound mariVoice = new Sound("/resources/Mari.wav");
    private Sound pedroVoice = new Sound("/resources/pedrovoice.wav");
    private Sound jojoVoice = new Sound("/resources/Jojo.wav");
    private Sound claps = new Sound("/resources/Claps.wav");
    private Sound wrong = new Sound("/resources/Wrong.wav");
    private Sound highSound = new Sound("/resources/bobmarley.wav");

    public Game() {

    }

    /*public void intro() {

        initialize();
        Picture intro = new Picture(10, 10, "resources/Intro.png");
        intro.draw();


        while (initializer != true) {

            if (initializer) {
                intro.delete();
                return;
            }
        }
    }*/

    public void startLevel1() {

        moves();

        macRoom = new MacRoom();
        macRoom.getPicture().draw();
        currentRoom = 0;
        player = new Player(420, 400);
        player.createBeers(player.getCurrentHealth());

        player.getRectangle().draw();
        player.getFace().draw();
        ricardo = new Ricardo();
        ricardo.getRectangle().draw();
        ricardo.getFace().draw();
        movable = player.getFace();
        tables = new Rectangle(155, 200, 230, 270);
        tables.draw();
        macRoomObstacles[0] = ricardo.getRectangle();
        macRoomObstacles[1] = tables;


        soundtrack.play(true);

        while (true) {

            System.out.println("");

            if (collide(player.getRectangle(), ricardo.getRectangle())) {
                ricardo.makeQuestion();
                ricardo.getQuizScreen();
                soundtrack.stop();
                ricardoVoice.play(true);


                while (currentAnswer != ricardo.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (currentAnswer) {
                        case 1:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrong.play(true);
                            break;
                        case 2:

                            player.hasKey();
                            ricardo.getQuizScreen().delete();
                            claps.play(true);
                            break;

                        case 3:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrong.play(true);
                            break;
                    }
                }
                break;
            }
        }
        while (true) {

            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 &&
                    player.getRectangle().getY() - player.getRectangle().getHeight() == 80) {
                break;
            }
        }
        return;
    }

    public void startLevel2() {
        pizzaRoom = new PizzaRoom();
        pizzaRoom.getPicture().draw();
        currentRoom = 1;
        currentAnswer = 0;
        player.createBeers(player.getCurrentHealth());
        player.getFace().translate(-400, 0);
        player.getRectangle().translate(-400, 0);
        player.refresh();
        player.hasKey();
        mari = new Mari();
        mari.getFace().draw();
        mari.getRectangle().draw();
        pizzaRoomObstacles[0] = mari.getRectangle();

        while (true) {

            System.out.println("");

            if (collide(player.getRectangle(), mari.getRectangle())) {
                mari.makeQuestion();
                mari.getQuizScreen();

                while (currentAnswer != mari.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (currentAnswer) {
                        case 1:
                            player.hasKey();
                            mari.getQuizScreen().delete();
                            break;
                        case 2:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrong.play(true);
                            break;
                        case 3:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrong.play(true);
                            break;
                    }

                }

                break;
            }
        }

        while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 150 &&
                    player.getRectangle().getY() - player.getRectangle().getHeight() == 40) {

                break;
            }
        }
        return;

    }

    public void startLevel3() {
        middleRoom = new MiddleRoom();
        middleRoom.getPicture().draw();
        currentRoom = 3;
        player.createBeers(player.getCurrentHealth());
        player.getFace().translate(0, -400);
        player.getRectangle().translate(0, -400);
        player.refresh();
        player.lostKey();
        movable = player.getFace();
        mari = new Mari();
        mari.getFace().draw();
        mari.getRectangle().draw();

    }

    public void selectedAnswers(KeyboardEvent keyboardEvent) {

        if (keyboardEvent == space) {
            initializer = true;
            System.out.println("space");
        }

        if (keyboardEvent == one) {
            System.out.println("kerelkfer");
            this.currentAnswer = 1;
        }

        if (keyboardEvent == two) {
            System.out.println("knewefl");
            this.currentAnswer = 2;

        }

        if (keyboardEvent == three) {

            this.currentAnswer = 3;

        }
    }

    public void initialize() {

        Keyboard keyboard = new Keyboard(this);

        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

    }

    public void moves() {

        Keyboard keyboard = new Keyboard(this);

       /* space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);*/

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


    public void collisionDetector(Rectangle[] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            if (collide(player.getRectangle(), obstacles[i])) {
                switch (currentMove) {

                    case 0:
                        player.moveUp();
                        break;
                    case 1:
                        player.moveDown();
                        break;
                    case 2:
                        player.moveLeft();
                        break;
                    case 3:
                        player.moveRight();
                        break;
                    default:
                        break;
                }
            }
        }


    }


    public void moving(KeyboardEvent keyboardEvent) {

        switch (currentRoom) {
            case 0:
                collisionDetector(macRoomObstacles);
                break;
            case 1:
                collisionDetector(pizzaRoomObstacles);
                break;
            default:
                break;
        }


        if (keyboardEvent == down && movable.getY() < 435) {

            player.moveDown();
            currentMove = 0;
        }
        if (keyboardEvent == up && movable.getY() > 30) {

            player.moveUp();
            currentMove = 1;
        }
        if (keyboardEvent == right && movable.getX() < 435) {

            player.moveRight();
            currentMove = 2;
        }
        if (keyboardEvent == left && movable.getX() > 30) {


            player.moveLeft();
            currentMove = 3;
        }


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
}