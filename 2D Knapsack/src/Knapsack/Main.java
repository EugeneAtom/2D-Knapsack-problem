package Knapsack;

import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

class MyPaint extends JComponent {
    int x;
    int y;
    int yLength;
    int xLength;
    int i;
    public MyPaint (int i, int x, int y, int xLength, int yLength) {
        this.x = x;
        this.y = y;
        this.yLength = yLength;
        this.xLength = xLength;
    }

    public void paint(Graphics g) {
        Random random = new Random();
        String c1 = String.valueOf(random.nextInt(8));
        String c2 = String.valueOf(random.nextInt(7));
        String c3 = String.valueOf(random.nextInt(2));
        String c4 = String.valueOf(random.nextInt(6));
        String c5 = String.valueOf(random.nextInt(5));
        String c6 = String.valueOf(random.nextInt(1));
        g.setColor(Color.decode(c1 + c2 + c3 + c4 + c5 + c6));
        g.fillRect(x, y, xLength, yLength);
        g.drawRect (x, y, xLength, yLength);
    }
}

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
        int pickedIndividuals = groupSize / 3 * 2;

        Data data = new Data(groupSize, populationSize, square, pickedIndividuals, groupSet.rectangles.size());

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
            window.getContentPane().add(new MyPaint(i, rectangle.A.x, rectangle.A.y, rectangle.xLength, rectangle.yLength));
            window.setVisible(true);
            i += 1;
        }

//        JFrame window = new JFrame();
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setBounds(100, 100, area.xLength, area.yLength);
//        window.getContentPane().add(new MyPaint(10, 100, 100, 200, 200));
//        window.setVisible(true);
//        window.getContentPane().add(new MyPaint(10, 300, 100, 200, 200));
//        window.setVisible(true);
//        window.getContentPane().add(new MyPaint(10, 100, 300, 200, 200));
//        window.setVisible(true);
//        window.getContentPane().add(new MyPaint(10, 300, 300, 200, 200));
//        window.getContentPane().add(new MyPaint(10, 0, 00, 20, 20));
        window.setVisible(true);
    }
}