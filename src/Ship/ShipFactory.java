package Ship;

import Grid.Grid;

public class ShipFactory {


    public static Ship getNewFriendlyShip(Grid grid){
        Friendly f1 = new Friendly(grid);
        return f1;
    }

    public static Ship getNewEnemyShip(Grid grid){
        Enemy e1 =  new Enemy(grid);
        return e1;
    }
}
