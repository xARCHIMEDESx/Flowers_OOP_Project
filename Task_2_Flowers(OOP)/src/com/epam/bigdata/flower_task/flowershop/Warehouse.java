package com.epam.bigdata.flower_task.flowershop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.epam.bigdata.flower_task.comparator.FlowerComparator;
import com.epam.bigdata.flower_task.plants.*;
import com.epam.bigdata.flower_task.xmlparser.FlowerDataBase;

public class Warehouse {

	private HashMap<Integer, Plant> plantsInTheWarehouse = new HashMap<>();
			
	public Warehouse(String path) {
		FlowerDataBase.loadData(path);		
	}
	
	public HashMap<Integer, Plant> update() {	
		List<Plant> plantList = new ArrayList<>();
		plantList.addAll(FlowerComparator.compareByName(FlowerDataBase.flowerParsing()));		
		plantList.addAll(FlowerComparator.compareByName(FlowerDataBase.cactusParsing()));
	
		for(int i = 0; i < plantList.size(); i++) {
			plantsInTheWarehouse.put(i+1, plantList.get(i));
		}
		
		return plantsInTheWarehouse;
	}
	
}
