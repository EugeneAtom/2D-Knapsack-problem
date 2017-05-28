package Knapsack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by eugene on 5/18/17.
 */
public class GA {
    public static ArrayList<Rectangle> generateRandomArray(ArrayList<Rectangle> rectangles, int pickSize) {
        ArrayList<Rectangle> randomArray = new ArrayList<>();
        Random random = new Random();
        int length = rectangles.size();
        for (int i = 0; i < pickSize; i++) {
            randomArray.add(rectangles.get(random.nextInt(length)));
        }
        return randomArray;
    }

    /*
    Выбирает случайные элементы из массива
    array - исходный массив
    pickElements - количестов элементов, которые нужно выбрать из массива
     */
    public static ArrayList<Rectangle> getRandomArray(ArrayList<Coordinates> coordinates, int pickSize) {
        ArrayList<Rectangle> randomArray = new ArrayList<>();
        int size = coordinates.size();
        Random random = new Random();
        for (int i = 0; i < pickSize; i++) {
            randomArray.add(coordinates.get(random.nextInt(size)).getRectangle());
        }
        return randomArray;
    }


    public static ArrayList<Coordinates> getBestGroup(Rectangle area, ArrayList<Group> groups) {
        int deviation = Integer.MAX_VALUE;
        ArrayList<Coordinates> bestGroup = new ArrayList<>();
        for (Group group : groups) {
            Packer packer = new Packer(group, area);
            ArrayList<Coordinates> coordinates = packer.pack();
            int square = packer.square;
            if (0 <= area.square - square && area.square - square < deviation) {
                bestGroup = coordinates;
                deviation = area.square - square;
            }
        }
        return bestGroup;
    }


    public static ArrayList<Group> generateFirstPopulation(Data data, ArrayList<Rectangle> rectangles) {
        ArrayList<Group> firstPopulation = new ArrayList<>();
        for (int i = 0; i < data.populationSize; i++) {
            ArrayList<Rectangle> newRectangles = generateRandomArray(rectangles, data.groupSize);
            firstPopulation.add(new Group(newRectangles));
        }
        return firstPopulation;
    }


    public static ArrayList<Coordinates> pickBestGroup(Data data, Rectangle area, Group groupSet, int repeat) {
        ArrayList<Rectangle> pickedArray;
        ArrayList<Rectangle> randomArray;
        ArrayList<Rectangle> array;

        ArrayList<Group> firstPopulation = GA.generateFirstPopulation(data, groupSet.rectangles);
        ArrayList<Coordinates> bestGroup = GA.getBestGroup(area, firstPopulation);

        for (int count = 0; count < repeat; count++) {
            ArrayList<Group> nextPopulation = new ArrayList<>();
            for (int i = 0; i < data.populationSize; i++) {
                pickedArray = GA.getRandomArray(bestGroup, data.pickedIndividuals);
                randomArray = GA.generateRandomArray(groupSet.rectangles, data.randomIndividuals);
                array = concat(pickedArray, randomArray);
                nextPopulation.add(new Group(array));
            }
            bestGroup = GA.getBestGroup(area, nextPopulation);
//            if (GA.getTotalSquare(bestGroup) * 100 / area.square >= 90) {
//                break;
//            }
        }
        return bestGroup;
    }


    public static ArrayList<Rectangle> concat(ArrayList<Rectangle> first, ArrayList<Rectangle> second) {
        int size = first.size() + second.size();
        ArrayList<Rectangle> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i < first.size()) {
                result.add(first.get(i));
            }
            else {
                result.add(second.get(i - first.size()));
            }
        }
        return result;
    }

    public static int getTotalSquare(ArrayList<Coordinates> arrayList) {
        int square = 0;
        for (Coordinates coordinates : arrayList) {
            square += coordinates.square;
        }
        return square;
    }


}
