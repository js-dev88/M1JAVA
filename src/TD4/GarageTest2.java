package TD4;

import static org.junit.Assert.*;

import org.junit.Test;

public class GarageTest2 {

    @Test
    public void garageAddRemove() {
        Garage garage = new Garage();
        garage.add(new Car("Ford", "42abc75", 25000));
        garage.remove(new Car("Ford", "42abc75", 25000));
        assertNull(garage.firstCarByBrand("Ford"));
    }

    

}
