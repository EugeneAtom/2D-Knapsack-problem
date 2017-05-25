package Knapsack;

import Knapsack.Group;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 5/18/17.
 */
public class InputFromFile {
    public static Group getRectanglesFromFile(String pathToFile) {
        List<String> lines = null;
        int size = 0;
        try {
            lines = Files.readAllLines(Paths.get(pathToFile), StandardCharsets.UTF_8);
            size = lines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        if (size > 0) {
            for (String line : lines) {
                int xLength = Integer.parseInt(line.split(" ")[0]);
                int yLength = Integer.parseInt(line.split(" ")[1]);
                int amount = Integer.parseInt(line.split(" ")[2]);
                for (int i = 0; i < amount; i++) {
                    rectangles.add(new Rectangle(xLength, yLength));
                }
            }
        }
        return new Group(rectangles);
    }


    public static Rectangle getArea(String pathToFile) {
        List<String> line = null;
        try {
            line = Files.readAllLines(Paths.get(pathToFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int xLength = Integer.parseInt(line.get(0).split(" ")[0]);
        int yLength = Integer.parseInt(line.get(0).split(" ")[1]);
        return new Rectangle(xLength, yLength);
    }
}