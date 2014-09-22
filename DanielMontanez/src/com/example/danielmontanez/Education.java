package com.example.danielmontanez;

public class Education {
	// Class Variable Declarations
	// ==============================================
	private int _id;
	public String education_university;
	public String education_degree;
	public String education_major;
	public String education_minor;
	public String education_date;

	// Initializers
	// =============================================================
	public Education() {
	}

	public Education(int _id, String education_university,
			String education_degree, String education_major,
			String education_minor, String education_date) {
		this._id = _id;
		this.education_university = education_university;
		this.education_degree = education_degree;
		this.education_major = education_major;
		this.education_minor = education_minor;
		this.education_date = education_date;
	}

	// Getters
	// ==================================================================
	public int getId() {
		return this._id;
	}
	
	public String getUniversity() {
		return this.education_university;
	}
	
	public String getDegree() {
		return this.education_degree;
	}
	
	public String getMajor() {
		return this.education_major;
	}
	
	public String getMinor() {
		return this.education_minor;
	}
	
	public String getDate() {
		return this.education_date;
	}

	// Setters
	// ==================================================================
	public void setId(int _id) {
		this._id = _id;
	}
	
	public void setUniversity(String education_university) {
		this.education_university = education_university;
	}
	
	public void setDegree(String education_degree) {
		this.education_degree = education_degree;
	}
	
	public void setMajor(String education_major) {
		this.education_major = education_major;
	}
	
	public void setMinor(String education_minor) {
		this.education_minor = education_minor;
	}
	
	public void setDate(String education_date) {
		this.education_date = education_date;
	}

}
