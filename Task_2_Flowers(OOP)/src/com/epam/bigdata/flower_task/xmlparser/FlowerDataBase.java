package com.epam.bigdata.flower_task.xmlparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import com.epam.bigdata.flower_task.plants.*;

public class FlowerDataBase {

	private static Element plants;
	
	public static void loadData(String path) {
		try {
			File inputFile = new File(path);
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(inputFile);
			plants = document.getRootElement();	
		}
		
		catch(JDOMException | IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static List<Flower> flowerParsing() {
		List<Element> flowerList = plants.getChild("flowers").getChildren();
		List<Flower> flowersInTheWarehouse = new ArrayList<>();
		
		for(Element flower : flowerList){
			Flower f = new Flower();
			f.setName(flower.getChild("name").getText());
			f.setPrice(Double.parseDouble(flower.getChild("price").getText()));
			f.setStemLength(Double.parseDouble(flower.getChild("stemLength").getText()));
			f.setHoursFromCutting(Double.parseDouble(flower.getChild("hoursFromCutting").getText()));
			flowersInTheWarehouse.add(f);
		}	
		return flowersInTheWarehouse;
	}
	
	public static List<Cactus> cactusParsing() {		
		List<Element> cactusList = plants.getChild("cactuses").getChildren();
		List<Cactus> cactusesInTheWarehouse = new ArrayList<>();
		
		for(Element cactus : cactusList) {
			Cactus c = new Cactus();
			c.setName(cactus.getChild("name").getText());
			c.setPrice(Double.parseDouble(cactus.getChild("price").getText()));
			c.setShape(cactus.getChild("shape").getText());	
			cactusesInTheWarehouse.add(c);
		}
		return cactusesInTheWarehouse;
	}	
}
