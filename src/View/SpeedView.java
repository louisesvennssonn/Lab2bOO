package View;

import Model.Car;
import Model.IVehicle;
import Model.SimulationWorld;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView extends JPanel {

    SimulationWorld simulationWorld;
    JLabel [] labels  = new JLabel [10];

    public SpeedView(SimulationWorld simulationWorld){
        this.simulationWorld = simulationWorld;
        this.setDoubleBuffered(true);
        this.setBackground(Color.LIGHT_GRAY);
        for(int i = 0; i < labels.length; i++){
            labels [i] = new JLabel();
            this.add(labels[i]);
        }
        match();
    }
    public void match() {
        for(int i = 0; i< labels.length; i++){
            labels[i].setText("");
        }
        for (int i = 0; i < simulationWorld.vehicles.size(); i++) {
            IVehicle vehicle = simulationWorld.vehicles.get(i);
            String model = vehicle.getModelName();
            double speed = vehicle.getCurrentSpeed();
            labels [i].setText(model + " " + speed);

        }
    }
}