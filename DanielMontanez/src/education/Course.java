package education;

public class Course {
	// Class Variable Declarations
	// ==============================================
	private int _id;
	public String school_id;
	public String course_title;

	// Initializers
	// =============================================================
	public Course() {
	}

	public Course(int _id, String school_id, String course_title) {
		this._id = _id;
		this.school_id = school_id;
		this.course_title = course_title;
	}

	// Getters
	// ==================================================================
	public int getId() {
		return this._id;
	}
	
	public String getSchoolId() {
		return this.school_id;
	}
	
	public String getTitle() {
		return this.course_title;
	}
	
	// Setters
	// ==================================================================
	public void setId(int _id) {
		this._id = _id;
	}
	
	public void setSchoolId(String school_id) {
		this.school_id = school_id;
	}
	
	public void setTitle(String course_title) {
		this.course_title = course_title;
	}
}
