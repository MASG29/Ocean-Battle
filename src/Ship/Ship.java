package Ship;

import Grid.Grid;
import Grid.Position;
import Static.Extra;
import com.codeforall.simplegraphics.graphics.Color;

public abstract class Ship implements Movable {

    private Grid grid;
    private int life;
    private Color color;
    private Ship[] enemys;
    private Ship[] friendlys;
    private ShipType shipType;
    private Position position;



    public Ship(Grid grid, Color color){
        this.grid = grid;
        this.color = color;
        this.shipType = ShipType.defineShipType();
        this.position = new Position(grid, color);
        this.life = shipType.health;


    }
    public void move(){

        if (this.life == 0){
            return;
        }

        int condition = Extra.random(3);
        int keepDirection = Extra.random(5);
        switch (condition){
            case 0:
                this.position.moveRight(keepDirection);
                break;
            case 1:
                this.position.moveLeft(keepDirection);
                break;
            case 2:
                this.position.moveUp(keepDirection);
                break;
            case 3:
                this.position.moveDown(keepDirection);
            default:
                break;
        }
    }

    public void takeDamage(int damage) {
        this.life = Math.max(0, this.life - damage);
        if (isSunk()) this.position.setColor(Color.GRAY); // mudar para cinzento
    }

    public void repairing(int repairAmount){
        this.life = Math.max(shipType.health, this.life + repairAmount);

    }

    public int getLife() { return life; }
    public boolean isSunk() { return life <= 0; }

    public ShipType getShipType(){
        return this.shipType;
    }

    public Position getPosition(){
        return this.position;
    }










}
