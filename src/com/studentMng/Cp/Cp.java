package com.studentMng.Cp;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cp {
	static Connection con;
	public static Connection create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root", "9326");
		} catch (Exception e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


}
