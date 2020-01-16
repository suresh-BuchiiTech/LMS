package com.inventrix.lms;

public class Library {
	private String libraryName;
	
	private String libraryLocation;
	
	private String isActiveStatus;
	
	private Integer studentMaxBooks=0;
	
	private Integer staffMaxBooks=0;
	
	private Integer maxBooksDays=0;

	public Integer getMaxBooksDays() {
		return maxBooksDays;
	}

	public void setMaxBooksDays(Integer maxBooksDays) {
		this.maxBooksDays = maxBooksDays;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryLocation() {
		return libraryLocation;
	}

	public void setLibraryLocation(String libraryLocation) {
		this.libraryLocation = libraryLocation;
	}

	public String getIsActiveStatus() {
		return isActiveStatus;
	}

	public void setActiveStatus(String isActiveStatus) {
		this.isActiveStatus = isActiveStatus;
	}

	public int getStudentMaxBooks() {
		return studentMaxBooks;
	}

	public void setStudentMaxBooks(int studentMaxBooks) {
		this.studentMaxBooks = studentMaxBooks;
	}

	public int getStaffMaxBooks() {
		return staffMaxBooks;
	}

	public void setStaffMaxBooks(int staffMaxBooks) {
		this.staffMaxBooks = staffMaxBooks;
	}
	
}
