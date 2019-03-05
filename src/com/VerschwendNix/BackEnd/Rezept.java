package com.VerschwendNix.BackEnd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rezept {
	public String name;
	public String zutat1;
	public String[] zutaten;
	Connection con;
	Statement stmnt;
	ResultSet rs;
	
	public Rezept() {
		try {
		zutaten = new String[20];
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schnauzeVoll", "luki", "hallo");
		stmnt = con.createStatement();
		rs = stmnt.executeQuery("Select * FROM vokab");
	}catch(SQLException e) {
		System.err.println(e.getSQLState());
		e.printStackTrace();
		}
	}
	
	/*public String zutatLineUp() {
		for(i=0; i<zutaten.length ; i++) { Datenbank holen-> Connection aufbauen ->SQL abfragen
			zutaten[i]=
		}
	}*/
	
	
}