package com.epam.bigdata.flower_task.main;

import com.epam.bigdata.flower_task.flowershop.*;

public class WannaBuyABouquet {

	public static void main(String[] args) {
		FlowerShop flowerShop = new FlowerShop();		
		flowerShop.buy();
		flowerShop.getTotalPrice();
		flowerShop.getFlowerWithTheLongestStem();
		flowerShop.getTheFreshestFlower();		
	}
}
