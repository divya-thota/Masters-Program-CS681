package edu.umb.cs681.hw1;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

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

        System.out.println("\nCars order by Year:");
        List<Car> orderByYear=objCar.stream().sorted(Comparator.comparingInt(Car::getYear)).collect(Collectors.toList());
        orderByYear.forEach(System.out::println);
        
        System.out.println("Cars order by Price:");
        List<Car> orderByPrice=objCar.stream().sorted(Comparator.comparingInt(Car::getPrice)).collect(Collectors.toList());
        orderByPrice.forEach(System.out::println);
        
        System.out.println("\nCars order by Mileage:");
        List<Car> orderByMileage=objCar.stream().sorted(Comparator.comparingInt(Car::getMileage)).collect(Collectors.toList());
        orderByMileage.forEach(System.out::println);

        System.out.println("\nCars order by Domination rank:");
        List<Car> orderByDomination=objCar.stream().sorted(Comparator.comparingInt(Car::getDominationCount)).collect(Collectors.toList());
        orderByDomination.forEach(System.out::println);
    }
}