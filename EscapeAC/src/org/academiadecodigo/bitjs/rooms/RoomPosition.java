package org.academiadecodigo.bitjs.rooms;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.bitjs.rooms.*;

public class RoomPosition {

    private int col;
    private int row;
    private int width;
    private int height;
    private final int cellSize = 10;

    public RoomPosition(int col, int row) {
        this.col = col;
        this.row = row;
        this.width = col * cellSize;
        this.height = row * cellSize;
    }

    public int getCol() {
        return col;
    }

    public int getRow(){
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

}
