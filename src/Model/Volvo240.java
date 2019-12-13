package Model;

import java.awt.*;

/**
 * Class inherited from Car
 * Has it's own methods incrementSpeed and decrementSpeed, speed factor
 * Has a instance variable called "trimFactor"
 */

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;


    public Volvo240(double enginePower, double currentSpeed, Color color, String modelName, double x, double y,
                    Direction direction, boolean isLoaded) {
        super(enginePower, currentSpeed, color, modelName, x, y, direction, isLoaded);
    }

    public Volvo240() {
        super(125, 0,  Color.red, "Volvo240", 0 , 200,  Direction.RIGHT,
                false);
    }
    public Volvo240(int x, int y) {
        super(125, 0,  Color.red, "Volvo240", x , y,  Direction.RIGHT,
                false);
    }

    /**
     * Gets the trimFactor from Car and the returns it
     * @return returns the trim factor for the car
     */
    public static double getTrimFactor() {
        return trimFactor;
    }

    /**
     * Sets the speed factor from the car's trim factor and engine power
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01* trimFactor;
    }



}
