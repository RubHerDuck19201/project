package com.VerschwendNix.BackEnd;


import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.event.*;
import javafx.scene.control.TextField;

public class Window extends Application {                               //hab ich alles nur zum testen benutzt, kannst übern haufen schmeißen(ganze klasse)
	
	TextField searchField;
	Scene searchScene;
	GridPane searchGrid;
	static Rezept recipe;
	public static void main(String[] args) throws Exception{
		
		recipe = new Rezept();
		System.out.println(recipe.listSearchedRecipeNames("Semmel")); 
		recipe.printArray();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		searchField = new TextField();
		searchGrid = new GridPane();
		
		GridPane.setConstraints(searchField, 0, 0);
		
		searchGrid.getChildren().addAll(searchField);
		
		searchScene = new Scene(searchGrid, 600, 600);
		primaryStage.setScene(searchScene);
		primaryStage.show();
		
	
		
	}

}
