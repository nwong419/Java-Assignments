/**
 *
 * @author Nicole Wong
 * @classname Square
 * @assignmentnumber 3
 */
public class Square extends Shape {
    private double side;
    
    public Square(double x)
    {
       side = x;
    }
    
    //getter methods
    public double getSide()
    {
        return side;
    }
    
    //setter methods
    public void setSide(double x)
    {
        side = x;
    }
    
    @Override
    public double area() {
        return side * side;
    }
}
