package com.cdac.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Address extends BaseEntity {
	@Column(name="adr_line1",length=100)
	private String adrLine1;
	@Column(name="adr_line2",length=100)
	private String adrLine2;
	@Column(length=20)
	private String city;
	@Column(length=20)
	private String state;
	@Column(length=20)
	private String country;
	@Column(length=20,name="zip_code")
	private String zipCode;
	@Column(length=14,unique = true)
	private String phone;		
}
