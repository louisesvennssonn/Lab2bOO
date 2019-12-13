package Model;

import java.awt.*;


/**
 * Class inherited from Car
 * Has it's own methods incrementSpeed and decrementSpeed, speed factor
 */

public class Saab95 extends Car {
    private final static int nrDoors = 2; // Number of doors on the vehicle
    private boolean turboOn;

    public Saab95(double enginePower, double currentSpeed, Color color, String modelName, double x, double y,
                    Direction direction, boolean isLoaded, boolean turboOn) {
        super(enginePower, currentSpeed, color, modelName, x, y, direction, isLoaded);
        this.turboOn = turboOn;
    }

    public Saab95 () {
        super(125, 0, Color.red, "Saab95", 0, 0, Direction.RIGHT, false);
        stopEngine();
        turboOn = false;
    }
    public Saab95 (int x, int y) {
        super(125, 0, Color.red, "Saab95", x, y, Direction.RIGHT, false);
        stopEngine();
        turboOn = false;
    }
    /**
     * Turns on the turbo
     */
    void setTurboOn() {turboOn = true;}

    /**
     * turns off the turbo
     */

    void setTurboOff() {turboOn = false;}

    /**
     * Sets the speedFactor depending on the car's turbo and enginePower
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
