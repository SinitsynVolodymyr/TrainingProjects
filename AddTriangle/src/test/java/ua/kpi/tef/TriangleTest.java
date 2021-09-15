package ua.kpi.tef;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle triangle;

    @BeforeEach
    void init(){
        triangle = new Triangle(
                new Point(1,5)
                ,new Point(6,-4)
                ,new Point(-2,1));
    }

    @Test
    void square() {
        assertEquals(triangle.square(),23.5);
    }

    @Test
    void perimeter() {
        assertEquals(triangle.perimeter(),24.729611273043602);
    }

    @Test
    void move() {
        triangle.move(5,-10);
        assertEquals(triangle.square(),23.5);
        assertEquals(triangle.perimeter(),24.729611273043602);
        assertEquals(triangle.getPointA(),new Point(6,-5));
        assertEquals(triangle.getPointB(),new Point(11,-14));
        assertEquals(triangle.getPointC(),new Point(3,-9));
    }
}