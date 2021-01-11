/*******************************************************************************
- Full name: Asad Choudhry, Osama Hameed, Deliar Mohammadi, Oscar Campos 
- Class: CPSC and Class Number 233
- Assignment: AOOD PROJECT!!!
- Due: Tuesday, July 30, 2019 (Second Demo)
- Professor: Nathaly Verwaal
- Source code name: Enemy.Java
********************************************************************************/

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**********************************************************************
Function name: public Node createEntity
Parameter list: int x, int y, int w, int h, Color color
Return: entity
Purpose: this function has the outline for the enemy, values for the
	variables are generated in the main. 
************************************************************************/

public class Enemy {
	
	Node entity;
	
	
	 public Node createEntity(int x, int y, int w, int h, Color color) {
	        Rectangle aEntity = new Rectangle(w,h);
	        aEntity.setTranslateX(x);
	        aEntity.setTranslateY(y);
	        aEntity.setFill(color);
	        aEntity.getProperties().put("alive", true);
	        entity = aEntity;
	        Game.gameRoot.getChildren().add(entity);
	        return entity;
	    }
	   
	   public Node getEnemy() {
		   return entity;
	   }
	   
	   


}
