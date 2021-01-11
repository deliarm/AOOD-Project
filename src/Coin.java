/*******************************************************************************
- Full name: Asad Choudhry, Osama Hameed, Deliar Mohammadi, Oscar Campos 
- Class: CPSC and Class Number 233
- Assignment: AOOD PROJECT!!!
- Due: Tuesday, July 30, 2019 (Second Demo)
- Professor: Nathaly Verwaal
- Source code name: Coin.Java
********************************************************************************/

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Coin {
	
	Node entity;

/**********************************************************************
Function name: public Node createEntity
Parameter list: int x, int y, int w, int h, Color color
Return: entity
Purpose: this function has the outline for the coin class. The values for
	the variables are located in the main class.
************************************************************************/	

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
	   
	   public Node getCoin() {
		   return entity;
	   }
	   
	   

}
