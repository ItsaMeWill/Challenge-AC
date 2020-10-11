/*package org.academiadecodigo.bitjs.grids;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RoomGrid {





        public static final int PADDING = 10;

        private int col, rows;
        private int cellSize = 10;
        private Rectangle canvas;

        public RoomGrid(int cols, int rows){
            this.col = cols;
            this.rows = rows;
        }

        @Override
        public void init() {
            this.canvas = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
            canvas.draw();
        }

        @Override
        public int getCols() {
            return this.col;
        }

        @Override
        public int getRows() {
            return this.rows;
        }

        public int getWidth() {
            return this.getCols()*getCellSize();
        }

        public int getHeight() {
            return this.getRows()*getCellSize();
        }

        public int getX() {
            return this.canvas.getX();
        }

        public int getY() {
            return this.canvas.getY();
        }

        public int getCellSize() {
            return this.cellSize;
        }

        public int getPadding(){
            return PADDING;
        }

        @Override
        public GridPosition makeGridPosition(int col, int row) {
            return new SimpleGfxGridPosition(col, row, this);
        }

        public int rowToY(int row) {
            return PADDING + cellSize * row;
        }

        public int columnToX(int column) {
            return PADDING + cellSize * column;
        }
    }

}
*/