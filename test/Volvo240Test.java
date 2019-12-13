import Model.Volvo240;
import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {
    Volvo240 volvo = new Volvo240();

    @Test
    public void speedFactor() {
        System.out.print(volvo.speedFactor());
        assertTrue(volvo.speedFactor()==1.25);
    }
}