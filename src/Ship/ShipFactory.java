package Ship;

import Grid.Grid;

public class ShipFactory {

    public static Ship getNewFriendlyShip(Grid grid) {
        return new Friendly(grid);
    }

    public static Ship getNewFriendlyMechanic(Grid grid) {
        return new Friendly(grid, ShipType.MECHANIC);
    }

    public static Ship getNewEnemyShip(Grid grid) {
        return new Enemy(grid);
    }

    public static Ship getNewEnemyMechanic(Grid grid) {
        return new Enemy(grid, ShipType.MECHANIC);
    }
}
