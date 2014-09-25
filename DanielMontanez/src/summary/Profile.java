/*
 * Resume Application
 * September 2014
 * Daniel J. Montanez
 */

package summary;

public class Profile {
	// Class Variable Declarations
	// ==============================================
	private int _id;
	private String first_name;
	private String middle_initial;
	private String last_name;
	private String phone;
	private String email;
	private String address_1;
	private String address_2;
	private String city;
	private String state;
	private String zip;
	private String summary;

	// Initializers ============================================================
	public Profile() {
	}

	public Profile(int _id, String first_name, String middle_initial,
			String last_name, String phone, String email, String address_1,
			String address_2, String city, String state, String zip,
			String summary) {
		this._id = _id;
		this.first_name = first_name;
		this.middle_initial = middle_initial;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.summary = summary;
	}

	// Getters
	// ===================================================================
	public int getId() {
		return this._id;
	}

	public String getFName() {
		return this.first_name;
	}

	public String getMInit() {
		return this.middle_initial;
	}

	public String getLName() {
		return this.last_name;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getEmail() {
		return this.email;
	}

	public String getAddr1() {
		return this.address_1;
	}

	public String getAddr2() {
		return this.address_2;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public String getZip() {
		return this.zip;
	}

	public String getSummary() {
		return this.summary;
	}

	// Setters
	// ======================================================================
	public void setId(int _id) {
		this._id = _id;
	}

	public void setFName(String first_name) {
		this.first_name = first_name;
	}

	public void setMInit(String middle_initial) {
		this.middle_initial = middle_initial;
	}

	public void setLName(String last_name) {
		this.last_name = last_name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddr1(String address_1) {
		this.address_1 = address_1;
	}

	public void setAddr2(String address_2) {
		this.address_2 = address_2;

	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
