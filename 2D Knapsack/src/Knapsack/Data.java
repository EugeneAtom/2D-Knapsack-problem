package Knapsack;

/**
 * Created by eugene on 5/18/17.
 */

public class Data {
    int groupSize;
    int populationSize;
    int area;
    int pickedIndividuals;
    int randomIndividuals;
    int allRectangles;

    public Data(int groupSize, int populationSize, int area, int pickedIndividuals, int allRectangles) {
        this.groupSize = groupSize;
        this.populationSize = populationSize;
        this.area = area;
        this.pickedIndividuals = pickedIndividuals;
        this.randomIndividuals = groupSize - pickedIndividuals;
        this.allRectangles = allRectangles;
    }
}
