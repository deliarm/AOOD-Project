/*******************************************************************************
- Full name: Asad Choudhry, Osama Hameed, Deliar Mohammadi, Oscar Campos 
- Class: CPSC and Class Number 233
- Assignment: AOOD PROJECT!!!
- Due: Tuesday, July 30, 2019 (Second Demo)
- Professor: Nathaly Verwaal
- Source code name: Key.Java
********************************************************************************/

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**********************************************************************
Function name: public Node createEntity
Parameter list: int x, int y, int w, Color color
Return: entity
Purpose: This class has the outline for the key. values for the variables
	are generated in the main class. key will spawn once all the coins 
	are collected by the player.
************************************************************************/

public class Key {
	
	Node entity;
	
	   public Node createEntity(int x, int y, int w, Color color) {
	        Circle aEntity = new Circle(w);
	        aEntity.setTranslateX(x);
	        aEntity.setTranslateY(y);
	        aEntity.setFill(color);
	        aEntity.getProperties().put("alive", true);
	        entity = aEntity;
	        Game.gameRoot.getChildren().add(entity);
	        return entity;
	    }
	   
	   public Node getKey() {
		   return entity;
	   }
	   
	   

}
