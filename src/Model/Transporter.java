package Model;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Transporter extends Vehicle implements TruckBed, Loadable, RampState {
    private static boolean truckBedIsDown = false;
    private int carAmount;
    Deque<Car> stack = new ArrayDeque<>();

    public Transporter(double enginePower, double currentSpeed, Color color, String modelName,
                            double x, double y, Direction direction, boolean isLoaded, int carAmount) {
        super(enginePower, currentSpeed, color, modelName, x, y, direction, isLoaded);
        this.carAmount = carAmount;
    }

    @Override
    public boolean isVehicleAmountOk(){
        int maxNCars = 10;
        if(carAmount < maxNCars){
            return true;
        } else{
            throw new IllegalArgumentException("Can't load more vehicles");
        }
    }

    @Override
    public void load(Car car) {
        if (truckBedIsDown && isCarSizeOk() && isDistanceOk() && isVehicleAmountOk()) {
            car.setLoaded(true);
            stack.push(car);
            carAmount++;
        }
    }

    @Override
    public void unload(Car car) {
        if (truckBedIsDown ) {
            stack.pop();
            carAmount--;
        }
    }

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

    @Override
    public void lowerTruckBed() {
        if (getCurrentSpeed() == 0) {
            truckBedIsDown = true;
        }
    }

    @Override
    public void raiseTruckBed() {
        truckBedIsDown = false;
    }

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