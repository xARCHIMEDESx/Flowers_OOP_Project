package com.epam.bigdata.flower_task.flowershop;

import java.util.HashMap;

import com.epam.bigdata.flower_task.plants.*;

public class Vendor {
	
	private Bouquet bouquet;
	private HashMap<Integer, Plant> availablePlants;	
	
	public Vendor(HashMap<Integer, Plant> availablePlants){
		this.availablePlants = availablePlants;
		bouquet = new Bouquet();	
	}	
	
	public void bouquetFormation(int id) {	
			Plant p;
			p = availablePlants.get(id);
			if(!p.equals(null))
				bouquet.addPlant(p);	
	}
	
	
	public boolean findAFlower(String plantName){
		for(Plant plant : bouquet.getBouquet()) {
			if(plant.getName().equalsIgnoreCase(plantName)) {
				return true;
			}
		}
		return false;
	}
	
	
	public Bouquet sellTheBouquet() {
		return bouquet;
	}
}
