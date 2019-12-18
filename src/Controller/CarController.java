package Controller;

import Model.IVehicle;
import Model.SimulationWorld;
import View.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    private CarView frame;

    /**
     * The delay (ms) corresponds to 20 updates a sec (hz)
     */
    private final int delay = 50;
    /**
     * The timer is started with an listener (see below) that executes the statements
     *  each step between delays.
     */
    private Timer timer = new Timer(delay, new TimerListener());

    private ArrayList<IVehicle> vehicles;

    public CarController (SimulationWorld simulationWorld){
        this.vehicles = simulationWorld.getVehicles();
    }

    public Timer getTimer() {
        return timer;
    }

    public void setFrame(CarView frame) {
        this.frame = frame;
    }
    /** Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                // repaint() calls the paintComponent method of the panel
                frame.repaint();
                if (x > 700 || x < 0) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }
            }
            frame.speedViewMatch();
        }
    }
}
