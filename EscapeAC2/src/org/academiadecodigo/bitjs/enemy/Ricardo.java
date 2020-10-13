package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ricardo extends MCS {

        private Picture face;

        private Rectangle rectangle;

        public Ricardo(){
            super(new Picture(80,80, "resources/player.png"), new Rectangle(80,80,50,50));
        }

        public Picture getFace() {
            return face;
        }

        public Rectangle getRectangle() {
            return rectangle;
        }

    }


