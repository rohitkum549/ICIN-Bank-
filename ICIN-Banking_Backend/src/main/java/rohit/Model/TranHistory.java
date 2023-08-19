package rohit.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tranhistory")
public class TranHistory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String uemail;
	private String fromcc;
	private String status;
	private String toacc;
	private int amount;
	private String remarks;
	
	
	public TranHistory()
	{
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUemail() {
		return uemail;
	}


	public void setUemail(String uemail) {
		this.uemail = uemail;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getToacc() {
		return toacc;
	}


	public void setToacc(String toacc) {
		this.toacc = toacc;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getFromcc() {
		return fromcc;
	}


	public void setFromcc(String fromcc) {
		this.fromcc = fromcc;
	}
	
	
	
	
}
