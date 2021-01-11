/*******************************************************************************
- Full name: Asad Choudhry, Osama Hameed, Deliar Mohammadi, Oscar Campos 
- Class: CPSC and Class Number 233
- Assignment: AOOD PROJECT!!!
- Due: Tuesday, July 30, 2019 (Second Demo)
- Professor: Nathaly Verwaal
- Source code name: Game.Java
********************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {

	private HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();

	private ArrayList<Node> platforms = new ArrayList<Node>();
	static ArrayList<Node> coins = new ArrayList<Node>();
	private ArrayList<Node> enemies = new ArrayList<Node>();

	public static Pane appRoot = new Pane();
	public static Pane gameRoot = new Pane();
	public static Pane uiRoot = new Pane();

	Player p = new Player();
	Enemy e = new Enemy();
	Key k = new Key();
	private Point2D playerVelocity = new Point2D(0, 0);
	private boolean canJump = true;
	Label cornerMenu = new Label();

	private int levelWidth;

	private boolean running = true;

	private void initContent() {
		int height = 1280;
		int width = 720;
		Rectangle bg = new Rectangle(height, width);
		bg.setFill(Color.CADETBLUE);
		// Label health = new Label();
		cornerMenu.setText(p.toString());
		cornerMenu.setTextFill(Color.BLACK);
		VBox corner = new VBox();
		corner.getChildren().add(cornerMenu);
		

		levelWidth = LevelData.LEVEL1[0].length() * 60;

		for (int i = 0; i < LevelData.LEVEL1.length; i++) {
			String line = LevelData.LEVEL1[i];
			for (int j = 0; j < line.length(); j++) {
				switch (line.charAt(j)) {
				case '0':
					break;
				case '1':
					Node platform = createEntity(j * 60, i * 60, 60, 60, Color.ALICEBLUE);
					platforms.add(platform);
					break;
				case '2':
					for (int k = 0; k < 50; k++) {
						Coin c = new Coin();
						c.createEntity(j * 60, i * 60, 20, Color.GOLD);
						coins.add(c.getCoin());
					}
					break;
				}
			}
		}
		
		
		for (int i = 1; i <20; i++) {
		Random rand = new Random();
		int randomX = rand.nextInt(8);
		int randomY = rand.nextInt(2) + 1;
		e.createEntity(randomX*300,randomY * 300, 40, 40, Color.CRIMSON);
		enemies.add(e.getEnemy());
		}

		p.createEntity(0, 600, 40, 40, Color.DARKBLUE);
		k.createEntity(1500, 600, 10, Color.MAGENTA);
		
		


		p.getPlayer().translateXProperty().addListener((obs, old, newValue) -> {
			int offset = newValue.intValue();

			if (offset > 640 && offset < levelWidth - 640) {
				gameRoot.setLayoutX(-(offset - 640));
			}
		});

		uiRoot.getChildren().add(corner);

		appRoot.getChildren().addAll(bg, gameRoot, uiRoot);
	}

	private void update() {
		cornerMenu.setText(p.toString());
		if (isPressed(KeyCode.W) && p.getPlayer().getTranslateY() >= 5) {
			jumpPlayer();
		}

		if (isPressed(KeyCode.A) && p.getPlayer().getTranslateX() >= 5) {
			movePlayerX(-5);
		}

		if (isPressed(KeyCode.D) && p.getPlayer().getTranslateX() + 40 <= levelWidth - 5) {
			movePlayerX(5);
		}

		if (playerVelocity.getY() < 10) {
			playerVelocity = playerVelocity.add(0, 1);
			
			
		}


			moveEnemyX(600); 
		

		movePlayerY((int) playerVelocity.getY());

		for (Node coin : coins) {
			if (p.getPlayer().getBoundsInParent().intersects(coin.getBoundsInParent())) {
				coin.getProperties().put("alive", false);
			}
		}

		for (Iterator<Node> it = coins.iterator(); it.hasNext();) {
			Node coin = it.next();
			if (!(Boolean) coin.getProperties().get("alive")) {
				it.remove();
				gameRoot.getChildren().remove(coin);
				p.addCoin();
				cornerMenu.setText(p.toString());
			}
		}

		for (Node enemy : enemies) {
			if (p.getPlayer().getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				enemy.getProperties().put("alive", false);
				System.out.println("TEST");
				if (p.getHP() > 0) {
					p.loseHP();
					cornerMenu.setText(p.toString());
				} else {
					running = false;

				}
			}
		}

		for (Iterator<Node> it = enemies.iterator(); it.hasNext();) {
			Node enemy = it.next();
			if (!(Boolean) enemy.getProperties().get("alive")) {

				// it.remove();
				//gameRoot.getChildren().remove(enemy);
			}
			break;
		}
		
		
		if(checkKey()) {
			if(p.getPlayer().getBoundsInParent().intersects(k.getKey().getBoundsInParent())) {
				running = false;
			}
			
		}
		
	}
	
	
	public boolean checkKey() {
		return coins.size()<=0;
		
	}

	private void movePlayerX(int value) {
		boolean movingRight = value > 0;

		for (int i = 0; i < Math.abs(value); i++) {
			for (Node platform : platforms) {
				if (p.getPlayer().getBoundsInParent().intersects(platform.getBoundsInParent())) {
					if (movingRight) {
						if (p.getPlayer().getTranslateX() + 40 == platform.getTranslateX()) {
							return;
						}
					} else {
						if (p.getPlayer().getTranslateX() == platform.getTranslateX() + 60) {
							return;
						}
					}
				}
			}
			p.getPlayer().setTranslateX(p.getPlayer().getTranslateX() + (movingRight ? 1 : -1));
		}
	}

	private void moveEnemyX(int value) {
		e.getEnemy().setTranslateX(e.getEnemy().getLayoutX() + value);
	}

	private void movePlayerY(int value) {
		boolean movingDown = value > 0;

		for (int i = 0; i < Math.abs(value); i++) {
			for (Node platform : platforms) {
				if (p.getPlayer().getBoundsInParent().intersects(platform.getBoundsInParent())) {
					if (movingDown) {
						if (p.getPlayer().getTranslateY() + 40 == platform.getTranslateY()) {
							p.getPlayer().setTranslateY(p.getPlayer().getTranslateY() - 1);
							canJump = true;
							return;
						}
					} else {
						if (p.getPlayer().getTranslateY() == platform.getTranslateY() + 60) {
							return;
						}
					}
				}
			}
			p.getPlayer().setTranslateY(p.getPlayer().getTranslateY() + (movingDown ? 1 : -1));
		}
	}

	private void jumpPlayer() {
		if (canJump) {
			playerVelocity = playerVelocity.add(0, -30);
			canJump = false;
		}
	}

	private Node createEntity(int x, int y, int w, int h, Color color) {
		Rectangle entity = new Rectangle(w, h);
		entity.setTranslateX(x);
		entity.setTranslateY(y);
		entity.setFill(color);
		entity.getProperties().put("alive", true);

		gameRoot.getChildren().add(entity);
		return entity;
	}

	private boolean isPressed(KeyCode key) {
		return keys.getOrDefault(key, false);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initContent();

		Scene scene = new Scene(appRoot);
		scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
		scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
		primaryStage.setTitle("Dr.Octavious");
		primaryStage.setScene(scene);
		primaryStage.setMaximized(false);
		primaryStage.show();

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (running) {
					update();
				}
				Button end = new Button("Game Over");
				HBox go = new HBox(end);
				go.setAlignment(Pos.CENTER);
				Scene gameOver = new Scene(go);
				Button win = new Button("You Win!");
				HBox ws = new HBox(win);
				ws.setAlignment(Pos.CENTER);
				Scene winScene = new Scene(ws);
				if (!running) {
					if(checkKey()) {
					primaryStage.setScene(winScene);
						
					}else {
					primaryStage.setScene(gameOver);
					}
				}
			}
		};
		timer.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
