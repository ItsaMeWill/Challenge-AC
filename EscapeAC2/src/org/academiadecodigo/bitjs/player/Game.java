package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.Jojo;
import org.academiadecodigo.bitjs.enemy.Mari;
import org.academiadecodigo.bitjs.enemy.PedroG;
import org.academiadecodigo.bitjs.enemy.Ricardo;
import org.academiadecodigo.bitjs.rooms.Room;
import org.academiadecodigo.bitjs.sound.src.org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    static Rectangle[] macRoomObstacles;
    static Rectangle[] pizzaRoomObstacles;
    static Rectangle[] relvinhaRoomObstacles;
    static Rectangle[] breakRoomObstacles;
    private Picture menu;
    private Picture instructions;
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
    private Sound soundMenu;
    private Sound soundtrack;
    private Sound wrong;
    private Sound claps;
    private Sound victorySound;
    private Sound ricardoVoice;
    private Sound pedroVoice;
    private Sound mariVoice;
    private Sound jojoVoice;


    public Game() {
        init();
        player.moves();
    }

    public void init() {

        soundMenu = new Sound("/resources/mainmenu.wav");
        soundtrack = new Sound("/resources/soundtrack.wav");
        wrong = new Sound("/resources/Wrong.wav");
        claps = new Sound("/resources/Clap.wav");
        ricardoVoice = new Sound("/resources/ricardovoice.wav");
        pedroVoice = new Sound("/resources/pedrovoice.wav");
        jojoVoice = new Sound("/resources/Jojo.wav");
        mariVoice = new Sound("/resources/Mari.wav");
        victorySound = new Sound("/resources/victory.wav");


        menu = new Picture(10, 10, "resources/Intro2.0.png");
        instructions = new Picture(10, 10, "resources/Instructions.png");
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
        weed = new Rectangle(250, 150, 150, 150);
        breakRoomObstacles[0] = weed;
        breakRoomObstacles[1] = jojo.getRectangle();
    }

    public void startLevel1() {

        soundMenu.play(true);

        while (player.isMenu() == true) {

            menu.draw();

        }

        if (player.isMenu() == false) {
            menu.delete();
        }

        while (player.isStartGame() == true) {

            instructions.draw();

        }

        if (player.isStartGame() == false) {

            instructions.delete();
        }

        soundMenu.stop();

        macRoom = new Room(new Picture(10, 10, "resources/Mac Room.png"));
        macRoom.getPicture().draw();

        player.createBeers(player.getHealth());
        player.setCurrentRoom(1);
        player.getRectangle().draw();
        player.getFace().draw();
        ricardo.getRectangle().draw();
        ricardo.getFace().draw();

        tables.draw();
        djSet.draw();
        soundtrack.play(true);


        while (true) {

            System.out.println("");

            if (player.collide(player.getRectangle(), ricardo.getRectangle())) {
                ricardo.makeQuestion();

                soundtrack.stop();
                ricardoVoice.play(true);


                while (player.getCurrentAnswer() != ricardo.getCorrectAnswer()) {
                    System.out.println("");


                    switch (player.getCurrentAnswer()) {
                        case 1:

                            wrong.play(true);
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;


                        case 2:

                            if (player.deadVerifier() == false) {
                                claps.play(true);
                                player.hasKey();
                                ricardo.getQuizScreen().delete();
                                wrongAnswer.delete();
                            }
                            break;

                        case 3:

                            wrong.play(true);
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
        } soundtrack.play(true);
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

        startLevel2();
    }

    public void startLevel2() {
        pizzaRoom = new Room(new Picture(10, 10, "resources/Sala intermédia.png"));
        pizzaRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.setCurrentRoom(2);
        player.setCurrentAnswer(0);
        player.createBeers(player.getHealth());
        player.getFace().translate(-400, 0);
        player.getRectangle().translate(-400, 0);
        player.refresh();
        mari.getFace().draw();
        mari.getRectangle().draw();
        pizzaRoomObstacles[0] = mari.getRectangle();


        while (true) {

            System.out.println("");

            if (player.collide(player.getRectangle(), mari.getRectangle())) {
                mari.makeQuestion();
                soundtrack.stop();
                mariVoice.play(true);


                while (player.getCurrentAnswer() != mari.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (player.getCurrentAnswer()) {


                        case 1:
                            if (player.deadVerifier() == false) {
                                claps.play(true);
                                player.hasKey();
                                mari.getQuizScreen().delete();
                                wrongAnswer.delete();
                            }
                            break;

                        case 2:

                            wrong.play(true);
                            player.beerToHealth();
                            player.createBeers(player.getHealth());
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;

                        case 3:


                            wrong.play(true);
                            player.beerToHealth();
                            player.createBeers(player.getHealth());
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
        startLevel3();
    }

    public void startLevel3() {

        player.setCurrentAnswer(0);
        relvinhaRoom = new Room(new Picture(10, 10, "resources/relvinha4.png"));
        relvinhaRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.getFace().translate(250, 400);
        player.getRectangle().translate(250, 400);
        player.setCurrentRoom(3);
        player.refresh();

        pedroG.getFace().draw();
        pedroG.getRectangle().draw();


        puffs.draw();


        while (true) {
            System.out.println("");
            System.out.println(player.getRectangle().getX() + player.getRectangle().getWidth());
            if (player.collide(player.getRectangle(), pedroG.getRectangle())) {
                pedroG.makeQuestion();
                //   pedroG.getQuizScreen();
                soundtrack.stop();
                pedroVoice.play(true);


                while (player.getCurrentAnswer() != pedroG.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (player.getCurrentAnswer()) {
                        case 1:
                            if (player.deadVerifier() == false) {
                                claps.play(true);
                                player.hasKey();
                                pedroG.getQuizScreen().delete();
                                wrongAnswer.delete();
                            }
                            break;

                        case 2:

                            wrong.play(true);
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;

                        case 3:

                            wrong.play(true);
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
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


        startLevel4();

    }

    public void startLevel4() {

        player.setCurrentAnswer(0);
        player.setCurrentRoom(4);
        breakRoom = new Room(new Picture(10, 10, "resources/breakRoomWFinal.png"));
        breakRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.getFace().translate(-400, -280);
        player.getRectangle().translate(-400, -280);
        player.refresh();

        jojo.getFace().draw();
        jojo.getRectangle().draw();
        weed.draw();

        while (true) {
            System.out.println("");

            if (player.collide(player.getRectangle(), jojo.getRectangle())) {
                jojo.makeQuestion();
                jojo.getQuizScreen();
                soundtrack.stop();
                jojoVoice.play(true);


                while (player.getCurrentAnswer() != jojo.getCorrectAnswer()) {
                    System.out.println("");
                    //verifyAnswer(currentAnswer);

                    switch (player.getCurrentAnswer()) {

                        case 1:

                            wrong.play(true);
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;

                        case 2:


                            wrong.play(true);
                            player.beerToHealth();
                            player.setCurrentAnswer(0);
                            wrongAnswer.draw();
                            break;

                        case 3:
                            if (player.deadVerifier() == false) {
                                claps.play(true);
                                player.hasKey();
                                jojo.getQuizScreen().delete();
                                wrongAnswer.delete();
                            }
                            break;

                    }

                    if (player.deadVerifier()) {
                        gameOver.draw();
                    }
                }

                break;
            }
        }
        soundtrack.play(true);
        while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 && player.getRectangle().getY() - player.getRectangle().getHeight() == 200) {
                jojo.getRectangle().delete();
                wonGame.draw();
                break;
            }
        }

        wonGame.draw();
        victorySound.play(true);
        soundtrack.stop();
        return;
    }


}

