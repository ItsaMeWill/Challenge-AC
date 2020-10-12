package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.rooms.MacRoom;
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


            Text text1 = new Text(200,200,"Tell me ur name");
            int pX, pY, mX, mY;

            pX = player.getPosition().getCol();
            pY = player.getPosition().getRow();
            mX = macRoom.getRicardo().getPosition().getCol();
            mY = macRoom.getRicardo().getPosition().getRow();
            if (player.getFace().getX() == macRoom.getRicardo().getFace().getX()){
                System.out.println("teste");
            }
            System.out.println(pX);
            System.out.println(pY);
            System.out.println(mX);
            System.out.println(mY);
            /*System.out.println(player.getPosition().getCol());
            System.out.println(player.getPosition().getRow());
            System.out.println(macRoom.getRicardo().getPosition().getRow());
            System.out.println(macRoom.getRicardo().getPosition().getCol());*/

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
                    System.out.println(player.getPosition().getRow());
                }
                if (keyboardEvent == up && movable.getY() > 30) {
                  player.moveUp();
                    System.out.println(player.getPosition().getRow());
                }
                if (keyboardEvent == right && movable.getX() < 435) {
                   player.moveRight();
                    System.out.println(player.getPosition().getCol());
                }
                if (keyboardEvent == left && movable.getX() > 30){
                    player.moveLeft();
                    System.out.println(player.getPosition().getCol());
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
