package be.ge0ffrey.coursera.jackson.students;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(scope = Student.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {
	
	private Integer id;
	
	private String name;
	
	private School school;

	public Student() {
	}

	public Student(Integer id, String name, School school) {
		this.id = id;
		this.name = name;
		this.school = school;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
}