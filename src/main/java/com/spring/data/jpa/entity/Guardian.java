package com.spring.data.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
	@AttributeOverride(
			name = "name",
			column=@Column(name="guardian_name")
	),
	@AttributeOverride(
			name = "email",
			column=@Column(name="guardian_email")
	),@AttributeOverride(
			name = "mobileNumber",
			column=@Column(name="guardian_mobile")
	)
})
public class Guardian {
	
	private String name;
	private String email;
	private String mobileNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Guardian [name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}
