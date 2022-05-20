package edu.umb.cs681.hw16;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String strMake, strModel;
    private int mileage, year,price, dominationCount;

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

    public void setDominationCount(List<Car> cars) {
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
    	List<Car> lstCar = new ArrayList<>();
    	lstCar.add(new Car("Suzuki", "Ertiga", 2005, 24, 43000));
    	lstCar.add(new Car("Honda", "Tiago", 2008, 30, 40000));
    	lstCar.add(new Car("Audi", "A5", 2015,40 , 70000));
    	lstCar.add(new Car("Ford", "Figo", 2020, 35, 65000));
    	lstCar.forEach((Car car) -> car.setDominationCount(lstCar));

       
        
        int maxMileage = lstCar.stream().parallel().map((Car car) -> car.getMileage())
				 .reduce(0, (result, carMileage) -> {
					 if (result == 0)				return carMileage;
					 else if (carMileage < result)	return carMileage;
					 else							return result;}	);
        System.out.println("Minimum Car Mileage: " + maxMileage);
        
        int maxPrice = lstCar.stream().parallel().map((Car car) -> car.getPrice())
               .reduce(0, (result, carPrice) -> {
				   	if (result == 0)			return carPrice;
					else if (carPrice > result)	return carPrice;
					else						return result;}	);
        System.out.println("Maximum Car Price: $" + maxPrice);
       
        Integer avgPrice = lstCar.stream().parallel().map((Car car) -> car.getPrice())
                .reduce(0, (result,carPrice) -> result+carPrice, (finalResult, intermediateResult) -> finalResult)/lstCar.size();
        System.out.println("Average price of all Cars: $" + avgPrice);
        
        Integer carMakerNum = lstCar.stream().parallel().map( (Car car)-> car.getstrMake() )
                .reduce(0,(result,carMake)-> ++result,
                        (finalResult,intermediateResult)-> finalResult + intermediateResult);
        System.out.println("Total number of Car Makers: "+carMakerNum);

        Integer carModelNum = lstCar.stream().parallel().map( (Car car)-> car.getstrModel() )
                .reduce(0,(result,carModel)-> ++result,
                        (finalResult,intermediateResult)-> finalResult + intermediateResult);
        System.out.println("Total number of Car Models: "+carModelNum);
        
    }

}
