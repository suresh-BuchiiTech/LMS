package com.inventrix.lms;

import java.io.IOException;
import java.util.Scanner;

public class LibraryController {
	public static void main(String args[]){
		System.out.println("WELCOME TO LIBRARY MANAGEMENT SYSTEM....!");
		
		try
		{
			start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	static void start(){
		try 
		{
			Scanner scanner=new Scanner(System.in);	
			System.out.println("Choose any option: \n1.Add Library \n2.Show Libraries \n3.Exit");
			int switchInput=scanner.nextInt();
			LibraryBO libraryBO=new LibraryBO();
			switch(switchInput) 
			{
				case 1:
					System.out.println("Enter the details of Library: \n");
					LibraryBO.addLibrary();
					break;
				case 2:
					libraryBO.showLibrary();
					break;
				case 3:
					System.out.println("Exited!");
					return;
			}
		}
		catch(Exception ioe) {
			ioe.printStackTrace();
		}
	}
}
