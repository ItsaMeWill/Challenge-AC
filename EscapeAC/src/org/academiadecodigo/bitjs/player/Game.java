package org.academiadecodigo.bitjs.player;

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
        public boolean areCollided;
        private Picture Quiz;

        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();

        public Game() {
            macRoom = new MacRoom();
            player = new Player();
            movable = player.getFace();
            moves();
        }

        public void start(){
            macRoom.getPicture().draw();
            macRoom.getRicardo().getFace().draw();
            player.getFace().draw();
            macRoom.getRicardo().getRectangle().draw();

            player.moving();

            while (true){
                player.getRectangle().draw();
              ;
                if (collide(player.getRectangle(),macRoom.getRicardo().getRectangle())){
                    System.out.println("HSHSHSHSH");
                    return;
                }

    if(player.getRectangle().getX()+player.getRectangle().getWidth() > 435 && player.getRectangle().getY()+player.getRectangle().getWidth() == 180){
        Rectangle quiz = new Rectangle(300,300,150,150);
        quiz.fill();
        return;
    }

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
                    if (collide(player.getRectangle(),macRoom.getRicardo().getRectangle())){
                       player.moveDown();
                       player.moveDown();
                    }
                  player.moveUp();
                }
                if (keyboardEvent == right && movable.getX() < 435) {
                   if (collide(player.getRectangle(),macRoom.getRicardo().getRectangle())){
                       player.moveLeft();
                        return;
                    }
                   player.moveRight();
                }
                if (keyboardEvent == left && movable.getX() > 30){

                    if (collide(player.getRectangle(),macRoom.getRicardo().getRectangle())){
                        player.moveRight();
                        return;
                    }
                    player.moveLeft();
                }

            }


        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            moving(keyboardEvent);
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {}



        public boolean collide(Rectangle r1, Rectangle r2){
            if(r1.getX() > r2.getX()+ r2.getWidth() || r1.getX()+ r1.getWidth() < r2.getX() || r1.getY() > r2.getY() + r2.getHeight() || r1.getY()+ r1.getHeight() < r2.getY()){
                return false;
            }
                return true;
        }


}
