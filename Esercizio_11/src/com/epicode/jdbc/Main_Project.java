package com.epicode.jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main_Project {

	public static void main(String[] args) throws SQLException {
		Logger log = LoggerFactory.getLogger(DbConnect.class);
		DbConnect server = new DbConnect();
		
			
			//Students first = new Students("Riky", "Morton", "male", "1/8/1999", 70, 65, 80);
	        //Students second = new Students("John", "Doe", "Male", "1/12/1995", 75, 80, 90);
	       //Students third = new Students("Emily", "Smith", "Female","12/5/2001", 82, 85, 97);
	        //Students fourth = new Students("Michael", "Johnson", "Male", "10/2/1993", 50, 60, 65);
	        
	        //server.insertStudents(first);
	        //server.insertStudents(second);
	        //server.insertStudents(third);
	        //server.insertStudents(fourth);
	        
	        
	     // Students members = server.readStudent(3);
	      //Students members2 = server.readStudent(1);
	        //log.info(" informazioni dello studente " + members);
		
	     //members1.setName("Aisha");
	     //server.updateStudent(members1);
	     
		//server.updateStudent(members);
	      
	     // server.deleteStudent(members2);
		
		List<Students> list = server.getBest();
		list.forEach(student -> log.info("Student: " + student.getName() + " " + student.getSurname()
		        + ", ID: " + student.getId() + ", Average: " + student.getAvg()));


	}

}
