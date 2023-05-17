package ru.ssau.studingJava;

import ru.ssau.studingJava.factory.AutoFactory;
import ru.ssau.studingJava.factory.VehicleFactory;

import java.util.Arrays;

public class Vehicles {
    private static VehicleFactory factory = new AutoFactory();

    private Vehicles() {
    }

    public static Vehicle getSynchronizedVehicle(Vehicle v) {
        return new SynchronizedVehicle(v);
    }

    public static void setVehicleFactory(VehicleFactory vehicleFactory) {
        factory = vehicleFactory;
    }

    public static Vehicle createInstance(String brand, int size) {
        return factory.createInstance(brand, size);
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
