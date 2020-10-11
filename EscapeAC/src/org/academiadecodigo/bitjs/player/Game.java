package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.MCS;
import org.academiadecodigo.bitjs.rooms.MacRoom;
import org.academiadecodigo.bitjs.rooms.RoomPosition;
import org.academiadecodigo.simplegraphics.graphics.Movable;
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


        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();

        public Game() {

            moves();
        }

        public void start(){
            macRoom = new MacRoom();
            player = new Player();
            movable = player.getFace();
            //Rectangle tables = new Rectangle(140, 200,270,200);
            //tables.fill();
            Text text1 = new Text(200,200,"Tell me ur name");

            if(player.getFace().getX()==macRoom.getRicardo().getFace().getX() || player.getFace().getY()==macRoom.getRicardo().getFace().getY()){
                text1.draw();
            }

        }

        public void moves(){
            Keyboard keyboard = new Keyboard(this);

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
                   player.moveDown();
                }
                if (keyboardEvent == up && movable.getY() > 30) {
                  player.moveUp();
                }
                if (keyboardEvent == right && movable.getX() < 435) {
                   player.moveRight();
                }
                if (keyboardEvent == left && movable.getX() > 30){
                    player.moveLeft();
                }
            }


        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            moving(keyboardEvent);



        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
            //  movable.translate(-5,-5);
        }


}
