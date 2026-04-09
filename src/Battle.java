import Grid.Grid;
import Ship.Ship;
import Ship.ShipFactory;
import Ship.Friendly;
import Ship.Enemy;
import Ship.Atacks;
import Ship.Repairable;

public class Battle  {

    private Grid grid;

    private int totalPlayers = 20;

    public Ship[] ships;

    private int delay;

    private Ship[] enemys;

    private Ship[] friendlys;

    public Battle(int cols, int rows, int delay){
        this.grid = new Grid(cols, rows);
        this.delay = delay;
        this.friendlys = new Friendly[totalPlayers / 2];
        this.enemys = new Enemy[totalPlayers / 2];
    }

    public void init(){

        grid.init();

        this.ships = new Ship[totalPlayers];
        for (int i = 0; i < totalPlayers / 2; i++) {
            Friendly temp;
            temp = ShipFactory.getNewFriendlyShip(grid);
            ships[i] = temp;
            friendlys[i] = temp;
        }

        for (int j = totalPlayers / 2; j < totalPlayers; j++){
            Enemy temp;
            temp = ShipFactory.getNewEnemyShip(grid);
            ships[j] = temp;
            enemys[j - totalPlayers / 2] = temp;
        }

    }


    public void start() throws InterruptedException {

        while (!allSunk(friendlys) && !allSunk(enemys)) {
            Thread.sleep(delay);
            moveAllShips();
            checkCombat();   // ← falta
            checkRepair();   // ← falta
        }

        if (allSunk(enemys)) System.out.println("Aliados ganharam!");
        else System.out.println("Inimigos ganharam!");

    }

    public void moveAllShips(){

        for (Ship ship : ships){
            ship.move();
        }
    }
    private boolean samePosition(Ship a, Ship b) {
        return a.getPosition().getCol() == b.getPosition().getCol()
                && a.getPosition().getRow() == b.getPosition().getRow();
    }

    private void checkCombat() {
        for (Ship friendly : friendlys) {
            for (Ship enemy : enemys) {
                if (!friendly.isSunk() && !enemy.isSunk() && samePosition(friendly, enemy)) {

                    if (friendly instanceof Atacks) {
                        ((Atacks) friendly).atack(enemy);
                    }

                    if (enemy instanceof Atacks) {
                        ((Atacks) enemy).atack(friendly);
                    }

                }
            }
        }
    }

    private void checkRepair() {
        for (Ship mechanic : friendlys) {
            for (Ship ally : friendlys) {
                if (mechanic != ally && !mechanic.isSunk() && !ally.isSunk()
                        && samePosition(mechanic, ally)) {

                    if (mechanic instanceof Repairable) {
                        ((Repairable) mechanic).repair(ally);
                    }

                }
            }
        }
        // mesma coisa para os inimigos
        for (Ship mechanic : enemys) {
            for (Ship ally : enemys) {
                if (mechanic != ally && !mechanic.isSunk() && !ally.isSunk()
                        && samePosition(mechanic, ally)) {

                    if (mechanic instanceof Repairable) {
                        ((Repairable) mechanic).repair(ally);
                    }

                }
            }
        }
    }

    private boolean allSunk(Ship[] ships) {
        for (Ship s : ships) {
            if (!s.isSunk()) return false;
        }
        return true;
    }

}
