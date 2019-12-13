package Model;

import Model.Movable;

public interface IVehicle extends Movable {
    void gas(double amount);

    void brake(double amount);

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    void startEngine();

    void stopEngine();

    double getX();

    double getY();

    String getModelName();

    double getCurrentSpeed();
}
