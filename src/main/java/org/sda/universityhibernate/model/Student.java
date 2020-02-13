package org.sda.universityhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_student")
	private int id;
	
	@Column(name = "nume")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_profesor")
	private Professor tutor;

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

	public Professor getTutor() {
		return tutor;
	}

	public void setTutor(Professor tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", tutor=" + tutor + "]";
	}
}
