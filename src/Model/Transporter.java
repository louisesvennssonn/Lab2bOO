package Model;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Transporter extends Vehicle implements TruckBed, Loadable {
    private static boolean truckBedIsDown = false;
    private int carAmount;
    Deque<Car> stack = new ArrayDeque<>();

    public Transporter(double enginePower, double currentSpeed, Color color, String modelName,
                            double x, double y, Direction direction, boolean isLoaded, int carAmount) {
        super(enginePower, currentSpeed, color, modelName, x, y, direction, isLoaded);
        this.carAmount = carAmount;
    }

    /**
     * Method to check the amount of loaded vehicles
     * @return true if the amount is ok to load another vehicle
     */
    @Override
    public boolean isVehicleAmountOk(){
        int maxNCars = 10;
        if(carAmount < maxNCars){
            return true;
        } else{
            throw new IllegalArgumentException("Can't load more vehicles");
        }
    }

    /**
     * Method to load a car and update the amount of loaded vehicles on the transporter
     * @param car makes sure that we only can load a car
     */
    @Override
    public void load(Car car) {
        if (truckBedIsDown && isCarSizeOk() && isDistanceOk() && isVehicleAmountOk()) {
            car.setLoaded(true);
            stack.push(car);
            carAmount++;
        }
    }
    /**
     * Method to unload a car and update the amount of loaded vehicles on the transporter
     * @param car makes sure that we only can unload a car
     */
    @Override
    public void unload(Car car) {
        if (truckBedIsDown ) {
            stack.pop();
            carAmount--;
        }
    }

    /**
     * Method to check if the vehicles size is ok to load on the transporter
     * @return true if the size is ok
     */

    @Override
    public boolean isCarSizeOk(){
        double maxLength= 4.5;
        double maxWidth= 2.5;
        if(maxLength <= getLength() && maxWidth <= getWidth()){
            return true;
        }else {
            throw new IllegalArgumentException("Vehicle is to big");
        }

    }

    /**
     * Method to validate if it's possible to load a car on a transporter
     * @return true if the distance is close enough to load a car
     */

    private boolean isDistanceOk() {
        double distanceX = getX() -super.getX();
        double distanceY = getY() -super.getY();
        if(distanceX <= 1 && distanceX > 0 && distanceY <1){
            return true;
        }
        else return false;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Method to lower a truck bed
     */
    @Override
    public void lowerTruckBed() {
        if (getCurrentSpeed() == 0) {
            truckBedIsDown = true;
        }
    }

    /**
     * Method to raise a truck bed
     */
    @Override
    public void raiseTruckBed() {
        truckBedIsDown = false;
    }

    /**
     * Method to make the vehicle move
     */
    @Override
    public void move() {
        if (!truckBedIsDown) {
            super.move();
            for (Vehicle car : stack) {
                car.setX(getX());
                car.setY(getY());
            }
        }
    }
}