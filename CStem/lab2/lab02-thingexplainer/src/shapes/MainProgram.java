package shapes;

public class MainProgram {

    public static void main(String[] args) {

        //TODO: Create All Classes and Update with test methods
        /*Shape circle = new Circle(4);
        Shape rectrangle = new Rectangle(4, 5);
        Shape triangle = new Triangle(5, 12, 13);*/

        Shape shape;
        shape = new Circle(4);
        testShape(shape);
        shape = new Rectangle(4, 5);
        testShape(shape);
        shape = new Triangle(5, 12, 13);
        testShape(shape);
        System.out.println("");

        shape = new Circle(3);
        testShape(shape);
        shape = new Rectangle(6, 13);
        testShape(shape);
        shape = new Triangle(8, 15, 17);
        testShape(shape);


    }

    public static void testShape(Shape shape){
        System.out.println(shape);
    }
}
