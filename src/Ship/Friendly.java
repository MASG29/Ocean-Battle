package Ship;

import Grid.Grid;
import Grid.Position;
import com.codeforall.simplegraphics.graphics.Color;

public class Friendly extends Ship implements  Atacks, Repairable {

    public Friendly(Grid grid) {
        super(grid, Color.MAGENTA);
    }

    @Override
    public void atack(Ship target) {

        if(!this.getShipType().canRepair){
            target.takeDamage(getShipType().damage);
        }
    }

    @Override
    public void repair(Ship ally) {

        if(this.getShipType().canRepair){
            ally.repairing(getShipType().damage);
        }
    }
}
