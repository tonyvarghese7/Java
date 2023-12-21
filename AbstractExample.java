import java.util.*;
abstract class Shape {
    abstract void numberOfSides();

}

class Rectangle extends Shape {
    void numberOfSides() {
    System.out.println("Rectangle has 4 sides");
   }
}
class Triangle extends Shape {
    void numberOfSides() {
    System.out.println("Triangle has 3 sides");
  }
}
class Hexagon extends Shape {
    void numberOfSides() { 
        System.out.println("Hexagon has 6 sides");
    }
}

class AbstractExample {
    public static void main(String args[]) { 
        Rectangle rectangleObj = new Rectangle(); 
        rectangleObj.numberOfSides(); 
        Triangle triangleObj = new Triangle(); 
        triangleObj.numberOfSides();
         Hexagon hexagonObj = new Hexagon();
          hexagonObj.numberOfSides();
    }
}