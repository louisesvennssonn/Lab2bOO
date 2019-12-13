import Controller.CarController;
import Model.IVehicle;
import Model.SimulationWorld;
import View.CarView;
import View.SpeedView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        SimulationWorld simulationWorld = new SimulationWorld();
        CarController cc = new CarController(simulationWorld);
        SpeedView speedView = new SpeedView(simulationWorld);

        simulationWorld.createVehicles();

        cc.setFrame(new CarView("CarSim 1.0", simulationWorld));
        cc.getTimer().start();
        speedView.match();
    }
}