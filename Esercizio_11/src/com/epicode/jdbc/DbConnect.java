package com.epicode.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbConnect {
	
	 private static Logger log = LoggerFactory.getLogger(DbConnect.class);
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "students";
	String user = "postgres";
	String pass = "root";
	java.sql.Statement write;
	
	
	public DbConnect() throws SQLException {
		Connection link = DriverManager.getConnection(url+dbName,user,pass);
		write = link.createStatement();
		createStudents();
		
		log.info("Connection established");
		
	}
	
	public void createStudents() throws SQLException {
		String data = "CREATE TABLE IF NOT EXISTS  school_studnts ("
				+ " id SERIAL PRIMARY KEY,"
				+ " name VARCHAR NOT NULL,"
				+ " surname VARCHAR NOT NULL,"
				+ " gender VARCHAR NOT NULL,"
				+ " birthdate DATE NOT NULL,"
				+ " avg INTEGER NOT NULL,"
				+ " min_vote INTEGER NOT NULL,"
				+ " max_vote INTEGER NOT NULL"
				+ " );";
		write.executeUpdate(data);
		log.info("Table for students created");
		
	}
	
	
	public void insertStudents(Students pupil) throws SQLException {
		String data = " INSERT INTO  school_studnts (name, surname, gender,birthdate,avg,min_vote,max_vote)"
						+"VALUES ('"+pupil.getName()+"', '"+pupil.getSurname()+"', '"+pupil.getGender()+"', '"+pupil.getBirthdate()+"', "
						+ +pupil.getAvg()+", "+pupil.getMinVote()+", "+pupil.getMaxVote()+");";
		write.executeUpdate(data);
		log.info(pupil.getName() + " " + pupil.getSurname() + " created");
	}
	
	
	public Students readStudent(int id) throws SQLException {
		String data = "SELECT * FROM school_studnts WHERE id =" +id;
		ResultSet respo = write.executeQuery(data);
		Students oneStudent = null;
		if(respo.next()) {
			int studentId = respo.getInt("id");
			String name = respo.getString("name");
			String surname = respo.getString("surname");
			String gender= respo.getString("gender");
			String birthdate = respo.getString("birthdate");
			int avg = respo.getInt("avg");
			int minVote = respo.getInt("min_vote");
			int maxVote = respo.getInt("max_vote");
			oneStudent = new Students (studentId,name, surname, gender, birthdate, avg, minVote, maxVote);
		}
		return oneStudent;
		
		
	}
	
	public void updateStudent(Students pupil) throws SQLException {
		String data = " UPDATE  school_studnts SET school_studnts "
						+ "name = '"+ pupil.getName() +"',"
						+ "surname = '" + pupil.getSurname()+ "',"
						+ "gender = '" + pupil.getGender()+ "',"
						+ "birthdate = '" + pupil.getBirthdate() + "',"
						+ "avg = " + pupil.getAvg() + ","
						+ "min_vote = " + pupil.getMinVote() + ","
						+ "max_vote = " + pupil.getMaxVote() + " " 
						+ "WHERE id  = " + pupil.getId();
		
		write.executeUpdate(data);
		
		log.info(pupil.getName() + " " + pupil.getSurname() + " modified");

	}
	
	public void deleteStudent(Students pupil) throws SQLException {
		String data = "DELETE FROM school_studnts WHERE id = " + pupil.getId();
		write.executeUpdate(data);
		log.info(pupil.getName() + " " + pupil.getSurname() + " deleted");
		
	}
	
	
	public List<Students> getBest() throws SQLException {
	    String data = "SELECT * FROM school_studnts WHERE avg = (SELECT MAX(avg) FROM school_studnts)";
	    ResultSet respo = write.executeQuery(data);
	    Students oneStudent = null;
	    List<Students> studentList = new ArrayList<Students>();
	    while (respo.next()) {
	        int studentId = respo.getInt("id");
	        String name = respo.getString("name");
	        String surname = respo.getString("surname");
	        String gender = respo.getString("gender");
	        String birthdate = respo.getString("birthdate");
	        int avg = respo.getInt("avg");
	        int minVote = respo.getInt("min_vote");
	        int maxVote = respo.getInt("max_vote");
	        oneStudent = new Students(studentId, name, surname, gender, birthdate, avg, minVote, maxVote);
	        studentList.add(oneStudent);
	    }
	    return studentList;
	}

	public List<Students> getVoteRange(int min, int max) throws SQLException {
	    String data = "SELECT * FROM school_studnts payment_date BETWEEN minVote"
	    		+ "AND maxVote;";
	    ResultSet respo = write.executeQuery(data);
	    Students oneStudent = null;
	    List<Students> studentList = new ArrayList<Students>();
	    while (respo.next()) {
	        int studentId = respo.getInt("id");
	        String name = respo.getString("name");
	        String surname = respo.getString("surname");
	        String gender = respo.getString("gender");
	        String birthdate = respo.getString("birthdate");
	        int avg = respo.getInt("avg");
	        int minVote = respo.getInt("min_vote");
	        int maxVote = respo.getInt("max_vote");
	        oneStudent = new Students(studentId, name, surname, gender, birthdate, avg, minVote, maxVote);
	        studentList.add(oneStudent);
	    }
	    return studentList;
	}

	
	

}
