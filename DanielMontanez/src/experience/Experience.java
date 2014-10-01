package experience;

public class Experience {
	// Class Variable Declarations
	// ==============================================
	private int _id;
	public String experience_title;
	public String experience_position;
	public String experience_date;
	public String experience_summary;

	// Initializers
	// =============================================================
	public Experience() {
	}

	public Experience(int _id, String experience_title, String experience_position, String experience_date, String experience_summary) {
		this._id = _id;
		this.experience_title = experience_title;
		this.experience_position = experience_position;
		this.experience_date = experience_date;
		this.experience_summary = experience_summary;
	}

	// Getters
	// ==================================================================
	public int getId() {
		return this._id;
	}
	
	public String getTitle() {
		return this.experience_title;
	}
	
	public String getPosition() {
		return this.experience_position;
	}
	
	public String getDate() {
		return this.experience_date;
	}

	public String getSummary() {
		return this.experience_summary;
	}
	
	// Setters
	// ==================================================================
	public void setId(int _id) {
		this._id = _id;
	}
	
	public void setTitle(String experience_title) {
		this.experience_title = experience_title;
	}
	
	public void setPosition(String experience_position) {
		this.experience_position = experience_position;
	}
	
	public void setDate(String experience_date) {
		this.experience_date = experience_date;
	}
	
	public void setSummary(String experience_summary) {
		this.experience_summary = experience_summary;
	}

}
