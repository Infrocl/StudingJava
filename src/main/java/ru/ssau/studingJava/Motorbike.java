package ru.ssau.studingJava;

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

    public Motorbike() {
    }

    public Motorbike(String brand, int size) {
        this.brand = brand;
        int i = 0;
        while (i != size) {
            addModel("Model " + i, (i + 1) * 7000);
            i++;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setModelName(String prevName, String newName) {
        Model temp = head;
        for (int i = 0; i != size; i++) {
            if (temp.name.equals(prevName)) {
                temp.name = newName;
            }
            temp = temp.next;
        }
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

    public double getPriceByModelName(String modelName) {
        Model temp = head;
        for (int i = 0; i != size; i++) {
            if (temp.name.equals(modelName)) {
                return temp.price;
            }
        }
        return -1;
    }

    public void setPriceByModelName(String modelName, double price) {
        Model temp = head;
        for (int i = 0; i != size; i++) {
            if (temp.name.equals(modelName)) {
                temp.price = price;
                break;
            }
        }
    }

    public void addModel(String name, double price) {
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
    }

    public void removeModel(String name) {
        Model temp = head;
        for (int i = 0; i != size; i++) {
            if (temp.name.equals(name)) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
    }
}
