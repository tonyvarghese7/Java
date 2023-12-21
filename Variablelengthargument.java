import java.util.Scanner;

public class Variablelengthargument {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a shape to calculate area:");
        System.out.println("1. Circle\n");
        System.out.println("2. Rectangle\n");
        System.out.println("3. Triangle\n");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                System.out.println("Area of the circle: " + calculateArea(radius));
                break;

            case 2:
                
                System.out.print("Enter the length of the rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double width = scanner.nextDouble();
                System.out.println("Area of the rectangle: " + calculateArea(length, width));
                break;

            case 3:
                
                System.out.print("Enter the base of the triangle: ");
                double base = scanner.nextDouble();
                System.out.print("Enter the height of the triangle: ");
                double height = scanner.nextDouble();
                System.out.println("Area of the triangle: " + calculateArea(base, height));
                break;

            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }

    
    private static double calculateArea(double... dimensions) {
    if (dimensions.length == 1) {
        return Math.PI * dimensions[0] * dimensions[0];
    } else if (dimensions.length == 2) {
        
            return dimensions[0] * dimensions[1];
        } else if (dimensions.length == 2) {
           
            return 0.5 * dimensions[0] * dimensions[1];
        } else {
    
            System.out.println("Invalid number of dimensions for the shape.");
            return -1;
        }
    }
}
