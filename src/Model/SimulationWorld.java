package Model;

import java.util.ArrayList;

public class SimulationWorld {

    public ArrayList<IVehicle> vehicles = new ArrayList<>();

    public void createVehicles() {
        vehicles.add(VehicleFactory.createSaab95(0,0));
        vehicles.add(VehicleFactory.createScania(0,60));
        vehicles.add(VehicleFactory.createVolvo240(0,120));
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle vehicle : vehicles
        ) {
            vehicle.gas(gas);
        }
    }

    public ArrayList<IVehicle> getVehicles() {
        return vehicles;
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    public void liftBed() {
        for (IVehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raiseTruckBed();
            }
        }
    }

    public void lowerBed() {
        for (IVehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lowerTruckBed();
            }
        }
    }

    public void startCar() {
        for (IVehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    public void stopCar() {
        for (IVehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    public void startTurbo() {
        for (IVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    public void turnOffTurbo() {
        for (IVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    public void addVehicle() {
        vehicles.add(VehicleFactory.createRandomCar(0, 60* vehicles.size()-1));

    }

    public void removeCar() {
        if (vehicles.size() > 0) {
            vehicles.remove(vehicles.size() - 1);
        }
        else if (vehicles.size() == 0){
            throw new IllegalArgumentException("Can't remove vehicle when list is empty");
        }

    }
}