package project1se;
import java.util.Scanner;
import csci348.drawings.*;
/**
 * @author Ryan Fairbanks
 * @version 10/1/16
 * @description The purpose of this code is to draw a box diagram with input
 * from the user to position lines and boxes. This class contains the methods to
 * draw the boxes and lines, calling upon the drawing.jar provided to draw each 
 * point.
 */
public class Project1SE{
    protected int xCoordinate;
    protected int yCoordinate;
    protected int width;
    protected int height;
    private static final int DEFAULT_X = 300;
    private static final int DEFAULT_Y = 300;
    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;
    Drawing d1;
    public Project1SE(){ // Default option, sets options without user input.
        this.xCoordinate = DEFAULT_X;
        this.yCoordinate = DEFAULT_Y;
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
        this.d1 = new SimpleDrawing();
    }
    public Project1SE(int xCoordinate, int yCoordinate, int width, int height){ // User sets options.
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
        this.d1 = new SimpleDrawing();
    }
    public Project1SE(int xCoordinate, int yCoordinate, int width, int height, int drawWidth, int drawHeight){ // Added with project2: user sets options.
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
        this.d1 = new SimpleDrawing(drawWidth, drawHeight);
    }
    public void drawLineHorizontalRight(){
        for(int x = this.xCoordinate + this.width; x >= this.xCoordinate; x--){ // Use for loop to place dots in line, continue calling until line matches length.
            this.d1.showPoint(x, this.yCoordinate);
        }
        this.setXCoordinate(this.xCoordinate + this.width); // Set xCoordinate to end of line, yCoordinate unchanged.
    }
    public void drawLineHorizontalLeft(){
        for(int x = this.xCoordinate - this.width; x <= this.xCoordinate; x++){
            this.d1.showPoint(x, this.yCoordinate);
        }
        this.setXCoordinate(this.xCoordinate - this.width); // Set xCoordinate to end of line, yCoordinate unchanged.
    }
    public void drawLineVertical(){
        for(int y = this.yCoordinate + this.width; y >= this.yCoordinate; y--){
            this.d1.showPoint(this.xCoordinate, y);
        }
        this.setYCoordinate(this.yCoordinate + this.width); // Set yCoordinate to end of line, xCoordinate unchanged.
    }
    public void drawLineDiagonalRight(){ // Line slanted forward.
        int y = this.yCoordinate;
        for(int x = this.xCoordinate + 2*this.width; x >= this.xCoordinate + this.width; x--){
            this.d1.showPoint(x, y);
            y++;
        }
        this.setXCoordinate(this.xCoordinate + this.width); // Set xCoordinate to end of line.
        this.setYCoordinate(this.yCoordinate + this.width); // Set yCoordinate to end of line.
    }
    public void drawLineDiagonalLeft(){ // Line slanted backward.
        int y = this.yCoordinate;
        for(int x = this.xCoordinate; x <= this.xCoordinate + this.width; x++){
            this.d1.showPoint(x, y);
            y++;
        }
        this.setXCoordinate(this.xCoordinate - this.width); // Set xCoordinate to end of line.
        this.setYCoordinate(this.yCoordinate + this.width); // Set yCoordinate to end of line.
    }
    public void drawBox(){
        int xEnd = this.xCoordinate - (this.width/2); //  xOriginal specified center of box, adjusting for left end.
        for(int x = xEnd + this.width; x >= xEnd; x--){ // Draw both horizontal lines at the same time, compensating for width.
            this.d1.showPoint(x, this.yCoordinate);
            this.d1.showPoint(x, (this.yCoordinate + this.height));
        }
        for(int y = this.yCoordinate + this.height; y >= this.yCoordinate; y--){ // Draw both vertical lines at the same time, compensating for height.
            this.d1.showPoint(xEnd, y);
            this.d1.showPoint((xEnd + this.width), y);
        }
        this.setYCoordinate(this.yCoordinate + this.height); // Adjust yCoordinate to bottom of box. xCoordinate already at center.
    }
     public void clearAll(){ // Clears whole board.
        this.d1.hideAllPoints();
    }
    public void clearArea(){
        int xEnd = xCoordinate - (this.width/2); // xOriginal specified center of box, adjusting for left end.
        for(int x = xEnd + this.width; x >= xEnd; x--){
            for(int y = this.yCoordinate + this.height; y >= this.yCoordinate; y--){
                this.d1.hidePoint(x, y);
            }
        }
    }
    public void setXCoordinate(int xCoordinate){
        this.xCoordinate = xCoordinate;
    }
    public void setYCoordinate(int yCoordinate){
        this.yCoordinate = yCoordinate;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getXCoordinate(){
        return this.xCoordinate;
    }
    public int getYCoordinate(){
        return this.yCoordinate;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public void printCoordinates(){
        System.out.println("End of last object at: " + this.xCoordinate + ", " + this.yCoordinate);
    }
    public static void main(String[] args) {
        int tempX;
        int tempY;
        int tempWidth;
        int tempHeight;
        Project1SE drawMyChart;
        String answer;
        String draw;
        Scanner read = new Scanner(System.in); // User must first draw box to start the diagram, then open options to lines and boxes.
        System.out.print("Use default settings for first box? (Y/N): ");
        answer = read.nextLine();
        if(answer.equals("Y")){ // User opted for default options for first box.
            drawMyChart = new Project1SE();
        }
        else{ // User opted to input their own customizations for first box.
            System.out.print("Enter width of first box: ");
            tempWidth = read.nextInt();
            System.out.print("Enter height of first box: ");
            tempHeight = read.nextInt();
            System.out.print("Enter x coordinate (center) for first box: ");
            tempX = read.nextInt();
            System.out.print("Enter y coordinate (top) for the first box: ");
            tempY = read.nextInt();
            drawMyChart = new Project1SE(tempX, tempY, tempWidth, tempHeight);
            read.nextLine(); // Without this line, the next read.nextLine() is skipped and the program terminates.
        }
        drawMyChart.drawBox(); // Draw first box.
        drawMyChart.printCoordinates(); // Print coordinates from bottom center of first box for user reference when drawing. 
        while(1 == 1){ // Loop continues endlessly until user closes drawing window.
            System.out.print("Draw box? (Y/N): "); // Ask user what object they want to draw.
            draw = read.nextLine();
            if(draw.equals("Y")){ // Draw box, user inputs settings for box.
                System.out.print("Enter width of box: ");
                drawMyChart.setWidth(read.nextInt());
                System.out.print("Enter height of box: ");
                drawMyChart.setHeight(read.nextInt());
                System.out.print("Enter x coordinate (center) for box: ");
                drawMyChart.setXCoordinate(read.nextInt());
                System.out.print("Enter y coordinate (top) for the box: ");
                drawMyChart.setYCoordinate(read.nextInt());
                drawMyChart.drawBox();
                drawMyChart.printCoordinates();
                read.nextLine(); // Next read.nextLine is skipped without this line.
            }
            System.out.print("Draw line? (Y/N): ");
            draw = read.nextLine();
            if(draw.equals("Y")){ // Draw line, user specifies type and further customizes.
                System.out.print("Enter length of line: ");
                drawMyChart.setWidth(read.nextInt());
                System.out.print("Enter x coordinate (left) of line: ");
                drawMyChart.setXCoordinate(read.nextInt());
                System.out.print("Enter y coordinate (top) of line: ");
                drawMyChart.setYCoordinate(read.nextInt());
                System.out.print("Draw horizontal (H), vertical (V), or diagonal (D) line? ");
                read.nextLine();
                draw = read.nextLine();
                read.nextLine();
                switch (draw){
                    case "H":
                        System.out.print("Draw horizontal line towards left (L) or right (R)? ");
                        draw = read.nextLine();
                        if(draw.equals("L")) drawMyChart.drawLineHorizontalLeft();
                        else{
                            drawMyChart.drawLineHorizontalRight();
                            read.nextLine();
                        }
                        break;
                    case "V":
                        drawMyChart.drawLineVertical();
                        break;
                    default:
                        System.out.print("Draw diagonal line slanted left (L) or right (R)? ");
                        draw = read.nextLine();
                        if(draw.equals("L")) drawMyChart.drawLineDiagonalLeft();
                        else{
                            drawMyChart.drawLineDiagonalRight();
                        }
                        break;
                }
                drawMyChart.printCoordinates();
            }
            System.out.print("Clear object/area? (Y/N): "); // Erase a specific area or the whole board.
            draw = read.nextLine();
            if(draw.equals("Y")){
                System.out.print("Clear all (A) or clear an area/box (B)? ");
                draw = read.nextLine();
                if(draw.equals("A")){ // Clear whole diagram.
                    drawMyChart.clearAll();
                }
                else{ // User specifies size and coordinates of area to be cleared.
                    System.out.print("Enter width of area to be cleared: ");
                    drawMyChart.setWidth(read.nextInt());
                    System.out.print("Enter height of area to be cleared: ");
                    drawMyChart.setHeight(read.nextInt());
                    System.out.print("Enter centermost x coordinate of area to be cleared: ");
                    drawMyChart.setXCoordinate(read.nextInt());
                    System.out.print("Enter uppermost y coordinate of area to be cleared: ");
                    drawMyChart.setYCoordinate(read.nextInt());
                    drawMyChart.clearArea();
                    read.nextLine();
                }
            }
        }
    }
}