package org.sda.universityhibernate.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Professor {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_profesor")
	private int id;
	
	@Column(name = "nume")
	private String name;
	
	@Column(name = "adresa")
	private String address;
	
	@Column(name = "id_departament")
	private int departmentId;
	
	@Column(name = "salariu")
	private int salary;
	
	@Column(name = "data_angajare")
	private LocalDate employmentDate;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(LocalDate employmentDate) {
		this.employmentDate = employmentDate;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", address=" + address + ", departmentId=" + departmentId
				+ ", salary=" + salary + ", employmentDate=" + employmentDate + "]";
	}

}
