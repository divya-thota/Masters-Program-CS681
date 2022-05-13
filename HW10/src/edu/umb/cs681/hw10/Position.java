package edu.umb.cs681.hw10;

import java.util.ArrayList;
import java.util.List;

public final class Position {
	private final double latitude, longitude, altitude;
	public Position(double latitude, double longitude, double altitude){ 
		this.latitude = latitude; 
		this.longitude = longitude; 
		this.altitude = altitude; 
	}
	
	public double getlatitude(){ 
		return latitude;
	} 
	
	public double getlongitude(){ 
		return longitude; 
	} 
	
	public double getaltitude(){ 
		return altitude; 
	} 
	
	public String toString() {
        return this.latitude + "," + this.longitude + "," + this.altitude;
    }

    public boolean equals(Position comparePosition) {
        if (this.toString().equals(comparePosition.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public List<Double> getCoordinate(){
    	List<Double> lstCoordinate = new ArrayList<Double>();
    	lstCoordinate.add(this.latitude);
    	lstCoordinate.add(this.longitude);
    	lstCoordinate.add(this.altitude);
    	return lstCoordinate;
    }
    
    public Position changeLat(double newLat) {
    	return new Position(newLat, this.longitude, this.altitude);
    }
    
    public Position  changeLon(double newLon) {
    	return new Position(this.latitude, newLon, this.altitude);
    }
    
    public Position changeAlt(double newAlt) {
    	return new Position(this.latitude, this.longitude, newAlt);
    }
    
    public double distanceTo(Position anotherPosition) {
    	return (this.latitude-anotherPosition.latitude)+(this.longitude-anotherPosition.longitude)+(this.altitude-anotherPosition.altitude);
    }
}
