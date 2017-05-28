package Knapsack;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by eugene on 5/18/17.
 */
public class Main {
    public static void main(String[] args) {
        String rectanglesFile = "/home/eugene/Documents/2D-Knapsack-problem/2D Knapsack/src/Knapsack/rectangles.txt";
        Group groupSet = InputFromFile.getRectanglesFromFile(rectanglesFile);
        String areaFile = "/home/eugene/Documents/2D-Knapsack-problem/2D Knapsack/src/Knapsack/area.txt";
        Rectangle area = InputFromFile.getArea(areaFile);

        int groupSize = 120;
        int populationSize = 50;
        int square = area.square;

        Data data = new Data(groupSize, populationSize, square, groupSet.rectangles.size());
        ArrayList<Coordinates> bestGroup = GA.pickBestGroup(data, area, groupSet, 40);
        System.out.println("final population: " + bestGroup);
        System.out.println("area square " + area.square);
        double totalSquare = GA.getTotalSquare(bestGroup);
        System.out.println("total square " + totalSquare);
        System.out.println("Percent of filling " + Math.round(totalSquare / area.square * 100) + "%");

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, area.xLength, area.yLength);
        int i = 0;
        for (Coordinates rectangle : bestGroup) {
            window.getContentPane().add(new MyPaint(rectangle.A.x, rectangle.A.y, rectangle.xLength, rectangle.yLength));
            window.setVisible(true);
            i += 1;
        }
        window.setVisible(true);
    }
}

class MyPaint extends JComponent {
    int x;
    int y;
    int yLength;
    int xLength;
    public MyPaint (int x, int y, int xLength, int yLength) {
        this.x = x;
        this.y = y;
        this.yLength = yLength;
        this.xLength = xLength;
    }

    public void paint(Graphics g) {
        Random random = new Random();
        String c1 = "C";
        String c2 = String.valueOf(random.nextInt(8));
        String c3 = String.valueOf(random.nextInt(8));
        String c4 = String.valueOf(random.nextInt(8));
        String c5 = String.valueOf(random.nextInt(8));
        String c6 = String.valueOf(random.nextInt(8));
        g.setColor(Color.decode("#" + c1 + c2 + c3 + c4 + c5 + c6));
        g.fillRect(x, y, xLength, yLength);
        g.drawRect (x, y, xLength, yLength);
    }
}