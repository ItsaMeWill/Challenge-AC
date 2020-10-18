package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.*;
import org.academiadecodigo.bitjs.rooms.Room;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Room macRoom;
    private Room pizzaRoom;
    private Room relvinhaRoom;
    private Room breakRoom;
    private Ricardo ricardo;
    private Mari mari;
    private PedroG pedroG;
    private Jojo jojo;
    private Rectangle tables;
    private Rectangle djSet;
    private Rectangle puffs;
    private Rectangle weed;
    private Picture wrongAnswer = new Picture(130, 170, "resources/WRONGANSFINAL.png");
    private Picture gameOver = new Picture(10, 10, "resources/gamoverscreenfail.png");
    private Picture wonGame = new Picture(10, 10, "resources/ENDOFGAME.png");
    static Rectangle[] macRoomObstacles;
    static Rectangle[] pizzaRoomObstacles;
    static Rectangle[] relvinhaRoomObstacles;
    static Rectangle[] breakRoomObstacles;


    public void init() {
        player = new Player(420, 400);
        pedroG = new PedroG();
        mari = new Mari();
        ricardo = new Ricardo();
        jojo = new Jojo();
        macRoomObstacles = new Rectangle[3];
        relvinhaRoomObstacles = new Rectangle[2];
        breakRoomObstacles = new Rectangle[2];
        pizzaRoomObstacles = new Rectangle[1];
        tables = new Rectangle(155, 220, 230, 270);
        djSet = new Rectangle(120, 100, 90, 40);
        macRoomObstacles[0] = ricardo.getRectangle();
        macRoomObstacles[1] = tables;
        macRoomObstacles[2] = djSet;
        puffs = new Rectangle(55, 180, 250, 300);
        relvinhaRoomObstacles[0] = puffs;
        relvinhaRoomObstacles[1] = pedroG.getRectangle();
        weed = new Rectangle(260, 120, 150, 150);
        breakRoomObstacles[0] = weed;
        breakRoomObstacles[1] = jojo.getRectangle();
    }

    public Game() {
        init();
        player.moves();
    }

    public void startLevel1() {
        macRoom = new Room(new Picture(10, 10, "resources/Mac Room.png"));
        macRoom.getPicture().draw();

        player.createBeers(player.getHealth());
        player.setCurrentRoom(1);
        player.getRectangle().draw();
        player.getFace(0).draw();
        ricardo.getRectangle().draw();
        ricardo.getFace().draw();

        tables.draw();

        djSet.draw();

        while (true) {

            System.out.println("");

            if (player.collide(player.getRectangle(), ricardo.getRectangle())) {
                ricardo.makeQuestion();
                player.setColliding(true);

                while (player.getCurrentAnswer() != ricardo.getCorrectAnswer()) {
                    System.out.println("");


                    switch (player.getCurrentAnswer()) {
                        case 1:
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;
                        case 2:
                            player.hasKey();
                            player.setColliding(false);
                            ricardo.getQuizScreen().delete();
                            wrongAnswer.delete();

                            break;
                        case 3:
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;
                    }
                    if (player.deadVerifier()) {
                        gameOver.draw();
                    }
                }

                break;
            }
        }
        while (true) {
            System.out.println("");

            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 && player.getRectangle().getY() - player.getRectangle().getHeight() == 60) {
                ricardo.getRectangle().delete();
                ricardo.getFace().delete();
                macRoom.getPicture().delete();

                break;
            }
        }
        startLevel2();
    }

    public void startLevel2() {
        pizzaRoom = new Room(new Picture(10, 10, "resources/Sala intermédia.png"));
        pizzaRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.setCurrentRoom(2);
        player.setCurrentAnswer(0);
        player.updatePosition(-400, 0);
        player.refresh(3);
        mari = new Mari();
        mari.getFace().draw();
        mari.getRectangle().draw();
        pizzaRoomObstacles[0] = mari.getRectangle();

        while (true) {

            System.out.println("");

            if (player.collide(player.getRectangle(), mari.getRectangle())) {
                mari.makeQuestion();
                player.setColliding(true);

                while (player.getCurrentAnswer() != mari.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (player.getCurrentAnswer()) {
                        case 1:
                            player.setColliding(false);
                            player.hasKey();
                            mari.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;
                        case 2:
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;
                        case 3:
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;
                    }
                    if (player.deadVerifier()) {
                        gameOver.draw();
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
        startLevel3();
    }

    public void startLevel3() {
        relvinhaRoom = new Room(new Picture(10, 10, "resources/relvinha4.png"));
        relvinhaRoom.getPicture().draw();
        player.updatePosition(230, 400);
        player.refresh(0);
        player.createBeers(player.getHealth());
        player.setCurrentRoom(3);
        player.setCurrentAnswer(0);

        pedroG = new PedroG();
        pedroG.getFace().draw();
        pedroG.getRectangle().draw();
        puffs.draw();


        while (true) {
            System.out.println("");
            if (player.collide(player.getRectangle(), pedroG.getRectangle())) {
                pedroG.makeQuestion();
                player.setColliding(true);

                while (player.getCurrentAnswer() != pedroG.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (player.getCurrentAnswer()) {
                        case 1:
                            player.hasKey();
                            player.setColliding(false);
                            pedroG.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;
                        case 2:
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;
                        case 3:
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;
                    }
                    if (player.deadVerifier()) {
                        gameOver.draw();
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


        startLevel4();

    }

    public void startLevel4() {
        player.setCurrentAnswer(0);
        player.setCurrentRoom(4);
        breakRoom = new Room(new Picture(10, 10, "resources/BreakRoom.png"));
        breakRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.hasKey();
        player.updatePosition(-400, -280);
        player.refresh(3);
        jojo = new Jojo();
        jojo.getFace().draw();
        jojo.getRectangle().draw();
        weed.draw();

        while (true) {
            System.out.println("");

            if (player.collide(player.getRectangle(), jojo.getRectangle())) {
                jojo.makeQuestion();
                player.setColliding(true);

                while (player.getCurrentAnswer() != jojo.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (player.getCurrentAnswer()) {
                        case 1:
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;
                        case 2:
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;
                        case 3:
                            player.hasKey();
                            player.setColliding(false);
                            jojo.getQuizScreen().delete();
                            wrongAnswer.delete();
                            break;

                    }
                    if (player.deadVerifier()) {
                        gameOver.draw();
                    }
                }

                break;
            }
        }





            //TODO exit at the last door
            while (true) {
                System.out.println("teste");
                    if (player.collide(player.getRectangle(), weed)) {
                        System.out.println("deu certo");
                        player.cannabisOn();
                        return;
                }
                System.out.println("");
                if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 && player.getRectangle().getY() - player.getRectangle().getHeight() == 200) {
                    jojo.getRectangle().delete();
                    wonGame.draw();
                    break;
                }
            }
            wonGame.draw();
            return;
        }
    }

