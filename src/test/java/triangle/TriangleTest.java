package triangle;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {

    Triangle triangle;

    @DataProvider(name = "getTriangle")
    public Object[][] getTriangle() {
        return new Object[][]{
                {3.0, 4.0, 5.0},
        };
    }

    @DataProvider(name = "getSquare")
    public Object[][] getSquare() {
        return new Object[][]{
                {3.0, 4.0, 5.0, 6.0},
        };
    }

    @DataProvider(name = "getNegativeTriangle")
    public Object[][] getNegativeTriangle() {
        return new Object[][]{
                {3.0, -4.0, 0.0},
        };
    }

    @DataProvider(name = "getDefunctTriangle")
    public Object[][] getDefunctTriangle() {
        return new Object[][]{
                {30, 4.0, 8.0},
        };
    }

    @DataProvider(name = "detectTriangle")
    public Object[][] detectTriangle() {
        return new Object[][]{
                {3.0, 3.0, 3.0, 3, "Треугольник равносторонний"},
                {3.0, 3.0, 4.0, 2, "Треугольник равнобедренный"},
                {1.0, 2.0, 3.0, 4, "Треугольник обычный"},
                {3.0, 4.0, 5.0, 8, "Треугольник прямоугольный"},
        };
    }


    @Test(dataProvider = "getTriangle", groups = "initClass")
    public void test_Triangle(double a, double b, double c) {
        triangle = new Triangle(a, b, c);
        assertNotNull(triangle);
    }


    @Test(dataProvider = "getSquare", groups = "work")
    public void test_getSquare1(double a, double b, double c, double square) {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.getSquare(), square, 0.01);
    }

    @Test(dataProvider = "getNegativeTriangle", groups = "work")
    public void test_getSquare2(double a, double b, double c, double square) {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.getSquare(), square, 0.01);
    }

    @Test(dataProvider = "getDefunctTriangle", groups = "initClass")
    public void test_checkTriangle(double a, double b, double c) {
        triangle = new Triangle(a, b, c);
        assertTrue(false == triangle.checkTriangle());
        String message = triangle.getMessage();
        assertEquals(message, "b+c<=a");
    }

    @Test(dataProvider = "detectTriangle", groups = "work")
    public void test_detectTriangle(double a, double b, double c, int tr, String mes) {
        System.out.println(" " + a + " " + b + " " + c + " " + mes);
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.detectTriangle(), tr);
    }

    @Test(dataProvider = "getNegativeTriangle", expectedExceptions = NullPointerException.class, groups = "Exception")
    public void test_Exception(double a, double b, double c) {
        triangle = new Triangle(a, b, c);
        triangle.getSquare();
    }


    @Test(dataProvider = "getNegativeTriangle", groups = "initClass")
    public void getMessageTest(double a, double b, double c) {
        triangle = new Triangle(a, b, c);
        assertTrue(false == triangle.checkTriangle());
        String message = triangle.getMessage();
        assertEquals(message, "b<=0");
    }

}

