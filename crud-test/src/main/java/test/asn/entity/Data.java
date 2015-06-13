package test.asn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	public Data() {

	}

	public Data(Integer id) {
		this.Id = id;
	}

	public Data(Integer id, String userName, String email, String phoneNumber) {
		this.Id = id;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Data [" + (Id != null ? "Id=" + Id + ", " : "")
				+ (userName != null ? "userName=" + userName + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (phoneNumber != null ? "phoneNumber=" + phoneNumber : "")
				+ "]";
	}

}
