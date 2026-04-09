package Ship;

public interface Repairable {

    void repair(Ship ally);

    boolean canRepair();
}
