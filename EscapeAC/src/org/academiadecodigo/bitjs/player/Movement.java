package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Movement implements KeyboardHandler {



        private Movable movable;
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();

        public Movement(Movable movable) {
            this.movable = movable;
            moves();


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

        public void moving(KeyboardEvent keyboardEvent){



            if(keyboardEvent == down){
                movable.translate(0,15);
            } else if (keyboardEvent == up){
                movable.translate(0,-15);
            } else if (keyboardEvent == right){
                movable.translate(15,0);
            } else {
                movable.translate(-15,0);
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
