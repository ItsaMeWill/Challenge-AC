package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ricardo extends MCS {

        private Picture face;

        private Rectangle rectangle;

        public Ricardo(Picture face, Rectangle rectangle){
            this.face = face;
            this.rectangle = rectangle;
        }

        public Picture getFace() {
            return face;
        }

        public Rectangle getRectangle() {
            return rectangle;
        }

    }


