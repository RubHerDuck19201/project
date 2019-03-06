package com.VerschwendNix.BackEnd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;


public class Rezept {

	public String[] zutaten;
	public String[] searchedRecipeNames;
	Connection con;
	Statement stmnt;
	ResultSet rs;
	public int rsCountValue;
	
	public Rezept() {
		sqlCon();
		countRecipeRows();
	}
	
	public String[] zutatAndNameLineUp(int cursor){
		if(cursor > 0) {
		zutaten = new String[11];
		try {
		for(int i=0; i<zutaten.length ; i++) { 
			rs.absolute(cursor);
			zutaten[i]=rs.getString(i+1);
		}
		
		}catch(SQLException e) {
			String err="Error occured";
			e.printStackTrace();
			System.out.println(err);
			
			}
		}
		return zutaten;
		}
	

	
	
	public void sqlCon() {
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schnauzeVoll", "root", "");
			stmnt = con.createStatement();
			rs = stmnt.executeQuery("Select * FROM Rezepte");
			
			
		}catch(SQLException e) {
			System.out.println("sqlConErr");
			e.printStackTrace();
			}
	}
	
	public int countRecipeRows() {
		try {
			
			while(rs.next()) {
				rsCountValue++;
			}
			return rsCountValue;
			
		}catch(SQLException e) {
			System.err.println("countRecipeRowsErr");
			e.printStackTrace();
			return -1;
			}
	}
	
	public String[] listSearchedRecipeNames(String searchedString) {
		if(searchedString != null) {
			int counter = 0;
			
			searchedRecipeNames = new String[rsCountValue];
			
			try {
				for(int i=1; i<=rsCountValue; i++) {
					rs.absolute(i);
					
					if((Pattern.compile(Pattern.quote(searchedString), Pattern.CASE_INSENSITIVE).matcher(rs.getString(2)).find())==true) {
						searchedRecipeNames[counter]=rs.getString(2);
						
						counter++;
						
						
					}
				
				}
			}catch(SQLException e) {
				System.out.println("listSearchedRecipeNamesErr");
				e.printStackTrace();
			}
		}
		return searchedRecipeNames;
	}
	
	
	
	
	
	
	
	
	

	
	public void addRecipe(String[] singleRecipe) {
		for(int i=0; i<singleRecipe.length; i++) {
			if(singleRecipe[i]!=null && testForLetters(singleRecipe[i])==true) {
				
			}
		}
	}
	
	public boolean testForLetters(String proofYourSelf) {
		char[] charArray = proofYourSelf.toCharArray();
			for(char c : charArray ) {
				if(Character.isLetter(c)==false) {
					return false;
				}
			}
		return true;
	}
	
	
	
	public void printArray() {								// printArray() beide methoden nur für testzwecke
		for(int i=0;i < searchedRecipeNames.length;i++) {
			System.out.println(searchedRecipeNames[i]);
		}
	}
	public void printArrays() {
		
		
		for(int i=0; i<zutaten.length; i++) {
			if(zutaten[i]!=null) {
				System.out.println(zutaten[i]);
			}
		}	
	}
	
}
	
	
