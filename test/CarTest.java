import Model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void startEngine() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed() >0.099 && volvo.getCurrentSpeed()< 0.11);
    }

    @Test
    public void stopEngine() {
        Volvo240 volvo = new Volvo240();
        volvo.stopEngine();
        assertTrue(volvo.getCurrentSpeed()== 0);
    }

    @Test
    public void gas() {
        Volvo240 volvo= new Volvo240();
        volvo.startEngine();
        volvo.gas(1.0);
        volvo.move();
        System.out.print(volvo.getY());
        assertTrue(volvo.getY() == 1.35);

    }

    @Test
    public void brake() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(0.5);
        volvo.brake(0.5);
        assertTrue(volvo.getY()== 0);
    }

    @Test
    public void move() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.move();
        assertTrue(saab.getY() == 0.1);
    }

    @Test
    public void turnLeft() {
        Volvo240 volvo = new Volvo240();
        System.out.print(volvo.getDirection());
        volvo.turnLeft();
        System.out.print(volvo.getDirection());
       // assertTrue(volvo.getDirection() == .Direction.LEFT);
    }

    @Test
    public void turnRight() {
        Volvo240 volvo = new Volvo240();
        System.out.print(volvo.getDirection());
        volvo.turnRight();
        System.out.print(volvo.getDirection());
        //assertTrue(volvo.getDirection() == Car.Direction.RIGHT);
    }
}