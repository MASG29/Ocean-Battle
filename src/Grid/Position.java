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
        this.col = (int) (Math.random() * grid.getCols());
        this.row = (int) (Math.random() * grid.getRows());
        this.rectangle = new Rectangle(grid.columnToX(col), grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        rectangle.setColor(color);
        rectangle.fill();
    }

    public void moveRight(int keepDirection) {
        if (col + keepDirection >= grid.getCols()) {
            return;
        }
        for (int i = 0; i < keepDirection; i++) {
            rectangle.translate(grid.getCellSize(), 0);
            col++;
        }
    }

    public void moveLeft(int keepDirection) {
        if (col - keepDirection < 0) {
            return;
        }
        for (int i = 0; i < keepDirection; i++) {
            rectangle.translate(-grid.getCellSize(), 0);
            col--;
        }
    }

    public void moveUp(int keepDirection) {
        if (row - keepDirection < 0) {
            return;
        }
        for (int i = 0; i < keepDirection; i++) {
            rectangle.translate(0, -grid.getCellSize());
            row--;
        }
    }

    public void moveDown(int keepDirection) {
        if (row + keepDirection >= grid.getRows()) {
            return;
        }
        for (int i = 0; i < keepDirection; i++) {
            rectangle.translate(0, grid.getCellSize());
            row++;
        }
    }

    public void setColor(Color color) {
        rectangle.setColor(color);
        rectangle.fill();
    }

    public boolean samePosition(Position other) {
        return this.col == other.col && this.row == other.row;
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
