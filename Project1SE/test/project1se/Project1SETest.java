package project1se;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author Ryan Fairbanks
 * @version 9/8/16
 * @description Tests the methods of Project1SE main class. Tests whether or not
 * shapes are drawn by calling each method and also determines that if their
 * adjustments to their coordinates are relayed to the user.
 */
public class Project1SETest {
    Project1SE test1;
    @Before
    public void setUp() throws Exception{
        test1 = new Project1SE();
    }
    @Test
    public void testDrawLineHorizontalRight() {
        test1.setXCoordinate(50);
        test1.setYCoordinate(50);
        test1.drawLineHorizontalRight();
        assertEquals(100, test1.getXCoordinate());
    }
    @Test
    public void testDrawLineHorizontalLeft() {
        test1.setXCoordinate(100); // Move line over so it is not overlapping.
        test1.setYCoordinate(50);
        test1.drawLineHorizontalLeft();
        assertEquals(50, test1.getXCoordinate());
    }
    @Test
    public void testDrawLineVertical() {
        test1.setXCoordinate(150); // Move line over.
        test1.setYCoordinate(50);
        test1.drawLineVertical();
        assertEquals(100, test1.getYCoordinate());
    }
    @Test
    public void testDrawLineDiagonalRight() {
        test1.setXCoordinate(200);
        test1.setYCoordinate(50);
        test1.drawLineDiagonalRight();
        assertEquals(250, test1.getXCoordinate());
        assertEquals(100, test1.getYCoordinate());
    }
    @Test
    public void testDrawLineDiagonalLeft() {
        test1.setXCoordinate(250);
        test1.setYCoordinate(50);
        test1.drawLineDiagonalLeft();
        assertEquals(200, test1.getXCoordinate());
        assertEquals(100, test1.getYCoordinate());
    }
    @Test
    public void testDrawBox() {
        test1.setXCoordinate(300);
        test1.setYCoordinate(50);
        test1.drawBox();
        assertEquals(100, test1.getYCoordinate());
    }
    @Test
    public void testClearArea() {
        test1.setXCoordinate(50); // Reseting to position of original line.
        test1.setYCoordinate(50); // Should erase first line.
        test1.clearArea(); // No values modified by method to test.
    }
    @Test
    public void testGetAndSet(){
        test1.setXCoordinate(10);
        test1.setYCoordinate(11);
        test1.setWidth(12);
        test1.setHeight(13);
        assertEquals(10, test1.getXCoordinate());
        assertEquals(11, test1.getYCoordinate());
        assertEquals(12, test1.getWidth());
        assertEquals(13, test1.getHeight());
    }
}