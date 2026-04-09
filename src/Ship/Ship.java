package Ship;

import Grid.Grid;
import Grid.Position;
import Static.Extra;
import com.codeforall.simplegraphics.graphics.Color;

public abstract class Ship implements Atacks, Repairable, Movable {

    private static final int REPAIR_AMOUNT = 15;

    private Grid grid;
    private int life;
    private int maxLife;
    private Color color;
    private ShipType shipType;
    private Position position;

    public Ship(Grid grid, Color color) {
        this(grid, color, ShipType.defineShipType());
    }

    public Ship(Grid grid, Color color, ShipType shipType) {
        this.grid = grid;
        this.color = color;
        this.shipType = shipType;
        this.life = shipType.health;
        this.maxLife = shipType.health;
        this.position = new Position(grid, color);
    }

    @Override
    public void move() {
        if (isSunk()) {
            return;
        }

        int condition = Extra.random(4);
        int keepDirection = Extra.random(5);

        switch (condition) {
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
                break;
            default:
                break;
        }
    }

    @Override
    public void attack(Ship target) {
        if (!isSunk() && canAttack() && !target.isSunk()) {
            target.takeDamage(shipType.damage);
        }
    }

    @Override
    public boolean canAttack() {
        return shipType.damage > 0;
    }

    @Override
    public void repair(Ship ally) {
        if (!isSunk() && canRepair() && !ally.isSunk() && ally.life < ally.maxLife) {
            ally.heal(REPAIR_AMOUNT);
        }
    }

    @Override
    public boolean canRepair() {
        return shipType.canRepair;
    }

    public void takeDamage(int amount) {
        this.life -= amount;
        if (this.life < 0) {
            this.life = 0;
        }
        if (isSunk()) {
            this.position.setColor(Color.GRAY);
        }
    }

    public void heal(int amount) {
        if (isSunk()) {
            return;
        }
        this.life += amount;
        if (this.life > maxLife) {
            this.life = maxLife;
        }
    }

    public boolean isSunk() {
        return this.life <= 0;
    }

    public int getLife() {
        return this.life;
    }

    public int getDamage() {
        return shipType.damage;
    }

    public ShipType getShipType() {
        return this.shipType;
    }

    public Position getPosition() {
        return this.position;
    }

    public abstract boolean isFriendly();






}
