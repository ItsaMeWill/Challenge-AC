package org.academiadecodigo.bitjs.player;


import org.academiadecodigo.bitjs.enemy.Jojo;
import org.academiadecodigo.bitjs.enemy.Mari;
import org.academiadecodigo.bitjs.enemy.PedroG;
import org.academiadecodigo.bitjs.enemy.Ricardo;
import org.academiadecodigo.bitjs.rooms.BreakRoom;
import org.academiadecodigo.bitjs.rooms.MacRoom;
import org.academiadecodigo.bitjs.rooms.PizzaRoom;
import org.academiadecodigo.bitjs.rooms.RelvinhaRoom;
import org.academiadecodigo.bitjs.sound.src.org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    public boolean menu;
    public boolean areCollided;
    public Picture intro;
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
    private Picture wrongAnswer = new Picture(200, 200, "resources/WRONGANSFINAL.png");
    private Rectangle[] macRoomObstacles = new Rectangle[3];
    private Rectangle[] pizzaRoomObstacles = new Rectangle[1];
    private Rectangle[] relvinhaRoomObstacles = new Rectangle[2];

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
    private Sound claps = new Sound("/resources/Clap.wav");
    private Sound wrong = new Sound("/resources/wrong.wav");
    private Sound highSound = new Sound("/resources/bobmarley.wav");

    public Game() {

        menu = true;
        moves();

    }


    public void startLevel1() {

        while (menu) {
          intro = new Picture(10, 10, "resources/Intro.png");
            intro.draw();

        }

        moves();

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
        tables = new Rectangle(155, 220, 230, 270);
        tables.draw();
        djSet = new Rectangle(120, 100, 90, 40);
        djSet.draw();
        macRoomObstacles[0] = ricardo.getRectangle();
        macRoomObstacles[1] = tables;
        macRoomObstacles[2] = djSet;

        soundtrack.play(true);

        while (true) {

            System.out.println("");

            if (collide(player.getRectangle(), ricardo.getRectangle())) {
                ricardo.makeQuestion();

                soundtrack.stop();
                ricardoVoice.play(true);

                while (currentAnswer != ricardo.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (currentAnswer) {
                        case 1:

                            wrong.play(true);
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;

                        case 2:

                            claps.play(true);
                            player.hasKey();
                            ricardo.getQuizScreen().delete();
                            wrongAnswer.delete();

                            //new Picture(200,200,"resources/CorrectAnswer.png").draw();
                            break;

                        case 3:

                            wrong.play(true);
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                    }
                }
                break;
            }
        }

        soundtrack.play(true);
        while (true) {

            System.out.println("");

            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 &&
                    player.getRectangle().getY() - player.getRectangle().getHeight() == 90) {
                ricardo.getRectangle().delete();
                ricardo.getFace().delete();
                startLevel2();

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
        player.getFace().translate(-400, 0);
        player.getRectangle().translate(-400, 0);
        player.refresh();
        mari = new Mari();
        mari.getFace().draw();
        mari.getRectangle().draw();
        pizzaRoomObstacles[0] = mari.getRectangle();


        while (true) {

            System.out.println("");

            if (collide(player.getRectangle(), mari.getRectangle())) {
                mari.makeQuestion();
                soundtrack.stop();
                mariVoice.play(true);


                while (currentAnswer != mari.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (currentAnswer) {
                        case 1:

                            claps.play(true);
                            player.hasKey();
                            mari.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;

                        case 2:

                            wrong.play(true);
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;

                        case 3:

                            wrong.play(true);
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                    }
                }

                break;
            }
        }
        soundtrack.play(true);

        while (true) {
            System.out.println("");


            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 200 && player.getRectangle().getY() == 30) {
                mari.getRectangle().delete();
                mari.getFace().delete();
                startLevel3();
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
        player.refresh();
        pedroG = new PedroG();
        pedroG.getFace().draw();
        pedroG.getRectangle().draw();
        puffs = new Rectangle(55, 180, 250, 300);
        puffs.draw();
        relvinhaRoomObstacles[0] = puffs;
        relvinhaRoomObstacles[1] = pedroG.getRectangle();

        while (true) {
            System.out.println("");
            System.out.println(player.getRectangle().getX() + player.getRectangle().getWidth());
            if (collide(player.getRectangle(), pedroG.getRectangle())) {
                pedroG.makeQuestion();
                pedroG.getQuizScreen();
                soundtrack.stop();
                pedroVoice.play(true);

                while (currentAnswer != pedroG.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (currentAnswer) {
                        case 1:

                            claps.play(true);
                            player.hasKey();
                            pedroG.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;

                        case 2:

                            claps.play(true);
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;

                        case 3:

                            wrong.play(true);
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;
                    }
                }

                break;
            }
        }

        soundtrack.play(true);
        while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 &&
                    player.getRectangle().getY() - player.getRectangle().getHeight() == 300) {
                pedroG.getRectangle().delete();
                pedroG.getFace().delete();
                startLevel4();
                break;
            }
        }


        return;

    }

    public void startLevel4() {

        currentAnswer = 0;
        breakRoom = new BreakRoom();
        breakRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.getFace().translate(-400, -280);
        player.getRectangle().translate(-400, -280);
        player.refresh();
        jojo = new Jojo();
        jojo.getFace().draw();
        jojo.getRectangle().draw();

        while (true) {
            System.out.println("");

            if (collide(player.getRectangle(), jojo.getRectangle())) {
                jojo.makeQuestion();
                jojo.getQuizScreen();
                soundtrack.stop();
                jojoVoice.play(true);

                while (currentAnswer != jojo.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (currentAnswer) {
                        case 1:

                            wrong.play(true);
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;

                        case 2:

                            wrong.play(true);
                            player.beerToHealth();
                            currentAnswer = 0;
                            wrongAnswer.draw();
                            break;

                        case 3:

                            claps.play(true);
                            player.hasKey();
                            jojo.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;

                    }
                }

                break;
            }
        } soundtrack.play(true);
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

        if (keyboardEvent == space) {

            menu = false;

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


    public void moves() {

        Keyboard keyboard = new Keyboard(this);

        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

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

