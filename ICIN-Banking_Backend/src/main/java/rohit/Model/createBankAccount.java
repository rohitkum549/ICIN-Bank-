package rohit.Model;

//import javax.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class createBankAccount 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String branch;
	private String name;
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;
	@Column(unique = true)
	private String email;
	private String banktype;
	private String dateofbirth;
//	@Column(unique = true)
	private String pancard;
	private String aadhar;
//	@Column(unique = true)
	private String address;
	private String photo;
	private String nomineename;
	private String nomineephone;
	private String nomineeaadhar;
	
	public createBankAccount()
	{
		
	}
	

	



	

	public createBankAccount(int id, String branch, String name, String phone, String email, String banktype,
			String dateofbirth, String pancard, String aadhar, String address, String photo, String nomineename,
			String nomineephone, String nomineeaadhar) {
		super();
		this.id = id;
		this.branch = branch;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.banktype = banktype;
		this.dateofbirth = dateofbirth;
		this.pancard = pancard;
		this.aadhar = aadhar;
		this.address = address;
		this.photo = photo;
		this.nomineename = nomineename;
		this.nomineephone = nomineephone;
		this.nomineeaadhar = nomineeaadhar;
	}








	public String getBranch() {
		return branch;
	}







	public void setBranch(String branch) {
		this.branch = branch;
	}







	public String getBanktype() {
		return banktype;
	}







	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNomineename() {
		return nomineename;
	}

	public void setNomineename(String nomineename) {
		this.nomineename = nomineename;
	}

	public String getNomineephone() {
		return nomineephone;
	}

	public void setNomineephone(String nomineephone) {
		this.nomineephone = nomineephone;
	}

	public String getNomineeaadhar() {
		return nomineeaadhar;
	}

	public void setNomineeaadhar(String nomineeaadhar) {
		this.nomineeaadhar = nomineeaadhar;
	}
	
}
