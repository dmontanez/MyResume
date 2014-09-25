package interest;

public class Interest {
	// Class Variable Declarations
	// ==============================================
	private int _id;
	public String interest_title;
	public String interest_description;
	public String interest_date;

	// Initializers
	// =============================================================
	public Interest() {
	}

	public Interest(int _id, String interest_title,
			String interest_description, String interest_date) {
		this._id = _id;
		this.interest_title = interest_title;
		this.interest_description = interest_description;
		this.interest_date = interest_date;
	}

	// Getters
	// ==================================================================
	public int getId() {
		return this._id;
	}
	
	public String getTitle() {
		return this.interest_title;
	}
	
	public String getDescription() {
		return this.interest_description;
	}
	
	public String getDate() {
		return this.interest_date;
	}
	
	// Setters
	// ==================================================================
	public void setId(int _id) {
		this._id = _id;
	}
	
	public void setTitle(String interest_title) {
		this.interest_title = interest_title;
	}
	
	public void setDescription(String interest_description) {
		this.interest_description = interest_description;
	}
	
	public void setDate(String interest_date) {
		this.interest_date = interest_date;
	}

}
