
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole Wong
 * @classname AssignmentInheritance
 * @assignmentnumber 3
 */
public class AssignmentInheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10]; //limit size of the array to 10

        //repeatedly call up the menu until exited or array is full
        while (true) {
            String message = "What action? (1-2) (-1 to quit)";
            message = message + "\n1. Create Shape";
            message = message + "\n2. Print Current Shapes";

            int type = Integer.parseInt(JOptionPane.showInputDialog(message));
            //quit menu with '-1'
            if (type == -1) {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            switch (type) {
                case 1:
                    add(shapes);
                    break;
                case 2:
                    display(shapes);
                    break;
                default:
                    System.out.println("Not valid option.");
            }
            System.out.println();
        }
    }

    /**
     * @param array Shape array
     * @method adds the shape based on user input (what type, how many, specific
     * size)
     */
    public static void add(Shape[] array) {
        String typeOfShape = JOptionPane.showInputDialog("Enter type of shape (rectangle, circle, or square)?");
        typeOfShape.toLowerCase();
        //ask how many of the specific shape
        int howMany = Integer.parseInt(JOptionPane.showInputDialog("How many?"));
        //check index number to add shape
        int index = 0;
        for (int x = 0; x < array.length; x++) {
            if (array[x] == null) { //check if it's empty 
                index = x;
                break;
            }
        }
        if (typeOfShape.equals("circle")) {
            while (howMany > 0) {
                //ask the radius for each circle
                int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius?"));
                array[index] = new Circle(radius);
                howMany--;
                index++;
                //exit if full array
                if (index >= array.length) {
                    System.out.println("Full Array!");
                    display(array);
                    System.exit(0);
                }
            }
        } else if (typeOfShape.equals("rectangle")) {
            while (howMany > 0) {
                //ask the height,width for each rectangle
                int height = Integer.parseInt(JOptionPane.showInputDialog("Height?"));
                int width = Integer.parseInt(JOptionPane.showInputDialog("Width?"));
                array[index] = new Rectangle(height, width);
                howMany--;
                index++;
                //exit if full array
                if (index >= array.length) {
                    System.out.println("Full Array!");
                    display(array);
                    System.exit(0);
                }
            }
        } else {
            while (howMany > 0) {
                //ask the side for each square
                int side = Integer.parseInt(JOptionPane.showInputDialog("Side?"));
                array[index] = new Square(side);
                howMany--;
                index++;
                //exit if full array
                if (index >= array.length) {
                    System.out.println("Full Array!");
                    display(array);
                    System.exit(0);
                }
            }
        }
    }

    /**
     * @param array Shape array
     * @method prints out the current shapes (name and total area)
     */
    public static void display(Shape[] array) {
        double totalCArea = 0;
        double totalRArea = 0;
        double totalSArea = 0;
        for (int x = 0; x < array.length; x++) {
            if (array[x] instanceof Rectangle) {
                totalRArea += array[x].area();
            }
            if (array[x] instanceof Square) {
                totalSArea += array[x].area();
            }
            if (array[x] instanceof Circle) {
                totalCArea += array[x].area();
            }
        }
        System.out.println("Square Total Area: " + totalSArea + "\n"
                + "Rectangle Total Area: " + totalRArea + "\n"
                + "Circle Total Area: " + totalCArea);
    }
}
