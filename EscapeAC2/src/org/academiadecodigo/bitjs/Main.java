package org.academiadecodigo.bitjs;

import org.academiadecodigo.bitjs.enemy.Question;
import org.academiadecodigo.bitjs.enemy.Ricardo;
import org.academiadecodigo.bitjs.player.Game;
import org.academiadecodigo.bitjs.rooms.MacRoom;
import org.academiadecodigo.bitjs.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {

    public static void main(String[] args) {



        Game game1 = new Game();
       //game1.startLevel1();

Ricardo ri = new Ricardo();
ri.makeQuestion(Question.QUESTION1);



    }
}
