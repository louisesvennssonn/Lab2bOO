package Model;

import java.util.Random;

public class VehicleFactory {
    static IVehicle createScania(int x, int y){
        return new Scania(x, y);
    }

    static IVehicle createSaab95(int x, int y){
        return new Saab95(x,y);
    }

    static IVehicle createVolvo240(int x, int y){
        return new Volvo240(x,y);
    }

    static IVehicle createRandomCar(int x, int y){
        Random random = new Random();
        int randCar = random.nextInt(3);

        switch(randCar){
            case 0:
                return createSaab95(x,y);
            case 1:
                return createVolvo240(x,y);
            case 2:
                return createScania(x, y);
            default:
                return createSaab95(x,y);
        }
    }
}
