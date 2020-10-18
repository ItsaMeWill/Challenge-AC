package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.Jojo;
import org.academiadecodigo.bitjs.enemy.Mari;
import org.academiadecodigo.bitjs.enemy.PedroG;
import org.academiadecodigo.bitjs.enemy.Ricardo;
import org.academiadecodigo.bitjs.rooms.Room;
import org.academiadecodigo.bitjs.sound.Sound;
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
    private Picture weedArrow;
    private Picture wrongAnswer = new Picture(130, 170, "resources/WRONGANSFINAL.png");
    private Picture gameOver = new Picture(10, 10, "resources/gamoverscreenfail.png");
    private Picture wonGame = new Picture(10, 10, "resources/ENDOFGAME.png");
    private Sound soundMenu;
    private Sound soundtrack;
    private Sound bobmarley;
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
        bobmarley = new Sound("/resources/bobmarley.wav");
        wrong = new Sound("/resources/Wrong.wav");
        claps = new Sound("/resources/Clap.wav");
        ricardoVoice = new Sound("/resources/ricardovoice.wav");
        pedroVoice = new Sound("/resources/pedrovoice.wav");
        jojoVoice = new Sound("/resources/Jojo.wav");
        mariVoice = new Sound("/resources/Mari.wav");
        victorySound = new Sound("/resources/victory.wav");
        menu = new Picture(10, 10, "resources/Intro2.0.png");
        instructions = new Picture(10, 10, "resources/instructionsManual.png");
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
        djSet = new Rectangle(120, 100, 10, 10);
        macRoomObstacles[0] = ricardo.getRectangle();
        macRoomObstacles[1] = tables;
        macRoomObstacles[2] = djSet;
        puffs = new Rectangle(55, 180, 250, 300);
        relvinhaRoomObstacles[0] = puffs;
        relvinhaRoomObstacles[1] = pedroG.getRectangle();
        weedArrow = new Picture(300, 50, "resources/red_arrow.png");
        weed = new Rectangle(170, 50, 125, 140);
        breakRoomObstacles[0] = weed;
        breakRoomObstacles[1] = jojo.getRectangle();
    }

    public void startLevel1() {
        player.setColliding(true);
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
        player.setColliding(false);
        player.createBeers(player.getHealth());
        player.setCurrentRoom(1);
        player.getFace(1).draw();
        ricardo.getFace().draw();
        soundtrack.play(true);

        while (true) {

            System.out.println("");

            if (player.collide(player.getRectangle(), ricardo.getRectangle())) {
                ricardo.makeQuestion();
                player.setColliding(true);
                soundtrack.stop();
                ricardoVoice.play(true);

                while (player.getCurrentAnswer() != ricardo.getCorrectAnswer()) {
                    System.out.println("");

                    switch (player.getCurrentAnswer()) {
                        case 1:
                            if (player.deadVerifier() == false) {
                                wrong.play(true);
                                player.beerToHealth();
                                player.setCurrentAnswer(0);
                                wrongAnswer.draw();
                                break;
                            }

                        case 2:
                            if (player.deadVerifier() == false) {
                                claps.play(true);
                                player.setColliding(false);
                                player.hasKey();
                                ricardo.getQuizScreen().delete();
                                wrongAnswer.delete();
                                break;
                            }


                        case 3:

                            if (player.deadVerifier() == false) {
                                wrong.play(true);
                                player.beerToHealth();
                                player.setCurrentAnswer(0);
                                wrongAnswer.draw();
                                break;
                            }
                    }

                    if (player.deadVerifier()) {
                        gameOver.draw();
                        return;
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
        pizzaRoomObstacles[0] = mari.getRectangle();

        while (true) {

            System.out.println("");

            if (player.collide(player.getRectangle(), mari.getRectangle())) {
                mari.makeQuestion();
                player.setColliding(true);
                soundtrack.stop();
                mariVoice.play(true);

                while (player.getCurrentAnswer() != mari.getCorrectAnswer()) {
                    System.out.println("");


                    switch (player.getCurrentAnswer()) {

                        case 1:
                            if (player.deadVerifier() == false) {
                                claps.play(true);
                                player.setColliding(false);
                                player.hasKey();
                                mari.getQuizScreen().delete();
                                wrongAnswer.delete();
                                break;
                            }

                        case 2:
                            if (player.deadVerifier() == false) {
                                wrong.play(true);
                                player.beerToHealth();
                                player.setCurrentAnswer(0);
                                wrongAnswer.draw();
                                break;
                            }

                        case 3:
                            if (player.deadVerifier() == false) {
                                wrong.play(true);
                                player.beerToHealth();
                                player.setCurrentAnswer(0);
                                wrongAnswer.draw();
                                break;
                            }
                    }

                    if (player.deadVerifier()) {
                        gameOver.draw();
                        return;
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

    }

    public void startLevel3() {
        player.setCurrentAnswer(0);
        relvinhaRoom = new Room(new Picture(10, 10, "resources/relvinha4.png"));
        relvinhaRoom.getPicture().draw();
        player.updatePosition(230, 400);
        player.refresh(0);
        player.createBeers(player.getHealth());
        player.setCurrentRoom(3);
        player.setCurrentAnswer(0);
        pedroG = new PedroG();
        pedroG.getFace().draw();

        while (true) {
            System.out.println("");

            if (player.collide(player.getRectangle(), pedroG.getRectangle())) {
                pedroG.makeQuestion();

                player.setColliding(true);
                soundtrack.stop();
                pedroVoice.play(true);

                while (player.getCurrentAnswer() != pedroG.getCorrectAnswer()) {
                    System.out.println("");

                    switch (player.getCurrentAnswer()) {
                        case 1:
                            if (player.deadVerifier() == false) {
                                claps.play(true);
                                player.setColliding(false);
                                player.hasKey();
                                pedroG.getQuizScreen().delete();
                                wrongAnswer.delete();
                            }
                            break;

                        case 2:
                            if (player.deadVerifier() == false) {
                                wrong.play(true);
                                player.beerToHealth();
                                player.setCurrentAnswer(0);
                                wrongAnswer.draw();
                                break;
                            }

                        case 3:

                            if (player.deadVerifier() == false) {
                                wrong.play(true);
                                player.beerToHealth();
                                player.setCurrentAnswer(0);
                                wrongAnswer.draw();
                                break;
                            }
                    }
                    if (player.deadVerifier()) {
                        gameOver.draw();
                        return;
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
    }

    public void startLevel4() {
        player.setCurrentAnswer(0);
        player.setCurrentRoom(4);
        breakRoom = new Room(new Picture(10, 10, "resources/weedroom.png"));
        breakRoom.getPicture().draw();
        player.createBeers(player.getHealth());
        player.updatePosition(-400, -280);
        player.refresh(3);
        jojo = new Jojo();
        jojo.getFace().draw();


        while (true) {
            System.out.println("");

            if (player.collide(player.getRectangle(), jojo.getRectangle())) {
                jojo.makeQuestion();
                player.setColliding(true);
                jojo.getQuizScreen();
                soundtrack.stop();
                jojoVoice.play(true);

                while (player.getCurrentAnswer() != jojo.getCorrectAnswer()) {
                    System.out.println("");

                    switch (player.getCurrentAnswer()) {

                        case 1:

                            if (player.deadVerifier() == false) {
                                wrong.play(true);
                                player.beerToHealth();
                                player.setCurrentAnswer(0);
                                wrongAnswer.draw();
                                break;
                            }

                        case 2:
                            if (player.deadVerifier() == false) {
                                wrong.play(true);
                                player.beerToHealth();
                                player.setCurrentAnswer(0);
                                wrongAnswer.draw();
                                break;
                            }

                        case 3:
                            if (player.deadVerifier() == false) {
                                claps.play(true);
                                player.setColliding(false);
                                player.hasKey();
                                weedArrow.draw();
                                jojo.getQuizScreen().delete();
                                wrongAnswer.delete();

                                break;
                            }
                    }

                    if (player.deadVerifier()) {
                        gameOver.draw();
                        return;
                    }
                }

                break;
            }
        }

        soundtrack.play(true);

        while (true) {

            System.out.println("");
            if (player.collide(player.getRectangle(), weed)) {
                weedArrow.delete();
                soundtrack.close();
                bobmarley.play(true);
                player.cannabisOn();
                break;
            }
        }

        while (true) {
            System.out.println("");
            if (player.getRectangle().getX() + player.getRectangle().getWidth() == 490 && player.getRectangle().getY() == 360 && player.getIsHigh()) {
                jojo.getRectangle().delete();
                wonGame.draw();
                break;
            }
        }
        if (!player.deadVerifier()) {
            player.setColliding(true);
            bobmarley.close();
            wonGame.draw();
            victorySound.play(true);
            return;
        }


    }
}