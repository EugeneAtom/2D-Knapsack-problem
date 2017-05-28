package Knapsack;

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
                ", C=" + C +
                "}";
    }

    protected Rectangle getRectangle() {
        int xLength = D.x - A.x;
        int yLength = B.y - A.y;
        return new Rectangle(xLength, yLength);
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