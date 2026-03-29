package Ship;

import Grid.Grid;
import Grid.Position;
import com.codeforall.simplegraphics.graphics.Color;

public class Enemy extends Ship  {



    public Enemy(Grid grid) {
        super(grid, Color.YELLOW);

    }

    @Override
    public void atack() {

    }

    @Override
    public void repairable() {

    }
}
