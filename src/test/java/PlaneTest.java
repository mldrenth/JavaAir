import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.TWINTURBOPROPS);
    }

    @Test
    public void hasPlaneType(){
        assertEquals(PlaneType.TWINTURBOPROPS, plane.getPlaneType());
    }

    @Test
    public void hasCapacity(){
        assertEquals(6, plane.getPlaneType().getCapacity());
    }

    @Test
    public void hasTotalWeight(){
        assertEquals(6531, plane.getPlaneType().getTotalWeight());
    }

}
