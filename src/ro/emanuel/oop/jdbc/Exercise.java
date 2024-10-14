package ro.emanuel.oop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Exercise {
	public static void main(String[] args) throws SQLException{
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tema1",connectionProps);
		Statement stmt=conn.createStatement();
		
		//Tabela IPhones
		//Create
		String model="13ProMax";
		String processor="A15";
		int year=2021;
		String sqlInsert="INSERT INTO IPhones (model, processor, year)\n"
				+ "VALUES (?, ?, ?);";
		PreparedStatement ps = conn.prepareStatement(sqlInsert);
		ps.setString(1, model);
		ps.setString(2, processor);
		ps.setInt(3, year);
		ps.executeUpdate();

		
		//Update
		String model1="16Plus";
		String processor1="A17";
		int year1=2024;
		String sqlUpdate="UPDATE IPhones \n"
				+ "SET model=?, processor=?, year=? \n"
				+ "WHERE id=2;";
		PreparedStatement ps1 = conn.prepareStatement(sqlUpdate);
		ps1.setString(1, model1);
		ps1.setString(2,processor1);
		ps1.setInt(3, year1);
		ps1.executeUpdate();
		
		//Delete
		String model2="16Plus";
		String sqlDelete="DELETE FROM IPhones\n"
				+ "WHERE model=?;";
		PreparedStatement ps3 = conn.prepareStatement(sqlDelete);
		ps3.setString(1, model2);
		ps3.executeUpdate();
		//Read
				ResultSet rs = stmt.executeQuery("select * from IPhones");
				while(rs.next())
				{
					int id=rs.getInt("id");
					String iphoneModel=rs.getString("model");
					String iphoneProcessor=rs.getString("processor");
					String manufacturingYear=rs.getString("year");
					System.out.println(id+" "+iphoneModel+" "+iphoneProcessor+" "+manufacturingYear);
				}
		
		System.out.println("///////Tabela 2//////////");
		//Tabela Mackbooks
				//Create
				String modelMackbook="Air";
				String processorMackbook="M2";
				int sizeInInches=13;
				String sqlInsertMackbooks="INSERT INTO Mackbooks (model, processor, sizeInInches)\n"
						+ "VALUES (?, ?, ?);";
				PreparedStatement psMackbooks = conn.prepareStatement(sqlInsertMackbooks);
				psMackbooks.setString(1, modelMackbook);
				psMackbooks.setString(2, processorMackbook);
				psMackbooks.setInt(3, sizeInInches);
				psMackbooks.executeUpdate();
				
				//Update
				String model4="Pro";
				String processor4="M4";
				int sizeInInches4=16;
				String sqlUpdate4="UPDATE Mackbooks \n"
						+ "SET model=?, processor=?, sizeInInches=? \n"
						+ "WHERE id=2;";
				PreparedStatement ps4 = conn.prepareStatement(sqlUpdate4);
				ps4.setString(1, model4);
				ps4.setString(2,processor4);
				ps4.setInt(3, sizeInInches4);
				ps4.executeUpdate();
				
				//Delete
				String model5="Pro";
				String sqlDelete5="DELETE FROM Mackbooks\n"
						+ "WHERE model=?;";
				PreparedStatement ps5 = conn.prepareStatement(sqlDelete5);
				ps5.setString(1, model5);
				ps5.executeUpdate();
				//Read
				ResultSet rsMackbooks = stmt.executeQuery("select * from Mackbooks");
				while(rsMackbooks.next())
				{
					int id=rsMackbooks.getInt("id");
					String mackbookModel=rsMackbooks.getString("model");
					String ProcessorIPhone=rsMackbooks.getString("processor");
					int size=rsMackbooks.getInt("sizeInInches");
					System.out.println(id+" "+mackbookModel+" "+ProcessorIPhone+" "+size);
				}
		conn.close();

		
	}
}
