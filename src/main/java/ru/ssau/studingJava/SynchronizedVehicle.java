package ru.ssau.studingJava;

import ru.ssau.studingJava.exception.DuplicateModelNameException;
import ru.ssau.studingJava.exception.NoSuchModelNameException;

public class SynchronizedVehicle implements Vehicle {
    private final Vehicle vehicle;

    public SynchronizedVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public synchronized String getBrand() {
        return vehicle.getBrand();
    }

    @Override
    public synchronized void setBrand(String brand) {
        vehicle.setBrand(brand);
    }

    @Override
    public synchronized void setModelName(String prevName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        vehicle.setModelName(prevName, newName);
    }

    @Override
    public synchronized String[] getAllModelNames() {
        return vehicle.getAllModelNames();
    }

    @Override
    public synchronized double[] getAllModelPrices() {
        return vehicle.getAllModelPrices();
    }

    @Override
    public synchronized double getPriceByModelName(String modelName) throws NoSuchModelNameException {
        return vehicle.getPriceByModelName(modelName);
    }

    @Override
    public synchronized void setPriceByModelName(String modelName, double price) throws NoSuchModelNameException {
        vehicle.setPriceByModelName(modelName, price);
    }

    @Override
    public synchronized void addModel(String name, double price) throws DuplicateModelNameException {
        vehicle.addModel(name, price);
    }

    @Override
    public synchronized void removeModel(String name) throws NoSuchModelNameException {
        vehicle.removeModel(name);
    }

    @Override
    public synchronized int getNumberOfModels() {
        return vehicle.getNumberOfModels();
    }
}
