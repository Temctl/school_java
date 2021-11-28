package shapes;

public class Shape {
    protected double x; //x coordinate
    protected double y; //ycoordinate

    public Shape(){
        x = 1.0;
        y = 1.0;
    }

    public Shape(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double area(){
        return (x * y);
    }

    public double perimeter(){
        return (x + y);
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected double round(double num){//rounds numbers to 1 decimals
        return (Math.round(num * 10) / 10.0);
    }

    @Override
    public boolean equals(Object obj){
        boolean bool = false;
        if(obj instanceof Shape){
            bool = true;
        } 
        return bool;
    }
}
