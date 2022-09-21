package ru.ssau.studingJava;

public interface Vehicle {
    String getBrand();

    void setBrand(String brand);

    void setModelName(String prevName, String newName) throws DuplicateModelNameException, NoSuchModelNameException;

    String[] getAllModelNames();

    double[] getAllModelPrices();

    double getPriceByModelName(String modelName) throws NoSuchModelNameException;

    void setPriceByModelName(String modelName, double price) throws NoSuchModelNameException;

    void addModel(String name, double price) throws DuplicateModelNameException;

    void removeModel(String name) throws NoSuchModelNameException;

    int getNumberOfModels();
}
