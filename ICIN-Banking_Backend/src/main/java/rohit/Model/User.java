package rohit.Model;

import jakarta.persistence.Column;

//import jakarta.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.*;
@Entity
@Table(name="user")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String uname;
	private String uemail;
//	@Column(unique = true)
	@Column(name = "phone", nullable = false, length = 20)
	private int uphone;
	private String upassword;
	  
	public User()
	{
		
	}
	
	public User(int uid, String uname, String uemail, int uphone, String upassword) 
	{
		super();
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.uphone = uphone;
		this.upassword = upassword;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUemail() {
		return uemail;
	}


	public void setUemail(String uemail) {
		this.uemail = uemail;
	}


	public int getUphone() {
		return uphone;
	}


	public void setUphone(int uphone) {
		this.uphone = uphone;
	}


	public String getUpassword() {
		return upassword;
	}


	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	
	
	
	
}
