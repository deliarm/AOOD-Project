/*******************************************************************************
- Full name: Asad Choudhry, Osama Hameed, Deliar Mohammadi, Oscar Campos 
- Class: CPSC and Class Number 233
- Assignment: AOOD PROJECT!!!
- Due: Tuesday, July 30, 2019 (Second Demo)
- Professor: Nathaly Verwaal
- Source code name: Player.Java
********************************************************************************/

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {
	
	int health = 150;
	int coinCount = 0;
	Node entity;

/**********************************************************************
Function name: public Node createEntity
Parameter list: int x, int y, int w, int h, Color color
Return: entity
Purpose: This method will create our character according to his location
		 on the map and what his height,width and color is.
************************************************************************/	
	
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
	
/**********************************************************************
Function name: public Node getPlayer
Parameter list: Nothing
Return: entity
Purpose: This method will return our character that we created.
************************************************************************/	
	
	   public Node getPlayer() {
		   return entity;
	   }
	
/**********************************************************************
Function name:  public void loseHP
Parameter list: Nothing
Return: VOID
Purpose: This method will decrement our health.
************************************************************************/
	
	   public void loseHP() {
		   health--;
	   }

/**********************************************************************
Function name: public int getHP
Parameter list: Nothing
Return: health
Purpose: This method will return our health.
************************************************************************/
	
	   public int getHP() {
		   return health;
	   }
	 
/**********************************************************************
Function name:  public void addCoin
Parameter list: Nothing
Return: VOID
Purpose: This method will increment our coin counter. So whenever the 
		 character collects a coin, the counter will go up.
************************************************************************/
	
	   public void addCoin() {
		   coinCount++;
	   }
	
/**********************************************************************
Function name:   public int getCoins
Parameter list: Nothing
Return: coinCounter
Purpose: This method will return our coin counter and than divide it by
		 50.
************************************************************************/
	
	   public int getCoins() {
		   return coinCount/50;
	   }
	
/**********************************************************************
Function name: public String toString
Parameter list: Nothing
Return: "HP: " + getHP() + "\n" + 
				   "Coins: " + getCoins();
Purpose: This toString will return our current health and how many coins
		 the character has collected so far.
************************************************************************/
	
	   public String toString() {
		   return "HP: " + getHP() + "\n" + 
				   "Coins: " + getCoins() + "\n" +
				   "Coins remaining: " + Game.coins.size()/50;
	   }

}
