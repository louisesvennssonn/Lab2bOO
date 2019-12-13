package Model;

import Model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Garage <T extends Vehicle>  {
    private int maxNCars;
    private List<T> vehiclesInStorage = new ArrayList<>();

    protected Garage(int maxNCars) {
        this.maxNCars = maxNCars;
    }

    protected List<T> getVehiclesInStorage() {
        return vehiclesInStorage;
    }



    /**
     * method to load vehicles to workshop
     * can only load if max number isn't exceeded
     * @param car generic vehicle
     */


    protected void load(T car){
        if(((vehiclesInStorage.size() - 1) < maxNCars) && !car.isLoaded()){
            car.setLoaded(true);
            vehiclesInStorage.add(car);
        }
    }

    /**
     * method to unload vehicles from workshop
     * @param car generic vehicle
     */
    protected void unload(T car){
        car = vehiclesInStorage.remove(vehiclesInStorage.size() - 1);
        car.setLoaded(false);
    }


}
