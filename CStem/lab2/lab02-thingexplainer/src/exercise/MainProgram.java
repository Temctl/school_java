package exercise;

import java.awt.Color;
import java.awt.Graphics;

public class MainProgram {
    

    public static void testDrawable(Display display, Drawable circles) throws Exception {

        display.pause(500);
        // TODO : Move to location and draw Yellow Circles
        circles.draw(Color.YELLOW);

        // TODO : Move to location and draw RED Circles
        circles.move(50, 50);
        circles.draw(Color.RED);

        // TODO : Move to location and draw Circles with Fillable AQUA
        circles.move(50, 0);
        circles.draw(circles.getAQUA());

        display.pause(500);
    }

    public static void testFillable(Display display, Fillable filledCircles) throws Exception {

        //TODO: Set Location back to location (50, 50)

        display.pause(500);
        filledCircles.setLocation(50, 50);

        // TODO : Draw fillable  RED, WHITE and BLUE Circles
        filledCircles.fill(Color.RED);
        filledCircles.fill(Color.WHITE);
        filledCircles.fill(Color.BLUE);

        // TODO : Draw circles with Fillable AQUA Color
        filledCircles.draw();
        display.pause(500);
    }

    public static void main(String[] args) throws Exception{

        Display display = new Display(600, 500);
        display.setBackground(Color.DARK_GRAY);

        // Get Graphics Pen Object for Drawing in Window
        Graphics pen = display.getGraphics();

        // TODO : Create Circles of a Drawable Type
        Circles circles = new Circles(pen);

        // TODO : Draw Drawable  Circles
        testDrawable(display, circles);

        // clear display if needed (uncomment)
        display.clear();

        // TODO : Create Circles of a Fillable Type
        
        // TODO : Draw Fillable Circles
        testFillable(display, circles);

    }
}
