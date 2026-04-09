import Grid.Grid;
import Ship.Ship;
import Ship.ShipFactory;

public class Battle {

    private Grid grid;
    private int playersPerTeam = 10;
    private Ship[] friendlyShips;
    private Ship[] enemyShips;
    private int delay;

    public Battle(int cols, int rows, int delay) {
        this.grid = new Grid(cols, rows);
        this.delay = delay;
    }

    public void init() {
        grid.init();

        friendlyShips = new Ship[playersPerTeam];
        enemyShips = new Ship[playersPerTeam];

        // First friendly ship is guaranteed to be a mechanic
        friendlyShips[0] = ShipFactory.getNewFriendlyMechanic(grid);
        for (int i = 1; i < playersPerTeam; i++) {
            friendlyShips[i] = ShipFactory.getNewFriendlyShip(grid);
        }

        for (int j = 0; j < playersPerTeam; j++) {
            enemyShips[j] = ShipFactory.getNewEnemyShip(grid);
        }
    }

    public void start() throws InterruptedException {
        while (!isGameOver()) {
            Thread.sleep(delay);
            moveAllShips();
            checkCombat();
            checkRepairs();
        }
        showWinner();
    }

    private void moveAllShips() {
        for (Ship ship : friendlyShips) {
            ship.move();
        }
        for (Ship ship : enemyShips) {
            ship.move();
        }
    }

    private void checkCombat() {
        for (Ship friendly : friendlyShips) {
            if (friendly.isSunk()) {
                continue;
            }
            for (Ship enemy : enemyShips) {
                if (enemy.isSunk()) {
                    continue;
                }
                if (friendly.getPosition().samePosition(enemy.getPosition())) {
                    friendly.attack(enemy);
                    enemy.attack(friendly);
                }
            }
        }
    }

    private void checkRepairs() {
        repairTeam(friendlyShips);
        repairTeam(enemyShips);
    }

    private void repairTeam(Ship[] team) {
        for (Ship repairer : team) {
            if (repairer.isSunk() || !repairer.canRepair()) {
                continue;
            }
            for (Ship ally : team) {
                if (ally == repairer || ally.isSunk()) {
                    continue;
                }
                if (repairer.getPosition().samePosition(ally.getPosition())) {
                    repairer.repair(ally);
                }
            }
        }
    }

    private boolean isGameOver() {
        return allSunk(friendlyShips) || allSunk(enemyShips);
    }

    private boolean allSunk(Ship[] ships) {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    private void showWinner() {
        if (allSunk(enemyShips)) {
            System.out.println("Os Aliados venceram!");
        } else {
            System.out.println("Os Inimigos venceram!");
        }
    }
}
