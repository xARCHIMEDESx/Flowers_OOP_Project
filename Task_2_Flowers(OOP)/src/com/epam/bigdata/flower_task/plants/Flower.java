package com.epam.bigdata.flower_task.plants;

public class Flower extends Plant{
		
	private double stemLength;
	private double hoursFromCutting;
	
	public double getStemLength() {
		return stemLength;
	}
	
	public double getHoursFromCutting() {
		return hoursFromCutting;
	}
	
	public void setStemLength(double stemLength) {
		this.stemLength = stemLength;
	}
	
	public void setHoursFromCutting(double hoursFromCutting) {
		this.hoursFromCutting = hoursFromCutting;		
	}
}
