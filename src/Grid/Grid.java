package Grid;


import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;
import com.codeforall.simplegraphics.graphics.Text;

public class Grid {
 public static final int BORDER = 15;
    private int cols;
    private int rows;
    private int cellSize = 25;


    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init(){
        Rectangle Border = new Rectangle(BORDER, BORDER, cols * cellSize, rows * cellSize);
        Border.setColor(Color.CYAN);
        Border.fill();
        /*Text teste = new Text(80,80,"Teste: Amarelo\n Teste: TESTE");
        teste.grow(50,50);
        teste.draw();

         */

    }



    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int rowToY(int row) {
        return BORDER + cellSize * row;
    }

    public int columnToX(int col) {
        return BORDER + cellSize * col;
    }

}
