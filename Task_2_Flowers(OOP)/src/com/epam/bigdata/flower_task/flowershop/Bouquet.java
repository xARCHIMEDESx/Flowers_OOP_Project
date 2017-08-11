package com.epam.bigdata.flower_task.flowershop;

import java.util.*;
import com.epam.bigdata.flower_task.plants.Plant;

public class Bouquet {
		
	private List<Plant> bouquet = new ArrayList<>();
	
	public void addPlant(Plant plant) {
		bouquet.add(plant);
	}
	
	public List<Plant> getBouquet(){
		return bouquet;
	}	
}
