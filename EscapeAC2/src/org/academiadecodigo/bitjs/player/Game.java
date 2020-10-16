package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.MCS;
import org.academiadecodigo.bitjs.enemy.Mari;
import org.academiadecodigo.bitjs.enemy.Question;
import org.academiadecodigo.bitjs.enemy.Ricardo;
import org.academiadecodigo.bitjs.rooms.MacRoom;
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
    private Ricardo ricardo;
    private Mari mari;
    private int currentMove;
    private int currentAnswer = 10;
    private int currentRoom;
    private Rectangle tables;

    private KeyboardEvent left = new KeyboardEvent();
    private KeyboardEvent right = new KeyboardEvent();
    private KeyboardEvent down = new KeyboardEvent();
    private KeyboardEvent up = new KeyboardEvent();
    private KeyboardEvent one = new KeyboardEvent();
    private KeyboardEvent two = new KeyboardEvent();
    private KeyboardEvent three = new KeyboardEvent();

    public Game() {

    }

    public void startLevel1() {
        macRoom = new MacRoom();
        macRoom.getPicture().draw();
        player = new Player(200, 200);
        player.getFace().draw();
        player.getRectangle().draw();
        player.createBeers();
        ricardo = new Ricardo();
        ricardo.getRectangle().draw();
        ricardo.getFace().draw();
        movable = player.getFace();
        tables = new Rectangle(155,200,230,270);
        tables.draw();
        moves();
        //

        while (true) {

            System.out.println("");

            if (collide(player.getRectangle(), ricardo.getRectangle())) {
                ricardo.makeQuestion(Question.QUESTION1);
                ricardo.getQuizScreen();

                while (currentAnswer != ricardo.getCorrectAnswer()){
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                   switch (currentAnswer){
                        case 1:
                            player.beerToHealth();
                            currentAnswer = 0;
                            break;
                        case 2:
                            player.hasKey();
                            ricardo.getQuizScreen().delete();
                            break;
                        case 3:
                            player.beerToHealth();
                            currentAnswer = 0;
                            break;
                    }

               }
                //ricardo.getQuizScreen().delete();
                break;
            }
        }
       while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490) {
                ricardo.getRectangle().delete();
                break;
            }
        }
       return;
    }

    public void startLevel2() {
        Rectangle newRoom = new Rectangle(10, 10, 500, 500);
        newRoom.fill();
        player.getRectangle().translate(-250, -100);
        player.getRectangle().draw();
        player.refresh();
        player.getFace().translate(-250, -100);
        mari = new Mari();
        mari.getFace().draw();
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

    public void moving(KeyboardEvent keyboardEvent) {

                if (keyboardEvent == down && movable.getY() < 435) {
                     if(collide(player.getRectangle(), ricardo.getRectangle())){
                      player.moveDown();
                      return;

                    }
                    player.moveDown();
                }
                if (keyboardEvent == up && movable.getY() > 30) {
                    if (collide(player.getRectangle(), ricardo.getRectangle())){
                      player.moveDown();
                      return;
                    }
                    player.moveUp();
                }
                if (keyboardEvent == right && movable.getX() < 435) {
                    if (collide(player.getRectangle(), ricardo.getRectangle())){
                       player.moveLeft();
                       player.moveLeft();
                       return;

                    }
                    player.moveRight();
                }
                if (keyboardEvent == left && movable.getX() > 30){

                   if (collide(player.getRectangle(), ricardo.getRectangle())) {
                       player.moveRight();
                       player.moveRight();
                       return;

                   }
                    player.moveLeft();
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

       /* switch (currentMove){
            case 38:
                player.moveDown();
                player.moveDown();
                break;
            case 40:
                player.moveUp();
                player.moveUp();
                break;
            case 39:
                player.moveLeft();
                player.moveLeft();
                break;
            case 37:
                player.moveRight();
                player.moveRight();
                break;
        }*/


        return true;
    }

    public void verifyAnswer(int currentAnswer){
        System.out.println("pppp");

        switch (currentAnswer){
            case 1:
                player.beerToHealth();
                currentAnswer = 0;
                break;
            case 2:
                player.hasKey();
                ricardo.getQuizScreen().delete();
                break;
            case 3:
                player.beerToHealth();
                currentAnswer = 0;
                break;

        /*if (currentAnswer == ricardo.getCorrectAnswer()){
            System.out.println("certo");
            ricardo.getQuizScreen().delete();
            return;

        }
        if (currentAnswer == 0 || currentAnswer == 2) {
            System.out.println("errado");


            return;
*/
        }
    }
}
