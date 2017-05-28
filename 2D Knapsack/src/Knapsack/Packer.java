package Knapsack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by eugene on 5/18/17.
 */
public class Packer {
    Group group;
    LinkedList<Coordinates> areasCoordinates  = new LinkedList<>();
    int square = 0;

    public Packer(Group group, Rectangle area) {
        this.group = group;
        this.areasCoordinates.add(area.createCoordinates());
    }

    public ArrayList<Coordinates> pack() {
        ArrayList<Coordinates> coordinatesArray = new ArrayList<>();
        for (Rectangle rectangle : group.rectangles) {
            for (int i = 0; i < areasCoordinates.size(); i++) {
                Coordinates areaCoordinates = areasCoordinates.get(i);
                Rectangle area = areaCoordinates.getRectangle();
                if (area.isBigger(rectangle)) {
                    Point A = areaCoordinates.A;

                    areasCoordinates.remove(i);
                    areasCoordinates.addAll(area.create2RectanglesFrom1(rectangle, A));

                    Coordinates rectangleCoordinates = rectangle.createCoordinates(A);
                    coordinatesArray.add(rectangleCoordinates);
                    square += rectangle.square;
                    break;
                }
            }
        }
        return coordinatesArray;
    }
}
