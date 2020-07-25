/**
 *
 * @author Nicole Wong
 * @classname Rectangle
 * @assignmentnumber 3
 */
public class Rectangle extends Shape {
    private double height;
    private double width;
    
    public Rectangle(double x, double y)
    {
        height = x;
        width = y;
    }
    
    //getter methods
    public double getHeight()
    {
        return height;
    }
    public double getWidth()
    {
        return width;
    }
    
    //setter methods
    public void setHeight(double x)
    {
        height = x;
    }
    public void setWidth(double x)
    {
        width = x;
    }
    
    @Override
    public double area() {
        return height*width;
    }
}
