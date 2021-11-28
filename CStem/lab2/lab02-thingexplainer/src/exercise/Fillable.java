package exercise;

import java.awt.Color;

public interface Fillable {

    public final Color AQUA = new Color(0, 150, 255);

    public void draw();

    public void fill(Color color);

    public void setLocation(int x, int y);

    public Color getAQUA();
    
}
