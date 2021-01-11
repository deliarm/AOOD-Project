import static org.junit.Assert.*;

import org.junit.Test;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public class Playertest extends Player {

	//Testing the getPlayer method in our Player class.
	@Test
	public void test_getPlayer() {
		Player health =new Player();
		Object expected = null;
		Node actual = health.getPlayer();
		assertEquals("Testing the method called getPlayer to see if we receive null since nothing has been initialized yet", expected, actual);
	}
	
	//Testing the loseHP method in our Player class.
	//Testing if we lose one HP.
	@Test
	public void test_loseHP_99() {
		long expected = 149;
		Player health =new Player();
		health.getHP();
		health.loseHP();
		int actual = health.getHP();
		assertEquals("losing 1HP from 150", expected, actual);
	}

	//Testing the loseHP method in our Player class.
	//Testing if we lose two HP.
	@Test
	public void test_loseHP_98() {
		long expected = 148;
		Player health =new Player();
		health.getHP();
		health.loseHP();
		health.loseHP();
		int actual = health.getHP();
		assertEquals("losing 2HP from 150", expected, actual);
	}
	
	//Testing the getHP method in our Player class.
	@Test
	public void test_getHP_150() {
		long expected = 150;
		Player health =new Player();
		int actual = health.getHP();
		assertEquals("getting player health ", expected, actual);
	}

	//Testing the getCoins method in our Player class.
	//ATM we did not ADD any coins so we should get 0 coins back.
	@Test
	public void test_getCoins_0() {
		long expected = 0;
		Player health =new Player();
		int actual = health.getCoins();
		assertEquals("Getting coin counter ", expected, actual);
	}
	
	//Testing the addCoins method in our Player class.
	//Checking if the coin gets added to our counter and returning it using our getCoin method
	@Test
	public void test_addCoins_1() {
		long expected = 1;
		Player health =new Player();
		for(int i=0;i<=50;i++) {
			health.addCoin();
		}
		int actual = health.getCoins();
		assertEquals("Adding one coin ", expected, actual);
	}
	
	//Testing the addCoins method in our Player class.
	//Checking if two coins gets added to our counter and returning it using our getCoin method
	@Test
	public void test_addCoins_2() {
		long expected = 2;
		Player health =new Player();
		for(int i=0;i<=100;i++) {
			health.addCoin();
		}
		int actual = health.getCoins();
		assertEquals("Adding two coin ", expected, actual);
	}
	
	//Testing the addCoins method in our Player class.
	//Checking if five coins gets added to our counter and returning it using our getCoin method
	@Test
	public void test_addCoins_5() {
		long expected = 5;
		Player health =new Player();
		for(int i=0;i<=250;i++) {
			health.addCoin();
		}
		int actual = health.getCoins();
		assertEquals("Adding five coin ", expected, actual);
	}
	
	//Testing the toString method in our Player class.
	//Checking if the toString works as we want it to work.
	@Test
	public void test_toString() {
		String expected = "HP: " + "150" + "\n" + 
						  "Coins: " + "0" + "\n" +
						  "Coins remaining: " + "0";
		Player health =new Player();
		
		String actual = "HP: " + health.getHP() + "\n" + 
						"Coins: " + health.getCoins() + "\n" +
						"Coins remaining: " + Game.coins.size()/50;
		
		assertEquals("Check if the toString works ", expected, actual);
	}
}
