package Model;

import java.awt.*;

/**
 *  Superclass for other vehicles
 *  Implements the interface movable
 *  Holds an Override from movable
 *  Holds setter and getter for variables
 */

public abstract class Vehicle implements IVehicle {

    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private String modelName; // The vehicle model name
    private double x;
    private double y;
    private Direction direction;
    private boolean isLoaded;
    private double width;
    private double length;

    public Vehicle(double enginePower, double currentSpeed, Color color, String modelName, double x, double y,
                        Direction direction, boolean isLoaded) {
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.isLoaded = isLoaded;
    }

    public Direction getDirection() { return direction; }

    public void setDirection(Direction direction) { this.direction = direction; }

    public boolean isLoaded() { return isLoaded; }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public String getModelName() {
        return modelName;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the engine and sets speed to 0.1.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the vehicle's engine and sets speed to 0
     */

    public void stopEngine() { currentSpeed = 0; }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    private void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed >= 0 && currentSpeed <= enginePower) {
            this.currentSpeed = currentSpeed;
        }
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    /**
     * This Speedfactor method exists to complement the increment and decrement speed methods.
     *
     * @return
     */
    protected abstract double speedFactor();


    /**
     * This method increments the speed.
     *
     * @param amount can only be a specific value.
     */
    public void incrementSpeed(double amount) {
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * This method slows the car down.
     *
     * @param amount
     */
    public void decrementSpeed(double amount) {
            setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    /**
     * Method used to only increment speed if it is a certain amount.
     *
     * @param amount can only be a specific value.
     */
    public void gas(double amount) {
        if (isValidAmount(amount)) {
            incrementSpeed(amount);
        }
    }

    /**
     * Method used to only decrement speed if it is a certain amount.
     *
     * @param amount can only be a specific value.
     */
    public void brake(double amount) {
        if (isValidAmount(amount)) {
            decrementSpeed(amount);
        }
    }

    public boolean isValidAmount(double amount) {
        if (amount <= 1.0 && amount >= 0) {
        }
        return true;
    }
    /**
     * Move is a method that chooses different speeds depending on what direction the car is at the moment.
     */
    @Override
    public void move() {
        if(isLoaded==false) {
            if (direction == Direction.UP) {
                y = y + currentSpeed;
            }
            if (direction == Direction.DOWN) {
                y = y - currentSpeed;
            }
            if (direction == Direction.LEFT) {
                x = x - currentSpeed;
            }
            if (direction == Direction.RIGHT) {
                x = x + currentSpeed;
            }
        }
    }

    /**
     * TurnLeft switches the cars direction one step to the left.
     */
    @Override
    public void turnLeft() {
        if (direction == Direction.UP) {
            direction = Direction.LEFT;
        } else if (direction == Direction.DOWN) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.LEFT) {
            direction = Direction.DOWN;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.UP;
        }
    }

    /**
     * TurnRight switches the cars direction one step to the right.
     */
    @Override
    public void turnRight() {
        if (direction == Direction.UP) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.DOWN) {
            direction = Direction.LEFT;
        } else if (direction == Direction.LEFT) {
            direction = Direction.UP;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.DOWN;
        }
    }
}
