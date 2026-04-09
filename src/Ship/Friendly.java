package Ship;

import Grid.Grid;
import com.codeforall.simplegraphics.graphics.Color;

public class Friendly extends Ship {

    public Friendly(Grid grid) {
        super(grid, Color.MAGENTA);
    }

    public Friendly(Grid grid, ShipType shipType) {
        super(grid, Color.MAGENTA, shipType);
    }

    @Override
    public boolean isFriendly() {
        return true;
    }
}
