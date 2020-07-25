/**
 *
 * @author Nicole Wong
 * @classname Circle
 * @assignmentnumber 3
 */
public class Circle extends Shape {
    private double radius;
    
    public Circle(double r)
    {
        radius = r;
    }
    
    //getter methods
    public double getRadius()
    {
        return radius;
    }
    public double getDiameter()
    {
        return radius*2;
    }
    
    //setter methods
    public void setRadius(double r)
    {
        radius = r;
    }
    
    @Override
    public double area() {
        return (double)(Math.PI)*(radius*radius);
    }
}
