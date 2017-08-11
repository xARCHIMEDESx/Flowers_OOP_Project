package com.epam.bigdata.flower_task.plants;

public abstract class Plant {
	protected String name;
	protected double price;
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
