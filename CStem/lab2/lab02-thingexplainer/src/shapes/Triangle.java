package shapes;

public class Triangle extends Shape{
    public double a;
    public double b;
    public double c;

    public Triangle(){
        a = 1.0;
        b = 1.0;
        c = 1.0;
    }

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area(){
        double s = (a + b + c) / 2;
        return (s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter(){
        return (a + b + c);
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }
    
    public double getC(){
        return c;
    }

    @Override
    public String toString(){
        String output = ("The a is: " + round(a) + "\nThe b is: " + round(b) + "\nThe c is: " + round(c));
        output += ("\nThe area is: " + round(area()));
        output += ("\nThe perimeter is: " + round(perimeter()));

        return output;
    }
}
