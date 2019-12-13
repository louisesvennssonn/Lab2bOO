import Model.Saab95;
import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {
    Saab95 saab = new Saab95();

    @Test
    public void speedFactor() {
        assertTrue(saab.speedFactor()==1.25);
    }
}