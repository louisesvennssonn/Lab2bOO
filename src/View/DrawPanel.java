package View;

import Model.IVehicle;
import Model.SimulationWorld;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private BufferedImage vehicleImage;
    private HashMap<String, BufferedImage> imageMap = new HashMap<>();
    ArrayList<IVehicle> vehicleList;

    // Initializes the panel and reads the images
    DrawPanel(int x, int y, SimulationWorld simulationWorld){
        this.vehicleList = simulationWorld.vehicles;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.black);
        this.populateImageMap();
    }

    /**
     * Generic method to pair the vehicles with their photo
     */

    private void populateImageMap() {
        for(IVehicle vehicle: vehicleList)
        try {
            String modelName = vehicle.getModelName();
            imageMap.put(modelName, ImageIO.read(DrawPanel.class.getResourceAsStream("/" + modelName + ".jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        removeAll();
        revalidate();
        int w= this.getWidth();
        int h = this.getHeight();
        this.setSize(w + 1, h + 1);
        this.setSize(w,h);
        for (IVehicle vehicle : vehicleList) {
            g.drawImage(imageMap.get(vehicle.getModelName()), (int) vehicle.getX(), (int) vehicle.getY(), null); // see javadoc for more info on the parameters
            // g.drawImage(carImage, getX(), getY(), null); // see javadoc for more info on the parameters
        }
    }
}
