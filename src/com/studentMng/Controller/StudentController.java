package com.studentMng.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.Student.model.dao.StudentDao;
import com.studentMng.Student;


public class StudentController{
	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1: to Register");
			System.out.println("Press 2: to Update");
			System.out.println("Press 3: to fetchAll");
			System.out.println("press 4: to Delete");
			System.out.println("Press 5: to Exit");
			int c = Integer.parseInt(br.readLine());

			switch (c) {
			case 1: 
				// To register User.
				System.out.println("Enter Your Name");
				String name = br.readLine();

				System.out.println("Enter Your Phone Number");				
				String phone = br.readLine();

				System.out.println("Enter Your City");				
				String city = br.readLine();

				Student st = new Student(name,phone,city);
				boolean msg =StudentDao.insert(st);
				if(msg) {
					System.out.println("Student added Successfully");
				}else {
					System.out.println("Somethind went wrong");
				}
				break;
			case 2:
				// To Update User.

				System.out.println("Enter Student Id you want to update:");
				int userId = Integer.parseInt(br.readLine());
				
				boolean u=StudentDao.update(userId,br);
				if(u) {
					System.out.println("Record with ID " + userId + " updated successfully.");
				}else {
					System.out.println("No records were updated for ID " + userId + ".");
				}
				break;
			case 3:
				// To See All User.

				StudentDao.fetchAll();
				break;
			case 4:
				// To Delete User.

				System.out.println("Enter student id to Delete: ");
				int userIdD = Integer.parseInt(br.readLine());
				boolean msgd = StudentDao.delete(userIdD);
				if(msgd) {
					System.out.println("Student Deleted Successfully");
				}else {
					System.out.println("Somethind went wrong");
				}
				break;
			case 5:
				System.out.println("Thank you....");
				System.exit(0);
			}		
		}
	}
}