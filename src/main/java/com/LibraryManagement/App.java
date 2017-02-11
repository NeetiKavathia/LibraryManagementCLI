package com.LibraryManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.BookManagementOfLibrary.User;
import com.BookManagementOfLibrary.BookManagementImpl;

public class App {
	public static void main(String[] args) throws IOException {
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		BookManagementImpl bo = (BookManagementImpl) appContext.getBean("bookBo");
		int ch = 0;

		while (ch != 6) {

			System.out.println("1- Add User");
			System.out.println("2- Delete User");
			System.out.println("3- View All User");
			System.out.println("4- Update Contact of User");
			System.out.println("5- Find User By name");
			System.out.println("6-Exit");
			System.out.println("Enter Your Choice : ");
			ch = Integer.parseInt(ob.readLine());

			if (ch == 1) {
				System.out.println("1- Add a User");
				User b = new User();
				System.out.println("Enter the User Id ");
				b.setId(Integer.parseInt(ob.readLine()));
				System.out.println("Enter the User Name ");
				b.setName(ob.readLine());
				System.out.println("Enter the User Contact Number ");
				b.setContact(Integer.parseInt(ob.readLine()));
				System.out.println("Enter the Fine on User");
				b.setFine(Integer.parseInt(ob.readLine()));

				bo.NewUser(b);
			}
			if (ch == 2) {
				User b = new User();
				System.out.println("Enter the Username : ");
				b.setId(Integer.parseInt(ob.readLine()));
				bo.DeleteUser(b);
			}
			if (ch == 3) {
				List<User> l = new ArrayList<User>();
				l = (List<User>) bo.ViewUser();

				Iterator<User> itr = l.iterator();
				while (itr.hasNext()) {
					User b = (User) itr.next();

					System.out.println(b.getId() + "\t" + b.getName() + "\t" + b.getContact() + "\t" + b.getFine());
				}
			}
			if (ch == 4) {
				User b = new User();
				System.out.println("Enter the Book Id : ");
				b.setId(Integer.parseInt(ob.readLine()));
				System.out.println("Enter the New Contact : ");
				int cat = (Integer.parseInt(ob.readLine()));
				bo.UpdateContactOfUser(b, cat);
			}
			if(ch==5){
				System.out.println("Enter the Name of the user: ");
	    		String cat=ob.readLine();
	    		User l=new User();
	    		l=(User) bo.FindByName(cat);
	    		
//	    		Iterator itr=l.iterator();  
//	    		  while(itr.hasNext()) {
//	    			  User b= (User) itr.next();
	    			  
	    		   System.out.println(l.getId()+"\t"+l.getName()+"\t"+l.getContact()+"\t"+l.getFine());  
	    		  
			}
		}

	}
}