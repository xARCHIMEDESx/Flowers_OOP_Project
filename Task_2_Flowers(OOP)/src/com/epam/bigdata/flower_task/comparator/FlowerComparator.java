package com.epam.bigdata.flower_task.comparator;

import java.util.Comparator;
import java.util.List;

import com.epam.bigdata.flower_task.flowershop.Bouquet;
import com.epam.bigdata.flower_task.plants.*;

public class FlowerComparator {

	public static Bouquet compareByStemLength(Bouquet b) {
		b.getBouquet().sort(new Comparator<Plant>(){
			@Override
			public int compare(Plant p1, Plant p2) {
				if (p1 instanceof Flower && p2 instanceof Flower) {
					if (((Flower) p1).getStemLength() == ((Flower) p2).getStemLength()) return 0;
	                else if (((Flower) p1).getStemLength() < ((Flower) p2).getStemLength()) return 1;
	                else return -1;
				}
				else return 1;
			}
		});
		
		return b;		
	}
	
	public static Bouquet compareByHoursFromCutting(Bouquet b) {
		b.getBouquet().sort(new Comparator<Plant>(){
			@Override
			public int compare(Plant p1, Plant p2) {
				if (p1 instanceof Flower && p2 instanceof Flower) {
					if (((Flower) p1).getHoursFromCutting() == ((Flower) p2).getHoursFromCutting()) return 0;
	                else if (((Flower) p1).getHoursFromCutting() > ((Flower) p2).getHoursFromCutting()) return 1;
	                else return -1;
				}
				else return 1;
			}
		});
		return b;		
	}
	
	
	public static List<? extends Plant> compareByName(List<? extends Plant> list) {
		list.sort(new Comparator<Plant>(){
			@Override
			public int compare(Plant p1, Plant p2) {
				if (p1.getName().equals(p2.getName())) return 0;
                else return 1;
			}
		});
		return list;		
	}
	
}

