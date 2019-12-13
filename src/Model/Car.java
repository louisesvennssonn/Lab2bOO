package Model;

import java.awt.*;

/**
 * Abstract class to hold values specific for vehicle car
 */

public abstract class Car extends Vehicle {


    public Car(double enginePower, double currentSpeed, Color color, String modelName, double x, double y,
               Direction direction, boolean isLoaded) {
        super(enginePower, currentSpeed, color, modelName, x, y, direction, isLoaded);
    }
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}