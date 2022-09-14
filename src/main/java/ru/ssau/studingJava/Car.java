package ru.ssau.studingJava;

import java.util.Arrays;

public class Car {
    private String brand;
    private Model[] models;

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

    public String[] getAllModelNames() {
        String[] modelNames = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            modelNames[i] = models[i].getName();
        }
        return modelNames;
    }

    public double[] getAllModelPrices() {
        double[] modelPrices = new double[models.length];
        for (int i = 0; i < models.length; i++) {
            modelPrices[i] = models[i].getPrice();
        }
        return modelPrices;
    }

    public double getPriceByModelName(String modelName) {
        for (Model carModel : models) {
            if (carModel.getName().equals(modelName)) {
                return carModel.getPrice();
            }
        }
        return -1;
    }

    public void setPriceByModelName(String modelName, double price) {
        for (Model carModel : models) {
            if (carModel.getName().equals(modelName)) {
                carModel.setPrice(price);
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

    private class Model {
        String name;
        double price;

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
