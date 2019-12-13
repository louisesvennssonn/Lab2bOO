package Model;

import Model.Car;

/**
 * Interface for vehicles to implement if they are supposed to be able to load other vehicles
 * @param <T> generic type for vehicle
 */

 public interface Loadable <T>{
    void load(Car car);

    void unload(Car car);

    boolean isCarSizeOk();

    boolean isVehicleAmountOk();

}
