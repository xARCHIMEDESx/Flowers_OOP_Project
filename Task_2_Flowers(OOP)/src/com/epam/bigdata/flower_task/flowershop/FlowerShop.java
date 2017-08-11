package com.epam.bigdata.flower_task.flowershop;

import java.util.HashMap;
import java.util.InputMismatchException;
import com.epam.bigdata.flower_task.comparator.FlowerComparator;
import com.epam.bigdata.flower_task.plants.*;
import com.epam.bigdata.flower_task.singletonscanner.SingletonScanner;


public class FlowerShop {

	private Bouquet customersBouquet;
	private Vendor vendor;
	private Warehouse warehouse;
	private HashMap<Integer, Plant> availablePlants;
	private final String warehouseAddress = "flowers.xml";
	
	public FlowerShop() {		
		warehouse = new Warehouse(warehouseAddress);
		availablePlants = warehouse.update();
		vendor = new Vendor(availablePlants);
		startMenu();		
		vendingMenu();
	}	
	
	private void vendingMenu(){		
		while(true){	
			try {					
				System.out.print("Please, choose a flower to add: ");
				int id = SingletonScanner.getInstance().nextInt();					
		
				if (id == 0) {
					break;
				}
								
				vendor.bouquetFormation(id);				
			}
				
			catch(InputMismatchException | NullPointerException ex){
				System.out.println("Wrong input. Try again.\n");		
				SingletonScanner.getInstance().next();
				vendingMenu();
				break;
			}
		}		
	}
			
	public void getFlowerWithTheLongestStem() {
		String flowerWithTheLongestStem;
		FlowerComparator.compareByStemLength(customersBouquet);		
		try {
			flowerWithTheLongestStem = ((Flower) customersBouquet.getBouquet().get(0)).getName();
			System.out.println("The flower with the longest stem your bouquet is: " + flowerWithTheLongestStem);
		}
		catch (ClassCastException ex) {
			System.out.println("There is no flower with a stem in the bouquet");
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("You must choose at least one flower");
		}
	}
	
	public void getTheFreshestFlower() {
		String theFreshestFlower;	
		FlowerComparator.compareByHoursFromCutting(customersBouquet);
		try {
			theFreshestFlower = ((Flower) customersBouquet.getBouquet().get(0)).getName();
			System.out.println("The freshest flower in your bouquet is: " + theFreshestFlower);		
		}
		catch (ClassCastException ex) {
			System.out.println("There is no flower with freshness quality in the bouquet");
		}
		
		catch (IndexOutOfBoundsException ex) {
			System.out.println("You must choose at least one flower");
		}
	}
	
	public void getTotalPrice() {
		Double price = 0.00;
		for(Plant plant : customersBouquet.getBouquet()) {
			price += plant.getPrice();		
		}
		System.out.println("\nBouquet total price is: " + price + "₴");
	}
	
	public void buy() {
		customersBouquet = vendor.sellTheBouquet();		
		
		System.out.print("\nEnter the flower name you wish to find: ");			
		if(vendor.findAFlower(SingletonScanner.getInstance().next())) {
			System.out.println("This flower is present in the bouquet");
		}
		else {
			System.out.println("This flower is not present in the bouquet");
		}				
	}
	
	private void startMenu(){
		System.out.println("\t\t\t===Welcome to our Flower Shop===");
		
		for (int i = 1; i <= availablePlants.size(); i++) {
			System.out.print("\nPress " + i + " to choose: " + availablePlants.get(i).getName() + " \t Price: " +
					String.format("%.2f", availablePlants.get(i).getPrice()) + "₴" );
			
			if(availablePlants.get(i) instanceof Flower) {
				System.out.print("\t  Stem length: " + ((Flower) availablePlants.get(i)).getStemLength() + 
						"\tHours: " + ((Flower) availablePlants.get(i)).getHoursFromCutting());
			}
			
			if(availablePlants.get(i) instanceof Cactus) {
				System.out.print(" \t  " + ((Cactus) availablePlants.get(i)).getShape());
				
			}
		}
		
		System.out.println("\nPress 0 to confirm your choice\n");		
	}
}
