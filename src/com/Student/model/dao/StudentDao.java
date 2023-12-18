package com.Student.model.dao;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studentMng.Student;
import com.studentMng.Cp.Cp;

public class StudentDao {

	public static boolean insert(Student st) {
		boolean f = false;
		try {
			Connection con = Cp.create();

			String q = "insert into student(sname,sphone,scity) values(?,?,?)";

			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, st.getSname());
			pst.setString(2, st.getSphone());
			pst.setString(3, st.getScity());

			pst.executeUpdate();
			f = true;
		} catch (Exception e) {
		}
		return f; 
	}

	public static boolean delete(int userId) {
		boolean f = false;
		try {
			Connection con = Cp.create();
			String q = "delete from student where sid = ?";

			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1,userId);

			pst.executeUpdate();
			f = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;	
	}

	public static void fetchAll() {
		boolean f = false;
		try {
			Connection con = Cp.create();
			String q = "Select * from student";
			PreparedStatement pst = con.prepareStatement(q);


			ResultSet set = pst.executeQuery(q);
			while(set.next()) {
				int id = set.getInt(1); 
				String name = set.getString(2); 
				String phone = set.getString(3); 
				String city = set.getString(4);
				System.out.println("Id :"+ id );
				System.out.println("Name :"+ name );
				System.out.println("Phone :"+ phone );
				System.out.println("City :"+ city );
				System.out.println("------------------------------------------");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static boolean update(int userId,BufferedReader br) {
		boolean u = false;
		try {
			Connection con = Cp.create();
			PreparedStatement updn = con.prepareStatement("Select * from student where sid ="+userId);
			ResultSet exQ = updn.executeQuery();
			if(exQ.next()) {
				System.out.println("Enter Your Name");
				String sname = br.readLine();

				System.out.println("Enter Your Phone Number");				
				String sphone = br.readLine();

				System.out.println("Enter Your City");				
				String scity = br.readLine();
				String q = "UPDATE student SET sname = ?, sphone = ?, scity = ? WHERE sid = ?";
				PreparedStatement pst = con.prepareStatement(q);
				pst.setString(1, sname); 
				pst.setString(2, sphone);
				pst.setString(3, scity); 
				pst.setInt(4, userId); 

				pst.executeUpdate();
				u = true;	
			}else {
				System.out.println("Please Enter Proper Id ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

}


