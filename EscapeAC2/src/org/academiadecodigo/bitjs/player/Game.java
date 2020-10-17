package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.*;
import org.academiadecodigo.bitjs.rooms.BreakRoom;
import org.academiadecodigo.bitjs.rooms.MacRoom;
import org.academiadecodigo.bitjs.rooms.RelvinhaRoom;
import org.academiadecodigo.bitjs.rooms.PizzaRoom;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
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
    private RelvinhaRoom relvinhaRoom;
    private BreakRoom breakRoom;
    private Ricardo ricardo;
    private Mari mari;
    private PedroG pedroG;
    private Jojo jojo;
    private int currentMove;
    private int currentAnswer = 10;
    private int currentRoom;
    private Rectangle tables;
    private Rectangle djSet;
    private Rectangle puffs;
     private Picture wrongAnswer= new Picture(170,170,"resources/WRONGANSFINAL.png");
    private Rectangle[] macRoomObstacles = new Rectangle[3];
    private Rectangle[] pizzaRoomObstacles = new Rectangle[1];
    private Rectangle[] relvinhaRoomObstacles = new Rectangle[2];
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

        player = new Player(420, 400);
        player.createBeers(player.getHealth());
        currentRoom = 1;
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
                player.setColliding(true);
                ricardo.makeQuestion();


                while (currentAnswer != ricardo.getCorrectAnswer()){
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                   switch (currentAnswer){
                        case 1:
                            player.beerToHealth();
                            currentAnswer = 0;
                           wrongAnswer.draw();
                            break;
                        case 2:
                            player.hasKey();
                            player.setColliding(false);
                            ricardo.getQuizScreen().delete();
                            wrongAnswer.delete();
                            //new Picture(200,200,"resources/CorrectAnswer.png").draw();
                            break;
                        case 3:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                    }

               }

                break;
            }
        }
       while (true) {
            System.out.println("");

            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 && player.getRectangle().getY() - player.getRectangle().getHeight() == 90) {
                ricardo.getRectangle().delete();
                ricardo.getFace().delete();
                macRoom.getPicture().delete();

                break;
            }
        }
       return;
    }

    public void startLevel2() {
        pizzaRoom = new PizzaRoom();
        pizzaRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        currentRoom = 2;
        currentAnswer = 0;
        player.createBeers(player.getHealth());
        player.updatePosition(-400,0, 3);
        player.getRectangle().translate(-400, 0);
        player.cannabisOn();
        player.hasKey();
        mari = new Mari();
        mari.getFace().draw();
        mari.getRectangle().draw();
        pizzaRoomObstacles[0] = mari.getRectangle();

       while (true) {

            System.out.println("");

            if (collide(player.getRectangle(), mari.getRectangle())) {
                player.setColliding(true);
                mari.makeQuestion();


                while (currentAnswer != mari.getCorrectAnswer()){
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                   switch (currentAnswer){
                        case 1:
                            player.hasKey();
                            mari.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;
                        case 2:
                            player.beerToHealth();
                            player.createBeers(player.getHealth());
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                        case 3:
                            player.beerToHealth();
                            player.createBeers(player.getHealth());
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                    }

               }

                break;
            }
        }

        while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 200 && player.getRectangle().getY() == 30) {
                mari.getRectangle().delete();
                mari.getFace().delete();
                pizzaRoom.getPicture().delete();

                break;
            }
        }
        return;
    }

    public void startLevel3() {
        currentAnswer = 0;
        relvinhaRoom = new RelvinhaRoom();
        relvinhaRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.getFace().translate(250, 400);
        player.getRectangle().translate(250, 400);
        currentRoom = 3;
        pedroG = new PedroG();
        pedroG.getFace().draw();
        pedroG.getRectangle().draw();
        puffs = new Rectangle(55,180,250,300);
        puffs.draw();
        relvinhaRoomObstacles[0] = puffs;
        relvinhaRoomObstacles[1] = pedroG.getRectangle();

        while (true) {
            System.out.println("");
            System.out.println(player.getRectangle().getX() + player.getRectangle().getWidth());
            if (collide(player.getRectangle(), pedroG.getRectangle())) {
                pedroG.makeQuestion();
                pedroG.getQuizScreen();

                while (currentAnswer != pedroG.getCorrectAnswer()){
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (currentAnswer){
                        case 1:
                            player.hasKey();
                            player.setColliding(false);
                            pedroG.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;
                        case 2:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                        case 3:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                    }

                }

                break;
            }
        }
        while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 && player.getRectangle().getY() - player.getRectangle().getHeight() == 300) {
                pedroG.getRectangle().delete();
                pedroG.getFace().delete();
                relvinhaRoom.getPicture().delete();
                break;
            }
        }


        return;

    }

    public void startLevel4(){
        currentAnswer = 0;
        breakRoom = new BreakRoom();
        breakRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.getFace().translate(-300, 0);
        player.getRectangle().translate(-300, 0);
        player.hasKey();
        player.getFace().translate(-400, -280);
        player.getRectangle().translate(-400, -280);
        jojo = new Jojo();
        jojo.getFace().draw();
        jojo.getRectangle().draw();

     while (true) {
            System.out.println("");

            if (collide(player.getRectangle(), jojo.getRectangle())) {
                jojo.makeQuestion();
                jojo.getQuizScreen();

                while (currentAnswer != jojo.getCorrectAnswer()){
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (currentAnswer){
                        case 1:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                        case 2:
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                        case 3:
                            player.hasKey();
                            player.setColliding(false);
                            jojo.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;

                    }

                }

                break;
            }
        }
        while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 && player.getRectangle().getY() - player.getRectangle().getHeight() == 200) {
                jojo.getRectangle().delete();
                break;
            }
        }
        return;
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

    public void randomMov(){
        switch (player.getMoveSet()){
            case 0:
                left.setKey(39);
                right.setKey(37);
                up.setKey(40);
                down.setKey(38);
                player.setMoveSet(1);
                break;
            case 1:
                left.setKey(38);
                right.setKey(40);
                up.setKey(39);
                down.setKey(37);
                player.setMoveSet(2);
                break;
            case 2:
                left.setKey(40);
                right.setKey(38);
                up.setKey(37);
                down.setKey(39);
                player.setMoveSet(0);
                break;
        }


    }

    public void moving(KeyboardEvent keyboardEvent) {

        switch (currentRoom){
            case 1:
                collisionDetector(macRoomObstacles);
                break;
            case 2:
                collisionDetector(pizzaRoomObstacles);
                break;
            case 3:
                collisionDetector(relvinhaRoomObstacles);
                break;
        }

        if (keyboardEvent == down && movable.getY() < 435) {
            if (player.getIsHigh() && player.getMoveCounter() == 5) {
                randomMov();
                player.setMoveCounter(0);
            } else {
                player.moveDown();
                currentMove = 0;
            }
        }

        if (keyboardEvent == up && movable.getY() > 30) {
            if (player.getIsHigh() && player.getMoveCounter() == 5) {
                randomMov();
                player.setMoveCounter(0);
            } else {
                player.moveUp();
                currentMove = 1;
            }
        }

        if (keyboardEvent == right && movable.getX() < 435) {
            if (player.getIsHigh() && player.getMoveCounter() == 5) {
                randomMov();
                player.setMoveCounter(0);
            } else {
                player.moveRight();
                currentMove = 2;
            }
        }

        if (keyboardEvent == left && movable.getX() > 30) {
            if (player.getIsHigh() && player.getMoveCounter() == 5){
                randomMov();
                player.setMoveCounter(0);
            } else {
                player.moveLeft();
                currentMove = 3;
            }
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
