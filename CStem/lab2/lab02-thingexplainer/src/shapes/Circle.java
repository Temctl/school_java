package shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(){
        radius = 0.0;
    }

    public Circle(double radius){
        if (radius < 0){
            throw new IllegalArgumentException("radius cannot be negative");
        } else{
            this.radius = radius;
        }   
    }
    
    @Override
    public double area(){
        return (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public double perimeter(){
        return (2 * Math.PI * radius);
    }

    public double radius(){
        return radius;
    }
    
    public String toString(){
        return ("The radius is: " + radius() + "\nThe area is: " + area() + "\nThe perimiter is: " + perimeter());
    }
}
