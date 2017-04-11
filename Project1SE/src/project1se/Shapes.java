package project1se;
/**
 * @author Ryan Fairbanks
 * @version 10/1/16
 * @description CSCI 373. Project 2. This code implements the methods of project 2. This adds more
 * options for drawing objects including drawing lines with arrows, diamonds,
 * parallelograms, and triangles. Also includes features to resize the area of
 * the screen in which objects appear and to erase objects with mouse clicks.
 */
public class Shapes extends Project1SE{
    /**
     * @Description Uses xCoordinate and yCoordinate to determine the center of 
     * the horizontal line capping the triangle. From there, adjusts the 
     * xCoordinate to the end using half of the desired width and draws a 
     * horizontal line across. At each of the ends of this line, diagonal lines
     * are drawn that converge centrally underneath the top line. Modifies the 
     * yCoordinate to match the convergence point of the diagonal lines at the 
     * bottom of the object.
     */
    public void drawDownwardTriangle(){
        int x; // Placeholders for xCoordinate and yCoordinate.
        int y = this.yCoordinate;
        for(x = this.xCoordinate - (this.width/2); x <= this.xCoordinate + (this.width/2); x++) this.d1.showPoint(x, this.yCoordinate-this.width); // Draw upper line of triangle.
        for(x = this.xCoordinate - (this.width/2); x <= this.xCoordinate; x++){ // Draw right side of triangle.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate; // Reset y to be provided yCoordinate.
        for(x = this.xCoordinate + (this.width/2); x >= this.xCoordinate; x--){ //Draw left side of triangle.
            this.d1.showPoint(x, y);
            y++;
        }
        setYCoordinate(this.yCoordinate + (this.width/2)); // Adjust yCoordinate to match bottom of triangle, xCoordinate unchanged.
    }
    /**
     * @Description Uses xCoordinate and yCoordinate to determine top of the
     * triangle and then proceeds draw right and left slanting diagonal lines. 
     * Between the lower ends of these lines, a horizontal line is drawn across,
     * sealing the triangle. The yCoordinate is modified to the bottom of the 
     * triangle, the xCoordinate is unchanged.
     */
    public void drawUpwardTriangle(){
        int x;
        int y = this.yCoordinate;
        for(x = this.xCoordinate + this.width; x >= this.xCoordinate + (this.width/2); x--){ //Draw right side of triangle.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate; // Reset y to be provided yCoordinate.
        for(x = this.xCoordinate; x <= this.xCoordinate + (this.width/2); x++){ // Draw left side of triangle.
            this.d1.showPoint(x, y);
            y++;
        }
        for(x = this.xCoordinate - this.width; x <= this.xCoordinate; x++) this.d1.showPoint(x, this.yCoordinate-this.width);// Draw bottom line of triangle.
        setYCoordinate(this.yCoordinate + (this.width/2)); // yCoordinate is set to bottom, xCoordinate is already positioned at center.
    }
    /**
     * @Description Expects width as radius and assumes xCoordinate and 
     * yCoordinate mark the top of the circle. Uses 
     * xCoordinate + radius * cos(angle) and yCoordinate + radius * sin(angle) 
     * to draw points in the circle. Loop performs this operation once for every
     * degree, so 360 times total.
     */
    public void drawCircle(){
        int y = this.yCoordinate + this.width; // Adjust y to be at the center of the circle.
        for(int angle = 0; angle <= 359; angle = angle++) this.d1.showPoint((int)Math.round(this.xCoordinate + this.width*Math.cos(angle)), (int)Math.round(this.yCoordinate + this.width*Math.sin(angle)));
        this.setYCoordinate(this.yCoordinate + (2*this.width)); // Set yCoordinate to bottom of circle, xCoordinate is already set.
    }
    /**
     * @Description Uses width parameter from class instance for length of
     * horizontal lines and the height parameter from class instance for length
     * of the diagonal lines. Draws top horizontal line, the two diagonal lines,
     * and finally the bottom.
     */
    public void drawParallelogramRight(){ // Slanted forward.
        int x;
        int y = this.yCoordinate;
        for(x = this.xCoordinate + (this.width/2); x >= this.xCoordinate - (this.width/2); x--) this.d1.showPoint(x, this.yCoordinate); // Draw top horizontal line.
        for(x = this.xCoordinate + (this.width/2); x >= this.xCoordinate - this.height; x--){
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate;
        for(x = this.xCoordinate - (this.width/2); x >= this.xCoordinate - this.height; x--){
            this.d1.showPoint(x, y);
            y++;
        }
        this.setYCoordinate(y + this.height);
        for(x = this.xCoordinate + (this.width/2) + this.height; x <= this.xCoordinate - (this.width/2) + this.height; x--) this.d1.showPoint(x, this.yCoordinate); // Draw bottom horizontal line, accounting for center and width (expressed as height) of diagonal lines.
        this.setXCoordinate(this.xCoordinate + this.height);
    }
    /**
     * @Description Uses width parameter from class instance for length of 
     * horizontal lines and the height parameter from class instance for length 
     * of the diagonal lines.
     */
    public void drawParallelogramLeft(){ // Slanted backward.
        int x;
        int y = this.yCoordinate;
        for(x = this.xCoordinate + (this.width/2); x >= this.xCoordinate - (this.width/2); x--) this.d1.showPoint(x, this.yCoordinate); // Draw top horizontal line, accounting for center.
        for(x = this.xCoordinate - (this.width/2); x <= this.xCoordinate + (this.height/2); x++){ // Draw left side diagonal line.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate; // Reset y Coordinate.
        for(x = this.xCoordinate + (this.width/2); x <= this.xCoordinate + (this.height/2); x++){ // Draw right side diagonal line.
            this.d1.showPoint(x, y);
            y++;
        }
        this.setYCoordinate(y + this.height);
        for(x = this.xCoordinate + (this.width/2) - this.height; x <= this.xCoordinate - (this.width/2) - this.height; x--) this.d1.showPoint(x, this.yCoordinate); // Draw bottom horizontal line, accounting for center and width (expressed as height) of diagonal lines.
        this.setXCoordinate(this.xCoordinate - this.height);
    }
    /**
     * @Description Starts by drawing two diagonal lines, slanted in opposite 
     * directions from the provided xCoordinate and yCoordinate. Next, adjusting
     * for the change is y, draws two more diagonal lines from the ends of the 
     * first two to close the object. Finishes by modifying the yCoordinate to 
     * be the bottom of the structure.
     */
    public void drawDiamond(){
        int x;
        int y = this.yCoordinate;
        for(x = this.xCoordinate + this.width; x >= this.xCoordinate + (this.width/2); x--){ //Draw right upper side of diamond.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate; // Reset for next diagonal line.
        for(x = this.xCoordinate; x <= this.xCoordinate + (this.width/2); x++){ // Draw left uper side of diamond.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate + (this.width/2); // Adjust y to bottom of upper section of diamond.
        for(x = this.xCoordinate - (this.width/2); x <= this.xCoordinate; x++){ // Draw right lower side of diamond.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate + (this.width/2); // Reset for next diagonal line.
        for(x = this.xCoordinate + (this.width/2); x >= this.xCoordinate; x--){ //Draw left lower side of diamond.
            this.d1.showPoint(x, y);
            y++;
        }
        this.setYCoordinate(this.yCoordinate + this.width); // Set yCoordinate to bottom position of the object, xCoordinate unchanged.
    }
    /**
     * @Description First draws a horizontal line drawn to the right, such as in
     * the method drawLineHorizontalRight from project 1 and featured in the 
     * Project1SE class. Next draws two diagonal lines to represent the
     * arrowhead, both at a length of 5.
     */
    public void drawHorizontalRightArrow(){
        int x;
        int y = this.yCoordinate;
        for(x = this.xCoordinate + this.width; x >= this.xCoordinate; x--) this.d1.showPoint(x, this.yCoordinate); // Draw horizontal line.
        this.setXCoordinate(this.xCoordinate + this.width); // Adjust coordinates.
        for(x = this.xCoordinate - 5; x >= this.xCoordinate; x--){ // Draw upper portion of arrow.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate; // Reset for other side of the arrow.
        for(x = this.xCoordinate; x <= this.xCoordinate - 5; x++){ // Draw lower portion of arrow.
            this.d1.showPoint(x, y);
            y++;
        }
    }
    /**
     * @Description First draws horizontal line to the left from the provided
     * xCoordinate and yCoordinate based on width. From there draws each of the 
     * arrowhead components as diagonal lines, each length 5.
     */
    public void drawHorizontalLeftArrow(){
        int x;
        int y = this.yCoordinate;
        for(x = this.xCoordinate - this.width; x <= this.xCoordinate; x++) this.d1.showPoint(x, this.yCoordinate); // Draw horizontal line.
        this.setXCoordinate(this.xCoordinate - this.width); // Adjust coordinates.
        for(x = this.xCoordinate - 5; x <= this.xCoordinate; x++){ // Draw top of arrow.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate; // Reset for next diagonal line.
        for(x = this.xCoordinate + 5; x >= this.xCoordinate; x--){ //Draw bottom of arrow.
            this.d1.showPoint(x, y);
            y++;
        }
    }
    /**
     * @Description Draws a downward vertical line using the class instance's 
     * width for the length and the xCoordinate and yCoordinate as a starting
     * point. At the finishing point of that line, each of the sides of the 
     * arrow are drawn on. Changes the yCoordinate to match the end of the
     * object.
     */
    public void drawVerticalArrow(){
        int x;
        int y;
        for(y = this.yCoordinate + this.width; y >= this.yCoordinate; y--) this.d1.showPoint(this.xCoordinate, y); // Draw vertical line.
        this.setYCoordinate(this.yCoordinate + this.width); // Set yCoordinate to end of line, xCoordinate unchanged.
        y = this.yCoordinate;
        for(x = this.xCoordinate; x >= this.xCoordinate - 5; x--){ // Left side of arrow.
            this.d1.showPoint(x, y);
            y++;
        }
        y = this.yCoordinate;
        for(x = this.xCoordinate; x <= this.xCoordinate + 5; x++){
            this.d1.showPoint(x, y);
            y++;
        }
    }
    /**
     * @Description From the provided xCoordinate and yCoordinate, this method 
     * makes a diagonal line with a height of the passed width. At the bottom of
     * the line, the arrowheads are drawn with a length 5. xCoordinate and 
     * yCoordinate are also modified to be the end of the line.
     */
    public void drawDiagonalRightArrow(){ // Slanted forward.
        int y = this.yCoordinate;
        for(int x = this.xCoordinate + 2*this.width; x >= this.xCoordinate + this.width; x--){ // Draw diagonal line.
            this.d1.showPoint(x, y);
            y++;
        }
        this.setXCoordinate(this.xCoordinate + this.width); // Set xCoordinate to end of line.
        this.setYCoordinate(this.yCoordinate + this.width); // Set yCoordinate to end of line.
        for(y = this.yCoordinate - 5; y <= this.yCoordinate; y++) this.d1.showPoint(this.xCoordinate, y); // Draw vertical arrow component.
        for(int x = this.xCoordinate - 5; x <= this.xCoordinate; x++) this.d1.showPoint(x, this.yCoordinate); // Draw horizontal arrow component.
    }
    /**
     * @Description From the provided xCoordinate and yCoordinate, this method
     * makes a diagonal line with a height of the passed width. At the bottom of
     * the line, the arrowheads are drawn with a length 5. xCoordinate and 
     * yCoordinate and also modified to be the end of the line.
     */
    public void drawDiagonalLeftArrow(){ // Slanted backward.
        int y = this.yCoordinate;
        for(int x = this.xCoordinate; x <= this.xCoordinate + this.width; x++){
            this.d1.showPoint(x, y);
            y++;
        }
        this.setXCoordinate(this.xCoordinate - this.width); // Set xCoordinate to end of line.
        this.setYCoordinate(this.yCoordinate + this.width); // Set yCoordinate to end of line.
        for(y = this.yCoordinate - 5; y <= this.yCoordinate; y++) this.d1.showPoint(this.xCoordinate, y); // Draw vertical arrow component.
        for(int x = this.xCoordinate + 5; x >= this.xCoordinate; x--) this.d1.showPoint(x, this.yCoordinate);// Use for loop to place dots in line, continue calling until line matches length.
    }
    /**
     * @Description
     */
    public void clickRemove(){
        
    }
}