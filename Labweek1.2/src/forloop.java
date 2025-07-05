import java.awt.*;

public class forloop {
    public static void main(String[] args) {
        Turtle Danny = new Turtle();
        Danny.speed(0);
        Danny.setPosition(0,0);
//Start with The eyes - iris & pupil
        //Draw eye.
        for (int j = 0; j < 36; j++) { //Loop to rotate and draw 36 flower-like as iris
            double length = 5;
            for (int i = 0; i < 60; i++) { // Create a spiral curve pattern
                int colorIndex = (i / 15) % 4;

                if (colorIndex == 0) {
                    Danny.penColor(Color.red);
                } else if (colorIndex == 1) {
                    Danny.penColor(Color.magenta);
                } else if (colorIndex == 2) {
                    Danny.penColor(Color.pink);
                } else {
                    Danny.penColor(Color.yellow);
                }

                Danny.forward(length);
                Danny.left(5);
                length += 0.5;
            }

            Danny.forward(10);
            Danny.backward(10);

            Danny.right(10); // Rotate whole shape by 10 degrees for next petal
        }
//black Pupils
        for (int i = 0; i < 72; i++) {
            Turtle Mickey = new Turtle();
            Mickey.speed(0);
            Mickey.up();
            Mickey.setPosition(-322, 185); //at the center of the eye
            Mickey.down();

            for (int j = 0; j < i * 5; j++) {
                Mickey.left(1); // Rotate Mickey per step
            }

            Mickey.forward(425);
        }

        //create eyelid
        Danny.speed(0);
        Danny.width(5);
        double xCenter = -322;
        double yCenter = 185;

        double a = 1305;
        double b = 470;

        int steps = 200;

        // upper
        Danny.up();
        for (int i = 0; i <= steps; i++) {
            double t = (double) i / steps;
            double x = xCenter + a * (2 * t - 1); // จาก -a ถึง +a
            double relativeX = x - xCenter;
            double y = yCenter + b * Math.sqrt(1 - (relativeX * relativeX) / (a * a));

            if (i == 0) {
                Danny.setPosition(x, y);
                Danny.down();
            } else {
                Danny.setPosition(x, y);
            }
        }

        //lower eyelid
        Danny.up();
        for (int i = steps; i >= 0; i--) {
            double t = (double) i / steps;
            double x = xCenter + a * (2 * t - 1); // จาก +a กลับ -a
            double relativeX = x - xCenter;
            double y = yCenter - b * Math.sqrt(1 - (relativeX * relativeX) / (a * a));

            if (i == steps) {
                Danny.setPosition(x, y);
                Danny.down();
            } else {
                Danny.setPosition(x, y);
            }
        }

        Danny.up();
    }
}