package ru.ssau.studingJava;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class CarTest {
    private Car getCar() {
        return new Car("Lada", 5);
    }

    @Test
    public void testGetAllModelNames() {
        System.out.println(Arrays.toString(getCar().getAllModelNames()));
    }

    @Test
    public void testGetAllModelPrices() {
        System.out.println(Arrays.toString(getCar().getAllModelPrices()));
    }

    @Test
    public void testGetPriceByModelName() {
        assertEquals(getCar().getPriceByModelName("Model 0"), 100000.0);
    }

    @Test
    public void testSetPriceByModelName() {
        Car newCar = getCar();
        newCar.setPriceByModelName("Model 0", 55);
        assertEquals(newCar.getPriceByModelName("Model 0"), 55.0);
    }

    @Test
    public void testAddModel() {
        Car newCar = getCar();
        newCar.addModel("Model 79", 790000);
        assertEquals(newCar.getNumberOfModels(), 6);
        assertEquals(newCar.getPriceByModelName("Model 79"), 790000);
        System.out.println(Arrays.toString(newCar.getAllModelNames()));
    }

    @Test
    public void testRemoveModel() {
        Car firstCar = getCar();
        firstCar.removeModel("Model 0");
        assertEquals(firstCar.getNumberOfModels(), 4);
        System.out.println(Arrays.toString(firstCar.getAllModelNames()));
        Car secondCar = getCar();
        secondCar.removeModel("Model 4");
        assertEquals(firstCar.getNumberOfModels(), 4);
        System.out.println(Arrays.toString(secondCar.getAllModelNames()));
        Car thirdCar = getCar();
        thirdCar.removeModel("Model 1");
        assertEquals(firstCar.getNumberOfModels(), 4);
        System.out.println(Arrays.toString(thirdCar.getAllModelNames()));
        Car fourthCar = getCar();
        fourthCar.removeModel("Model");
        assertEquals(fourthCar.getNumberOfModels(), 5);
        System.out.println(Arrays.toString(fourthCar.getAllModelNames()));
    }
}