package org.springframework.samples.petclinic;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic?useSSL=false", "root",
					"root");
			if (connection != null)
				System.out.println("Conexión establecida");

			statement = connection.createStatement();
		/*	
		String sql = "SELECT * FROM owners;";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				//print a header 
				System.out.println("-------------------------");
				//obtener campos
				int id= rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String telephone = rs.getString("telephone");
				//print the results
				System.out.print("Id: " + id);
				System.out.print(" First Name: "+first_name);
				System.out.print(" Last Name: "+last_name);
				System.out.print(" Address: "+address);
				System.out.print(" City: "+city);
				System.out.print(" Telephone: "+telephone);
				System.out.println();
			}
			
			sql = "INSERT INTO owners(id,first_name,last_name,address,city,telephone) values(11,'Alberto','Huertas','Ordonez','Leagnes','606970396')";
			statement.close();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			*/
		
		
		/*
			String sql = "SELECT * FROM owners WHERE id=11;";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					//print a header 
					System.out.println("-------------------------");
					//obtener campos
					int id= rs.getInt("id");
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String address = rs.getString("address");
					String city = rs.getString("city");
					String telephone = rs.getString("telephone");
					//print the results
					System.out.print("Id: " + id);
					System.out.print(" First Name: "+first_name);
					System.out.print(" Last Name: "+last_name);
					System.out.print(" Address: "+address);
					System.out.print(" City: "+city);
					System.out.print(" Telephone: "+telephone);
					System.out.println();
				}
				
				
				sql = "UPDATE OWNERS SET city='Sevilla' WHERE ID=11";
				statement.executeUpdate(sql);
				
				sql = "SELECT * FROM owners WHERE id=11;";
				rs = statement.executeQuery(sql);
				while(rs.next()) {
					//print a header 
					System.out.println("-------------------------");
					//obtener campos
					int id= rs.getInt("id");
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String address = rs.getString("address");
					String city = rs.getString("city");
					String telephone = rs.getString("telephone");
					//print the results
					System.out.print("Id: " + id);
					System.out.print(" First Name: "+first_name);
					System.out.print(" Last Name: "+last_name);
					System.out.print(" Address: "+address);
					System.out.print(" City: "+city);
					System.out.print(" Telephone: "+telephone);
					System.out.println();
				}*/
		/*		
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM OWNERS WHERE first_name=? OR last_name=?;";
		String name = "Alberto";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, name);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			// print a header
			System.out.println("-------------------------");
			// obtener campos
			int id = rs.getInt("id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String telephone = rs.getString("telephone");
			// print the results
			System.out.print("Id: " + id);
			System.out.print(" First Name: " + first_name);
			System.out.print(" Last Name: " + last_name);
			System.out.print(" Address: " + address);
			System.out.print(" City: " + city);
			System.out.print(" Telephone: " + telephone);
			System.out.println();
		}*/

		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO OWNERS VALUES(12,?,?,?,?,?);";
		String first_name = "Alberto";
		String last_name = "Huertas";
		String address = "Ordonez";
		String city = "Leganes";
		String telephone = "606970396";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, first_name);
		preparedStatement.setString(2, last_name);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, city);
		preparedStatement.setString(5, telephone);
		preparedStatement.executeUpdate();
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	} finally {
		try {
			if (statement != null)
				statement.close();

		} catch (SQLException se) {

		}
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}

}
