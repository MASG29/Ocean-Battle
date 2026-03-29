package Ship;

import Grid.Grid;
import Grid.Position;
import com.codeforall.simplegraphics.graphics.Color;

public class Friendly extends Ship{

    public Friendly(Grid grid) {
        super(grid, Color.MAGENTA);
    }

    @Override
    public void atack() {

    }

    @Override
    public void repairable() {

    }
}
