package Ship;

import Grid.Grid;
import com.codeforall.simplegraphics.graphics.Color;

public class Enemy extends Ship {

    public Enemy(Grid grid) {
        super(grid, Color.YELLOW);
    }

    public Enemy(Grid grid, ShipType shipType) {
        super(grid, Color.YELLOW, shipType);
    }

    @Override
    public boolean isFriendly() {
        return false;
    }
}
