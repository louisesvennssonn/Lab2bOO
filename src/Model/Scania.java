package Model;

import java.awt.*;

public class Scania extends Car implements TruckBed {
    private static double truckBedAngle;

    public Scania(double enginePower, double currentSpeed, Color color, String modelName, double x, double y,
                    Direction direction, boolean isLoaded) {
        super(enginePower, currentSpeed, color, modelName, x, y, direction, isLoaded);
    }

    public Scania(){
        super(90, 0,  Color.red, "Scania", 0, 100, Direction.RIGHT,
                false);
    }

    public Scania(int x, int y){
        super(90, 0,  Color.red, "Scania", x, y, Direction.RIGHT,
                false);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    private boolean allowedBedAngle(double truckBedAngle) {
        if (truckBedAngle <= 70 || 0 < truckBedAngle) {
            return true;
        } else
            throw new IllegalArgumentException("Invalid angle for Truck bed");
    }

    @Override
    public void lowerTruckBed() {
        if (truckBedAngle > 0) {
            if (getCurrentSpeed() == 0) {
                truckBedAngle = truckBedAngle - 1;
            }
        }
    }

    @Override
    public void raiseTruckBed() {
        if (allowedBedAngle(truckBedAngle)) {
            if (getCurrentSpeed() == 0) {
                truckBedAngle = truckBedAngle + 1;
            }
        }
    }
    @Override
    public void move (){
        if(truckBedAngle == 0){
            super.move();
        }
    }
}
