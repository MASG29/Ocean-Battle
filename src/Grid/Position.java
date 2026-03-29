package Grid;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

public class Position {

    private int col;
    private int row;
    private Rectangle rectangle;
    private Grid grid;


    public Position(Grid grid, Color color) {

        this.grid = grid;
        int randomCol = (int) (Math.random() * grid.getCols());
        int randomRow = (int) (Math.random() * grid.getRows());
        this.col = randomCol;
        this.row = randomRow;

        this.rectangle =  new Rectangle(grid.columnToX(col), grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        rectangle.setColor(color);
        rectangle.fill();
    }

    public void moveRight(int keepDirection){
        if (col + keepDirection >= grid.getCols()){
            return;
        }
        for (int i = 0; i < keepDirection; i++) {
            rectangle.translate(grid.getCellSize(),0);
            col += 1;
        }
    }
    public void moveLeft(int keepDirection){
        if (col - keepDirection < 0){
            return;
        }
        for (int i = 0; i < keepDirection; i++) {
            rectangle.translate(-1 * grid.getCellSize(), 0);
            col -= 1;
        }
    }
    public void moveUp(int keepDirection){
        if (row - keepDirection < 0){
            return;
        }
        for (int i = 0; i < keepDirection; i++) {
            rectangle.translate(-1 * grid.getCellSize(), 0);
            row -= 1;
        }
    }
    public void moveDown(int keepDirection){
        if (col + keepDirection >= grid.getCols()){
            return;
        }
        for (int i = 0; i < keepDirection; i++) {
            rectangle.translate(grid.getCellSize(), 0);
            col += 1;
        }
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
