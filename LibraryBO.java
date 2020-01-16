package com.inventrix.lms;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class LibraryBO {
	public static void addLibrary(){
		Library library = new Library();
		try
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the Name of library");
			String libraryName=scanner.nextLine(); 
			library.setLibraryName(libraryName);
			System.out.println("Enter the location of library: ");
			String libraryLocation=scanner.nextLine();
			library.setLibraryLocation(libraryLocation);
			System.out.println("library is working or not (true or false): ");
			String isActiveStatus =scanner.nextLine();
			library.setActiveStatus(isActiveStatus);
			System.out.println("Maximum books issued for Students: ");
			int studentMaxBooks=scanner.nextInt();
			library.setStudentMaxBooks(studentMaxBooks);
			System.out.println("Maximum books issued for Staff: ");
			int staffMaxBooks=scanner.nextInt();
			library.setStaffMaxBooks(staffMaxBooks);
			System.out.println("Maximum no of Days for book submission: ");
			int maxBooksDays=scanner.nextInt();
			library.setMaxBooksDays(maxBooksDays);
			scanner.nextLine();
			System.out.println("Data is Taken would like to save it? press (y or n):");
			String saveInput=scanner.nextLine();
			if(saveInput.equalsIgnoreCase("y")||saveInput.equalsIgnoreCase("yes")) 
			{	
				boolean isStored=storeLibraryData(library);
				if(isStored) 
				{
					System.out.println("details of the library is stored in LibraryDetails");
				}
				else 
				{
					System.out.println("Something Went Wrong details are not stored..");
				}
			}
			System.out.println("if you want to add another library? press (y or n): ");
			String addInput=scanner.nextLine();
			
			if(addInput.equalsIgnoreCase("y")||addInput.equalsIgnoreCase("yes")) {
				System.out.println("Enter the details of another Library: \n");
				addLibrary();			
			}
			else
			{
				System.out.println("Main Menu:");
				LibraryController libraryController=new LibraryController();
				libraryController.start();
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void showLibrary() {
		try
		{
				LibraryController libraryController=new LibraryController();
				Scanner scanner=new Scanner(System.in);
				System.out.println("If You Want To Display all the library Details?(yes or no)");
				String validation=scanner.nextLine();
				if(validation.equalsIgnoreCase("yes")||validation.equalsIgnoreCase("y"))
				{
					showAllLibraryData();
					try {
						libraryController.start();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				else if(validation.equalsIgnoreCase("no")||validation.equalsIgnoreCase("n")){
					System.out.println("Enter the name of Library to Display the Details: ");
					String libraryName=scanner.nextLine();
					showLibraryData(libraryName);
					try {
						libraryController.start();
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Please enter any valid input: try again!");
					showLibrary();
				}
		}
		catch(Exception ioe) {
			ioe.printStackTrace();
		}
	}


	public static boolean storeLibraryData(Library library)
	{
	    boolean successStatus=false;
	    BufferedWriter writer;
	    String str="";
        StringBuilder fileContents = new StringBuilder(str);
		try 
		{
			String fileName="/home/developer/Desktop/LMS/LibraryDetails.txt";
			
			
			File file = new File(fileName); 
			  
			FileReader br = new FileReader(file);
			int i;
			while (( i = br.read()) != -1) 
			{
				 fileContents.append((char)i);
			}
			  
		    if(file.length()>0)
		    {
		    	fileContents.append("\n");
		    }
		   
			String fileContent = "Name: "+library.getLibraryName()+", libraryLocation: "+library.getLibraryLocation()+", isActiveStatus: "+library.getIsActiveStatus()+", studentMaxBooks: "+library.getStudentMaxBooks()+", staffMaxBooks: "+library.getStaffMaxBooks()+", maxBooksDays: "+library.getMaxBooksDays();
		    String totalContent=(fileContents.append(fileContent)).toString();
		    writer = new BufferedWriter(new FileWriter(fileName));
		    writer.write(totalContent);
		    successStatus=true;
		    writer.close();
		}
		catch (IOException e)
		{
			successStatus=false;
			e.printStackTrace();
		}
		return successStatus;
	}

	
	public static void showAllLibraryData() {
		String str="";
        StringBuilder fileContents = new StringBuilder(str);
		try {
			String fileName="/home/developer/Desktop/LMS/LibraryDetails.txt";
			
			
			File file = new File(fileName); 
			  
			  FileReader br = new FileReader(file);
			  int i;
			  while (( i = br.read()) != -1) 
			  {
				 fileContents.append((char)i);
				 
			  }
			  System.out.println("All Library Details are: \n"+fileContents.toString() );
		}
		catch(IOException e) {
			
		}

	}
	
	public static void showLibraryData(String libraryName) {
		String str="";
        StringBuilder fileContents = new StringBuilder(str);
		try {
			String fileName="/home/developer/Desktop/LMS/LibraryDetails.txt";
			
			File file = new File(fileName); 
			  
			FileReader br = new FileReader(file);
			int i;
			while (( i = br.read()) != -1) 
			{
				fileContents.append((char)i);
				 
			}
			String totalContent=fileContents.toString();
			String arr[]= {",",":"};
			String[] libraryArray = totalContent.split("\n");
			for(int j=0;j<libraryArray.length;j++) {
				 String string=libraryArray[j].trim();
				 
				 if(string.length() > 0) 
				 {
					 String fileLibraryName=getLibraryFileName(string,arr);
					 if(fileLibraryName.equalsIgnoreCase(libraryName))
					 {
						 String resultArray[]=string.split(",");
						 for(int k=0;k<resultArray.length;k++) 
						 {
							 System.out.println(resultArray[k]);
						 }
						 break;
					 }
				 }
				
				 
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}


	private static String getLibraryFileName(String string, String[] arr) 
	{
		String result="";
		List<String> charArrayList=new ArrayList<>();
		try 
		{
			if(arr!=null) {
				charArrayList=Arrays.asList(arr);
			}
			List<String> splitList=new ArrayList<>();
				splitList.add(string);
		
			int count=0;
			for(String s1 : charArrayList)
			{
				if(splitList.size()>0) 
				{
					Iterator<String> strIterator=splitList.iterator();
					
					while (strIterator.hasNext())
					{
						String var=strIterator.next().split(s1)[count];
						splitList=new ArrayList<>();
						splitList.add(var);
						
					}
					count++;
				}
				
			}
			if(splitList.size()>0) 
			{
				result=splitList.get(0).trim();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
