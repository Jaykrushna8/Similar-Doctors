package com.practicefusion_challenge;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/* @author Jaykrushna Patel */

public class SimilarDoctors {
	
	static JSONArray array;     // store doctor's information from Json file
	static String specialty;    // Selected Doctor's specialty
	static String city;         // Selected Doctor's City
	static float reviewscore;   // Selected Doctor's Review Score
	int DoctId;                 // Selected Doctor's Id
	String Firstname;           // Selected Doctor's First Name
	String Lastname;            // Selected Doctor's Last Name
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimilarDoctors doctors = new SimilarDoctors();
		array = doctors.addDoctorFromJSON();
		System.out.println("Doctor Data Successfully Store in the database");
		System.out.println("Please enter Doctor's ID(Enter number between 1 to 70)::");
		int id;
        /* enter doctor's id */
		Scanner scanner = new Scanner(System.in);
			id = scanner.nextInt();
		while(id < 1 || id > array.size() ){
			//System.out.println("Loop is working");
			System.out.println("Wrong Doctor's Id !!! Enter number again between 1 to " + array.size() + "::");
				id = scanner.nextInt();
		}
		scanner.close();
		System.out.println("Selected Doctor ::");
		doctors.getSelectedDoctor(id);     // Get selected doctor from database
		System.out.println();
		System.out.println("Get all Doctors with Same Specialty & City");
		doctors.similarSpecCityDoctors();   // Get all doctors with same specialty and city
		System.out.println();
		System.out.println();
		System.out.println("Get all Doctors with Same Specialty & city but worst reviews");
		doctors.similarSpecCityWorstDoctors();    // Get all doctors with same specialty & city but worst reviews
		System.out.println();
		System.out.println();
		System.out.println("Get all Doctors with Same Specialty but not same city");
		doctors.similarSpecialtyDoctors();       // Get all doctors with same specialty but not same city
		
	}
	
	/* Function to Store Doctor's information in the database by reading a JSON file */
	public JSONArray addDoctorFromJSON(){
		JSONParser parser = new JSONParser();
		JSONArray array = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");  // load mysql driver 
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Doctors","root","root");  // create database connection
			Object obj = parser.parse(new FileReader("./src/DoctorData.json"));     // Parser json file
		    array = (JSONArray) obj;
			String sql = null;
			Statement stmt = connect.createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS Doctor_Information");
			/* Create Doctor Information table */
			stmt.executeUpdate("CREATE TABLE Doctor_Information (Id INT, Firstname VARCHAR(30), Lastname VARCHAR(30), Specialty VARCHAR(40), City VARCHAR(30), Reviewscore DOUBLE (10,2))");
			/* store data into database */
			for(int i=0; i<array.size(); i++){
				JSONObject jsonObject = (JSONObject) array.get(i);	
				sql = "INSERT INTO Doctor_Information(Id,Firstname,Lastname,Specialty,City,Reviewscore) values ('" + 
				jsonObject.get("Id") + "','" + jsonObject.get("firstname") + "','" + jsonObject.get("lastname") + "','" + jsonObject.get("specialty") + "','" + jsonObject.get("city") + "','" + jsonObject.get("reviewscore") + "')";
				stmt.executeUpdate(sql);
			}
			connect.close();  // connection close
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return array;
	}
	
	/* Get Selected Doctor from the Database */
	public Integer getSelectedDoctor(int Id){
		try{
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Doctors","root","root");
			Statement stmt = connect.createStatement();
			String sql = "SELECT * FROM Doctor_Information WHERE Id = '" + Id + "'";   // select query for get doctor's information for particular id
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.format("%4s %12s %12s %14s %14s %22s \n","Doctor's Id","First Name", "Last Name","Specialty","City","Review Score");
			System.out.println("------------------------------------------------------------------------------------------");
			
			while(rs.next()){
			    DoctId = rs.getInt("Id");
				specialty = rs.getString("Specialty");
				city = rs.getString("City");
				reviewscore = rs.getFloat("Reviewscore");
				Firstname = rs.getString("Firstname");
				Lastname = rs.getString("Lastname");
			}	
			System.out.format("%4d %15s %14s %16s %17s %12.1f \n",DoctId,Firstname,Lastname,specialty,city,reviewscore);
			connect.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return DoctId;
	}
	
	/* Function to get all doctors with same specialty & city */
	public void similarSpecCityDoctors(){
		try{
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Doctors","root","root");
			Statement stmt = connect.createStatement();
			/* get all doctors information with same specialty and city */
			String sql = "SELECT * FROM Doctor_Information WHERE Specialty = '" + specialty + "' AND City = '" + city + "' ORDER BY Reviewscore DESC";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.format("%4s %12s %12s %14s %14s %22s \n","Doctor's Id","First Name", "Last Name","Specialty","City","Review Score");
			System.out.println("------------------------------------------------------------------------------------------");
			if(rs != null && rs.next()){
				do{
					System.out.format("%4d %15s %14s %16s %17s %12.1f \n",rs.getInt("Id"),rs.getString("Firstname"),rs.getString("Lastname"),rs.getString("Specialty"),rs.getString("City"),rs.getFloat("Reviewscore"));
				}
			while(rs.next());
			}
			else{
				System.out.println("Not available");
			}
			connect.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/* Function to get all doctors with same specialty but not same city*/
	public void similarSpecialtyDoctors(){
		try{
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Doctors","root","root");
			Statement stmt = connect.createStatement();
			/* get all doctors information with same specialty but not same city */
			String sql = "SELECT * FROM Doctor_Information WHERE Specialty = '" + specialty + "' AND City != '" + city + "'ORDER BY Reviewscore DESC";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.format("%4s %12s %12s %14s %14s %22s \n","Doctor's Id","First Name", "Last Name","Specialty","City","Review Score");
			System.out.println("------------------------------------------------------------------------------------------");
			if(rs != null && rs.next()){
				do{
				   System.out.format("%4d %15s %14s %16s %17s %12.1f \n",rs.getInt("Id"),rs.getString("Firstname"),rs.getString("Lastname"),rs.getString("Specialty"),rs.getString("City"),rs.getFloat("Reviewscore"));
			    }
				while(rs.next());
			}
			else{
				System.out.println("Not available");
			}
			connect.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/* Function to get all doctors with same specialty & city but worst reviews */
	public void similarSpecCityWorstDoctors(){
		try{
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Doctors","root","root");
			Statement stmt = connect.createStatement();
			/* get all doctors information with same specialty and city but worst reviews */
			String sql = "SELECT * FROM Doctor_Information WHERE Specialty = '" + specialty + "' AND City = '" + city + "' AND Reviewscore < " + reviewscore + " ORDER BY Reviewscore DESC";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.format("%4s %12s %12s %14s %14s %22s \n","Doctor's Id","First Name", "Last Name","Specialty","City","Review Score");
			System.out.println("------------------------------------------------------------------------------------------");
			if(rs != null && rs.next()){
				do{
					System.out.format("%4d %15s %14s %16s %17s %12.1f \n",rs.getInt("Id"),rs.getString("Firstname"),rs.getString("Lastname"),rs.getString("Specialty"),rs.getString("City"),rs.getFloat("Reviewscore"));
				}
			    while(rs.next());
			}
			else
			{
				System.out.println("Not available");
			}
			connect.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
