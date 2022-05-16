package autotest.lesson4;

import autotest.HW4.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void successCalculationTest() throws Exception {
        Assertions.assertEquals(TriangleArea.calculateArea(0, 0, 0), 2);
    }
}
