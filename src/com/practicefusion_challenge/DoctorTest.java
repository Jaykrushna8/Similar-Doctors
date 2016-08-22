package com.practicefusion_challenge;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import junit.framework.Assert;

public class DoctorTest {

	SimilarDoctors doctors;
	Connection connect = null;
	Statement stmt;
	@Before
	public void createObjectSimilarDoctors(){
		doctors = new SimilarDoctors();
	}
	
	@Before
	public void setUp(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Doctors","root","root");
		    stmt = connect.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void databaseTest(){
		try{
			ResultSet rs = stmt.executeQuery("SELECT * FROM Doctor_Information WHERE Id = 1");
			while(rs.next()){
				System.out.println(rs.getInt("Id"));
				System.out.println(rs.getString("Firstname"));
				System.out.println(rs.getString("Lastname"));
				System.out.println(rs.getString("Specialty"));
				System.out.println(rs.getString("City"));
				System.out.println(rs.getFloat("Reviewscore"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() throws Exception{
		if(connect != null){
			connect.close();
		}
	}
	
	@Test
	public void checkDoctorId() {
		JSONArray array = doctors.addDoctorFromJSON();
		int DoctId = doctors.getSelectedDoctor(11);
		Assert.assertTrue(array.size() > DoctId);
	}
    
	@Test
	public void DoctIdWrong(){
		JSONArray array = doctors.addDoctorFromJSON();
		int DoctId = doctors.getSelectedDoctor(80);
		Assert.assertTrue(array.size() > DoctId);
	}
	
	
}
