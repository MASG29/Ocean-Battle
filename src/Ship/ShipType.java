package Ship;

public enum ShipType {
    TANK("Tank", 200, 10, false),
    PIRATE("Pirate", 100, 15, false),
    MECHANIC("Mechanic", 150, 0, true);

    protected String name;
    protected int health;
    protected int damage;
    protected boolean canRepair;

    ShipType(String name, int health, int damage, boolean canRepair) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.canRepair = canRepair;
    }

    protected static ShipType defineShipType() {
        double roller = Math.random();

        if (roller <= 0.4) {
            return ShipType.TANK;
        } else if (roller > 0.4 && roller <= 0.8) {
            return ShipType.PIRATE;
        } else return ShipType.MECHANIC;

    }



}
