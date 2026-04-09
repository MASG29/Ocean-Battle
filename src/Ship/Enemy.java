package Ship;

import Grid.Grid;
import Grid.Position;
import com.codeforall.simplegraphics.graphics.Color;

public class Enemy extends Ship implements  Atacks, Repairable {



    public Enemy(Grid grid) {
        super(grid, Color.YELLOW);

    }

    @Override
    public void atack(Ship target) {

        if(!this.getShipType().canRepair){
            target.takeDamage(getShipType().damage);
        }
    }

    @Override
    public void repair(Ship ally) {

    }
}
