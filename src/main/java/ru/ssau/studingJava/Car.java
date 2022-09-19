package ru.ssau.studingJava;

import java.util.Arrays;
import java.util.List;

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

    public void setModelName(String prevName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        List<String> allModelsName = Arrays.asList(getAllModelNames());
        if (allModelsName.contains(newName)) {
            throw new DuplicateModelNameException();
        }
        int index = allModelsName.indexOf(prevName);
        if (index != -1) {
            models[index].name = newName;
        } else {
            throw new NoSuchModelNameException();
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

    public double getPriceByModelName(String modelName) throws NoSuchModelNameException {
        for (Model carModel : models) {
            if (carModel.name.equals(modelName)) {
                return carModel.price;
            }
        }
        throw new NoSuchModelNameException();
    }

    public void setPriceByModelName(String modelName, double price) throws NoSuchModelNameException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        List<String> allModelsName = Arrays.asList(getAllModelNames());
        int index = allModelsName.indexOf(modelName);
        if (index != -1) {
            models[index].price = price;
        } else {
            throw new NoSuchModelNameException();
        }
    }

    public void addModel(String name, double price) throws DuplicateModelNameException {
        List<String> allModelNames = Arrays.asList(getAllModelNames());
        if (allModelNames.contains(name)) {
            throw new DuplicateModelNameException();
        }
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        Model[] newModels = Arrays.copyOf(models, models.length + 1);
        newModels[models.length] = new Model(name, price);
        models = newModels;
    }

    public void removeModel(String name) throws NoSuchModelNameException {
        List<String> allModelNames = Arrays.asList(getAllModelNames());
        int index = allModelNames.indexOf(name);
        if (index != -1) {
            Model[] newModels = new Model[models.length - 1];
            System.arraycopy(models, 0, newModels, 0, index);
            System.arraycopy(models, index + 1, newModels, index, models.length - index - 1);
            models = newModels;
        } else {
            throw new NoSuchModelNameException();
        }
    }

    public int getNumberOfModels() {
        return models.length;
    }
}
