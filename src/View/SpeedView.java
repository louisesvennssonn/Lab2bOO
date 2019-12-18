package View;
import Model.IVehicle;
import Model.SimulationWorld;
import javax.swing.*;
import java.awt.*;

/**
 * Class to create a speed view for each vehicle in our list
 */
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

    /**
     * Method with an array to pair the vehicle's speed and model name
     * Uses a for loop to reset the labels as well
     */
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