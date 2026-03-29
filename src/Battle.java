import Grid.Grid;
import Ship.Ship;
import Ship.ShipFactory;
import org.w3c.dom.ls.LSOutput;

public class Battle  {

    private Grid grid;

    private int totalPlayers = 20;

    public Ship[] ships;

    private int delay;

    public Battle(int cols, int rows, int delay){
        this.grid = new Grid(cols, rows);
        this.delay = delay;
    }

    public void init(){

        grid.init();

        this.ships = new Ship[totalPlayers];
        for (int i = 0; i < totalPlayers / 2; i++) {
            ships[i] = ShipFactory.getNewFriendlyShip(grid);
        }

        for (int j = totalPlayers / 2; j < totalPlayers; j++){
            ships[j] = ShipFactory.getNewEnemyShip(grid);
        }

    }

    public void start() throws InterruptedException {


        while (true){

            Thread.sleep(delay);
            moveAllShips();
        }

    }

    public void moveAllShips(){


        for (Ship ship : ships){
            ship.move();
        }
    }








}
