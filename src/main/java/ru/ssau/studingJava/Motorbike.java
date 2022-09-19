package ru.ssau.studingJava;

import java.util.Arrays;
import java.util.List;

public class Motorbike {
    private class Model {
        String name = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public Model() {
        }

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private int size = 0;
    private Model head;
    private long lastModified;
    private String brand;

    {
        lastModified = System.currentTimeMillis();
    }

    public Motorbike() {
    }

    public Motorbike(String brand, int size) {
        this.brand = brand;
        this.size = size;
        Model newModel = new Model("Model 0", 7000);
        newModel.prev = newModel;
        newModel.next = newModel;
        head = newModel;
        for (int i = 1; i != size; i++) {
            Model nextModel = new Model("Model " + i, (i + 1) * 7000);
            Model last = head.prev;
            nextModel.prev = last;
            head.prev = nextModel;
            last.next = nextModel;
            nextModel.next = head;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
        lastModified = System.currentTimeMillis();
    }

    public int getNumberOfModels() {
        return size;
    }

    public void setModelName(String prevName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        Model temp = head;
        for (int i = 0; i != size; i++) {
            if (temp.name.equals(newName)) {
                throw new DuplicateModelNameException();
            }
            if (temp.name.equals(prevName)) {
                temp.name = newName;
                lastModified = System.currentTimeMillis();
                return;
            }
            temp = temp.next;
        }
        throw new NoSuchModelNameException();
    }

    public String[] getAllModelNames() {
        String[] allNames = new String[size];
        Model temp = head;
        for (int i = 0; i != size; i++) {
            allNames[i] = temp.name;
            temp = temp.next;
        }
        return allNames;
    }

    public double[] getAllModelPrices() {
        double[] allPrices = new double[size];
        Model temp = head;
        for (int i = 0; i != size; i++) {
            allPrices[i] = temp.price;
            temp = temp.next;
        }
        return allPrices;
    }

    public double getPriceByModelName(String modelName) throws NoSuchModelNameException {
        Model temp = head;
        for (int i = 0; i != size; i++) {
            if (temp.name.equals(modelName)) {
                return temp.price;
            }
            temp = temp.next;
        }
        throw new NoSuchModelNameException();
    }

    public void setPriceByModelName(String modelName, double price) throws NoSuchModelNameException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        Model temp = head;
        for (int i = 0; i != size; i++) {
            if (temp.name.equals(modelName)) {
                temp.price = price;
                lastModified = System.currentTimeMillis();
                return;
            }
            temp = temp.next;
        }
        throw new NoSuchModelNameException();
    }

    public void addModel(String name, double price) throws DuplicateModelNameException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        List<String> allModelNames = Arrays.asList(getAllModelNames());
        if (allModelNames.contains(name)) {
            throw new DuplicateModelNameException();
        }
        Model newModel = new Model(name, price);
        if (size == 0) {
            newModel.prev = newModel;
            newModel.next = newModel;
            head = newModel;
        } else {
            Model last = head.prev;
            newModel.prev = last;
            head.prev = newModel;
            last.next = newModel;
            newModel.next = head;
        }
        size++;
        lastModified = System.currentTimeMillis();
    }

    public void removeModel(String name) throws NoSuchModelNameException {
        Model temp = head;
        for (int i = 0; i != size; i++) {
            if (temp.name.equals(name)) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                if (i == 0) {
                    head = temp.next;
                }
                size--;
                lastModified = System.currentTimeMillis();
                return;
            }
            temp = temp.next;
        }
        throw new NoSuchModelNameException();
    }
}
