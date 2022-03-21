package edu.umb.cs681.hw2;

import java.util.*;
import java.util.stream.Collectors;

public class Car {

    private String strMake, strModel;
    private int mileage, year;
    private int price;
    private int dominationCount;

    public Car(String strMake, String strModel, int year, int mileage, int price) {
        this.strMake = strMake;
        this.strModel = strModel;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public int getDominationCount() {
        return dominationCount;
    }
    public String getstrMake() {
        return strMake;
    }
    public String getstrModel() {
        return strModel;
    }

    public int getYear() {
        return year;
    }
    public int getPrice() {
        return price;
    }
    public int getMileage() {
        return mileage;
    }

    public void setDominationCount(ArrayList<Car> cars) {
        for (Car car : cars) {
            if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
                    && (car.getYear() <= this.getYear())) {
                this.dominationCount++;
            }
        }
        this.dominationCount--;
    }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        if(strMake.equals(car.getstrMake()) && strModel.equals(car.getstrModel()) && year==car.getYear() && mileage==car.getMileage() && price==car.getPrice() && dominationCount==car.getDominationCount())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.strMake+" - "+this.strModel+" - "+this.year+" - Mileage:"+this.mileage+" - $"+this.price;
    }

    public static void main(String[] args) {
    	List<Car> objCar = new ArrayList<>();
        objCar.add(new Car("Suzuki", "Ertiga", 2005, 24, 43000));
        objCar.add(new Car("Honda", "Tiago", 2008, 30, 40000));
        objCar.add(new Car("Audi", "A5", 2015,40 , 70000));
        objCar.add(new Car("Ford", "Figo", 2020, 35, 65000));


/*
        Integer minPrice = carList.stream().map((Car car) -> car.getPrice()).reduce(Integer::min).get();
        Integer maxPrice = carList.stream().map((Car car) -> car.getPrice()).reduce(Integer::max).get();
*/

        OptionalInt minPrice = objCar.stream().mapToInt((Car car) -> car.getPrice()).min();
        System.out.println("Lowest priced car: $"+minPrice.getAsInt());

        OptionalInt maxPrice = objCar.stream().mapToInt((Car car) -> car.getPrice()).max();
        System.out.println("Highest priced car: $"+maxPrice.getAsInt());


        Integer avgPrice = objCar.stream()
                .map((Car car) -> car.getPrice())
                .reduce(0, (result,price) -> result+price, (finalResult, intermediateResult) -> finalResult)/objCar.size();

        System.out.println("Average price of all Cars: $" + avgPrice);
    }

}