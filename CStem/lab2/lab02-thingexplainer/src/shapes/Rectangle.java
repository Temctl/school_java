package shapes;

public class Rectangle extends Shape{

    private double height;
    private double width;

    public Rectangle(){
        super();
    }

    public Rectangle(double width, double height){
        this.height = height;
        this.width = width;
    }

    public double height(){
        return height;
    }

    public double width(){
        return width;
    }

    @Override
    public double perimeter(){
        return((height + width) * 2);
    }

    public String toString(){
        String output = "The height is: " + round(height);
        output += "\nThe width is: " + round(width);
        output += "\nThe area is: " + round(area());
        output += "\nThe perimeter is: " + round(perimeter());

        return(output);
    }
    
}
