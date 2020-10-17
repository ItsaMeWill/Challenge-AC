package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.MCS;
import org.academiadecodigo.bitjs.enemy.Mari;
import org.academiadecodigo.bitjs.enemy.Question;
import org.academiadecodigo.bitjs.enemy.Ricardo;
import org.academiadecodigo.bitjs.rooms.MacRoom;
import org.academiadecodigo.bitjs.rooms.MiddleRoom;
import org.academiadecodigo.bitjs.rooms.PizzaRoom;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

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
    private Rectangle djSet;
    private Rectangle[] macRoomObstacles = new Rectangle[3];
    private Rectangle[] pizzaRoomObstacles = new Rectangle[1];

    private KeyboardEvent left = new KeyboardEvent();
    private KeyboardEvent right = new KeyboardEvent();
    private KeyboardEvent down = new KeyboardEvent();
    private KeyboardEvent up = new KeyboardEvent();
    private KeyboardEvent one = new KeyboardEvent();
    private KeyboardEvent two = new KeyboardEvent();
    private KeyboardEvent three = new KeyboardEvent();

    public Game() {


        moves();

    }

    public void startLevel1() {
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
        tables = new Rectangle(155,220,230,270);
        tables.draw();
        djSet = new Rectangle(120,100,90,40);
        djSet.draw();
        macRoomObstacles[0] = ricardo.getRectangle();
        macRoomObstacles[1] = tables;
        macRoomObstacles[2] = djSet;


       while (true) {

            System.out.println("");

            if (collide(player.getRectangle(), ricardo.getRectangle())) {
                ricardo.makeQuestion();
                ricardo.getQuizScreen();

                while (currentAnswer != ricardo.getCorrectAnswer()){
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                   switch (currentAnswer){
                        case 1:
                            player.beerToHealth();
                            currentAnswer = 0;
                            //new Picture(200,200,"resources/WrongAnswer.png").draw();
                            break;
                        case 2:
                            player.hasKey();
                            ricardo.getQuizScreen().delete();
                            //new Picture(200,200,"resources/CorrectAnswer.png").draw();
                            break;
                        case 3:
                            player.beerToHealth();
                            currentAnswer = 0;
                            break;
                    }

               }

                break;
            }
        }
       while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 && player.getRectangle().getY() - player.getRectangle().getHeight() == 80) {
                macRoom.getPicture().delete();
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
       // player.redrawBeer();
        player.refresh();
        mari = new Mari();
        mari.getFace().draw();
        mari.getRectangle().draw();
        pizzaRoomObstacles[0] = mari.getRectangle();

        while (true) {

            System.out.println("");

            if (collide(player.getRectangle(), mari.getRectangle())) {
                mari.makeQuestion();
                mari.getQuizScreen();

                while (currentAnswer != mari.getCorrectAnswer()){
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                   switch (currentAnswer){
                        case 1:
                            player.hasKey();
                            mari.getQuizScreen().delete();
                            break;
                        case 2:
                            player.beerToHealth();
                            currentAnswer = 0;
                            break;
                        case 3:
                            player.beerToHealth();
                            currentAnswer = 0;
                            break;
                    }

               }

                break;
            }
        }

        while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 150 && player.getRectangle().getY() - player.getRectangle().getHeight() == 40) {


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

    public void collisionDetector(Rectangle[] obstacles){
        for (int i = 0; i < obstacles.length; i++) {
            if(collide(player.getRectangle(), obstacles[i])){
                switch (currentMove){
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
                }
            }
        }

    }




    public void moving(KeyboardEvent keyboardEvent) {

         switch (currentRoom){
             case 0:
                 collisionDetector(macRoomObstacles);
                 break;
             case 1:
                 collisionDetector(pizzaRoomObstacles);
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
                if (keyboardEvent == left && movable.getX() > 30){
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
