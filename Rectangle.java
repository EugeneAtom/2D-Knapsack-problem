package Knapsack;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

/**
 * Created by eugene on 5/18/17.
 */
public class Rectangle {
    int xLength;
    int yLength;
    int square;

    /*
          B ******************* C
            *                 *
    yLength *                 *
            *                 *
          A ******************* D
                   xLength
     */
    Rectangle(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.square = xLength * yLength;
    }

    public Coordinates createCoordinates() {
        Point A = new Point(0, 0);
        Point B = new Point(0, yLength);
        Point C = new Point(xLength, yLength);
        Point D = new Point(xLength, 0);
        return new Coordinates(A, B, C, D);
    }

    public Coordinates createCoordinates(Point A) {
        Point B = new Point(A.x, A.y + yLength);
        Point C = new Point(A.x + xLength, A.y + yLength);
        Point D = new Point(A.x + xLength, A.y);
        return new Coordinates(A, B, C, D);
    }

    public boolean isBigger(Rectangle rectangle) {
        return xLength >= rectangle.xLength && yLength >= rectangle.yLength;
    }

    public ArrayList<Coordinates> create2RectanglesFrom1(Rectangle rectangle, Point point) {

        Point A1 = new Point(point.x, point.y + rectangle.yLength);
        Point B1 = new Point(point.x, point.y + yLength);
        Point C1 = new Point(point.x + rectangle.xLength, point.y + yLength);
        Point D1 = new Point(point.x + rectangle.xLength, point.y + rectangle.yLength);
        Coordinates leftRectangleCoordinates = new Coordinates(A1, B1, C1, D1);

        Point A2 = new Point(point.x + rectangle.xLength, point.y);
        Point B2 = new Point(point.x + rectangle.xLength, point.y + yLength);
        Point C2 = new Point(point.x + xLength, point.y + yLength);
        Point D2 = new Point(point.x + xLength, point.y);
        Coordinates rightRectangleCoordinates = new Coordinates(A2, B2, C2, D2);

        ArrayList<Coordinates> coordinates =  new ArrayList<>();
        coordinates.add(leftRectangleCoordinates);
        coordinates.add(rightRectangleCoordinates);
        return coordinates;
    }

    @Override
    public String toString() {
        return "Knapsack.Rectangle{" +
                "xLength=" + xLength +
                ", yLength=" + yLength +
                '}';
    }
}


class Coordinates {
    Point A;
    Point B;
    Point C;
    Point D;
    int xLength;
    int yLength;
    int square;

    public Coordinates(Point A, Point B, Point C, Point D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.xLength = D.x - A.x;
        this.yLength = B.y - A.y;
        this.square = xLength * yLength;
    }

    @Override
    public String toString() {
        return "\nKnapsack.Coordinates{" +
                "A=" + A +
                ", xLength=" + xLength +
                ", yLength=" + yLength +
                "C=" + C +
                "}";
    }

    protected Rectangle getRectangle() {
        int xLength = D.x - A.x;
        int yLength = B.y - A.y;
        return new Rectangle(xLength, yLength);
    }

    public void drawing() {
        Graphics graphics = new Graphics() {
            @Override
            public Graphics create() {
                return null;
            }

            @Override
            public void translate(int x, int y) {

            }

            @Override
            public Color getColor() {
                return null;
            }

            @Override
            public void setColor(Color c) {

            }

            @Override
            public void setPaintMode() {

            }

            @Override
            public void setXORMode(Color c1) {

            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public void setFont(Font font) {

            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                return null;
            }

            @Override
            public java.awt.Rectangle getClipBounds() {
                return null;
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {

            }

            @Override
            public void setClip(int x, int y, int width, int height) {

            }

            @Override
            public Shape getClip() {
                return null;
            }

            @Override
            public void setClip(Shape clip) {

            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {

            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {

            }

            @Override
            public void fillRect(int x, int y, int width, int height) {

            }

            @Override
            public void clearRect(int x, int y, int width, int height) {

            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void drawOval(int x, int y, int width, int height) {

            }

            @Override
            public void fillOval(int x, int y, int width, int height) {

            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawString(String str, int x, int y) {

            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {

            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public void dispose() {

            }
        };
    }
}


class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(x=" + x +
                ", y=" + y +
                ')';
    }
}