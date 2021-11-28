package exercise;

import java.awt.Color;
import java.awt.Graphics;

public class Circles implements Drawable, Fillable {

    private Color color;
    private Graphics pen;
    private int x;
    private int y;

    public Circles(Graphics pen){
        this.pen = pen;
        color = Color.WHITE;
        x = 30;
        y = 5;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(){
        move(80, 80);
        color = AQUA;
        draw(color);
    }

    public void fill(Color color){
        move(50, 50);
        pen.setColor(color);
        for(int i = 1; i < 11; i++){
            pen.fillOval(x, y, 10 * i, 10 * i);
        }
    }

    public void draw(Color color){
        pen.setColor(color);
        for(int i = 1; i < 11; i++){
            pen.drawOval(x, y, 20 * i, 20 * i);
        }
    }

    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    public Color getAQUA(){
        color = AQUA;
        return color;
    }


}
