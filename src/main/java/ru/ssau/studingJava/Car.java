package ru.ssau.studingJava;

import java.util.Arrays;

public class Car {
    private class Model {
        String name;
        double price;

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private String brand;
    private Model[] models;

    public Car() {
    }

    public Car(String brand, int size) {
        this.brand = brand;
        models = new Model[size];
        for (int i = 0; i < size; i++) {
            models[i] = new Model("Model " + i, (i + 1) * 100000);
        }
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModelName(String prevName, String newName) {
        for (Model carModel : models) {
            if (carModel.name.equals(prevName)) {
                carModel.name = newName;
            }
        }
    }

    public String[] getAllModelNames() {
        String[] modelNames = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            modelNames[i] = models[i].name;
        }
        return modelNames;
    }

    public double[] getAllModelPrices() {
        double[] modelPrices = new double[models.length];
        for (int i = 0; i < models.length; i++) {
            modelPrices[i] = models[i].price;
        }
        return modelPrices;
    }

    public double getPriceByModelName(String modelName) {
        for (Model carModel : models) {
            if (carModel.name.equals(modelName)) {
                return carModel.price;
            }
        }
        return -1;
    }

    public void setPriceByModelName(String modelName, double price) {
        for (Model carModel : models) {
            if (carModel.name.equals(modelName)) {
                carModel.price = price;
            }
        }
    }

    public void addModel(String name, double price) {
        Model[] newModels = Arrays.copyOf(models, models.length + 1);
        newModels[models.length] = new Model(name, price);
        models = newModels;
    }

    public void removeModel(String name) {
        String[] modelNames = getAllModelNames();
        int index = Arrays.asList(modelNames).indexOf(name);
        Model[] newModels = new Model[models.length - 1];
        if (index != -1) {
            System.arraycopy(models, 0, newModels, 0, index);
            System.arraycopy(models, index + 1, newModels, index, models.length - index - 1);
            models = newModels;
        }
    }

    public int getNumberOfModels() {
        return models.length;
    }
}
