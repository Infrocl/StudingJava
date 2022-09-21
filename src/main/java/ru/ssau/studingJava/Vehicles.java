package ru.ssau.studingJava;

import java.util.Arrays;

public class Vehicles {
    private Vehicles() {
    }

    public static double modelPricesAverage(Vehicle vehicle) {
        double[] allPrices = vehicle.getAllModelPrices();
        double average = 0;
        for (double price : allPrices) {
            average += price;
        }
        return average / vehicle.getNumberOfModels();
    }

    public static void printAllModelNames(Vehicle vehicle) {
        System.out.println("Названия моделей " + vehicle.getBrand());
        System.out.println(Arrays.toString(vehicle.getAllModelNames()));
    }

    public static void printAllModelPrices(Vehicle vehicle) {
        System.out.println("Цены моделей " + vehicle.getBrand());
        System.out.println(Arrays.toString(vehicle.getAllModelPrices()));
    }
}
