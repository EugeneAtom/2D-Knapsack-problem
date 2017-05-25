package Knapsack;

import Knapsack.Data;
import Knapsack.GA;
import Knapsack.Group;
import Knapsack.InputFromFile;

import java.util.ArrayList;

/**
 * Created by eugene on 5/18/17.
 */
public class Main {
    public static void main(String[] args) {
        String rectanglesFile = "/home/eugene/Documents/2D-Knapsack-problem/2D Knapsack/src/Knapsack/rectangles.txt";
        Group groupSet = InputFromFile.getRectanglesFromFile(rectanglesFile);
        String areaFile = "/home/eugene/Documents/2D-Knapsack-problem/2D Knapsack/src/Knapsack/area.txt";
        Rectangle area = InputFromFile.getArea(areaFile);

        int groupSize = 10;
        int populationSize = 20;
        int square = area.square;
        int pickedIndividuals = 7;

        Data data = new Data(groupSize, populationSize, square, pickedIndividuals, groupSet.rectangles.size());

        ArrayList<Coordinates> bestGroup = GA.pickBestGroup(data, area, groupSet, 5);
        System.out.println("final population: " + bestGroup);
        System.out.println("area square " + area.square);
        double totalSquare = GA.getTotalSquare(bestGroup);
        System.out.println("total square " + totalSquare);
        System.out.println("Percent of filling " + Math.round(totalSquare / area.square * 100) + "%");
//        for (Coordinates coordinates : bestGroup) {
//            Polygon p = new Polygon();
//            p.addPoint(coordinates.A.x, coordinates.A.y);
//            p.addPoint(coordinates.B.x, coordinates.B.y);
//            p.addPoint(coordinates.C.x, coordinates.C.y);
//            p.addPoint(coordinates.D.x, coordinates.D.y);
//            Graphics g = new Graphics() {
//                @Override
//                public Graphics create() {
//                    return null;
//                }
//
//                @Override
//                public void translate(int x, int y) {
//
//                }
//
//                @Override
//                public Color getColor() {
//                    return null;
//                }
//
//                @Override
//                public void setColor(Color c) {
//
//                }
//
//                @Override
//                public void setPaintMode() {
//
//                }
//
//                @Override
//                public void setXORMode(Color c1) {
//
//                }
//
//                @Override
//                public Font getFont() {
//                    return null;
//                }
//
//                @Override
//                public void setFont(Font font) {
//
//                }
//
//                @Override
//                public FontMetrics getFontMetrics(Font f) {
//                    return null;
//                }
//
//                @Override
//                public Knapsack.Rectangle getClipBounds() {
//                    return null;
//                }
//
//                @Override
//                public void clipRect(int x, int y, int width, int height) {
//
//                }
//
//                @Override
//                public void setClip(int x, int y, int width, int height) {
//
//                }
//
//                @Override
//                public Shape getClip() {
//                    return null;
//                }
//
//                @Override
//                public void setClip(Shape clip) {
//
//                }
//
//                @Override
//                public void copyArea(int x, int y, int width, int height, int dx, int dy) {
//
//                }
//
//                @Override
//                public void drawLine(int x1, int y1, int x2, int y2) {
//
//                }
//
//                @Override
//                public void fillRect(int x, int y, int width, int height) {
//
//                }
//
//                @Override
//                public void clearRect(int x, int y, int width, int height) {
//
//                }
//
//                @Override
//                public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
//
//                }
//
//                @Override
//                public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
//
//                }
//
//                @Override
//                public void drawOval(int x, int y, int width, int height) {
//
//                }
//
//                @Override
//                public void fillOval(int x, int y, int width, int height) {
//
//                }
//
//                @Override
//                public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
//
//                }
//
//                @Override
//                public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
//
//                }
//
//                @Override
//                public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
//
//                }
//
//                @Override
//                public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
//
//                }
//
//                @Override
//                public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
//
//                }
//
//                @Override
//                public void drawString(String str, int x, int y) {
//
//                }
//
//                @Override
//                public void drawString(AttributedCharacterIterator iterator, int x, int y) {
//
//                }
//
//                @Override
//                public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
//                    return false;
//                }
//
//                @Override
//                public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
//                    return false;
//                }
//
//                @Override
//                public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
//                    return false;
//                }
//
//                @Override
//                public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
//                    return false;
//                }
//
//                @Override
//                public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
//                    return false;
//                }
//
//                @Override
//                public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
//                    return false;
//                }
//
//                @Override
//                public void dispose() {
//
//                }
//            };
//            g.drawPolygon(p);
//        }
    }
}
