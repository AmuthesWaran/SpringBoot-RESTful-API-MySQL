package com.ammu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empid")
	private Long empId;
	@Column(name = "fname")
	private String fName;
	@Column(name = "lname")
	private String lName;
	private String email;
	@Column(name = "phoneno")
	private Long phoneNo;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name = "hiredate")
	private Date hireDate;
	private BigDecimal salary;
	
}
