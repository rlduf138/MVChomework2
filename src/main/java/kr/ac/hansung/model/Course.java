package kr.ac.hansung.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Course {
	
	private int year;			//년도
	private int semester;		//학기
	
	@Size(min=2,max=100,message="Name must be between 2 and 100 chars")
	@NotEmpty(message = "The Code cannot be empty")
	private String code;		//수강코드
	
	@Size(min=2,max=100,message="Name must be between 2 and 100 chars")
	@NotEmpty(message = "The Name cannot be empty")
	private String name;		//과목이름
	
	@Size(min=2,max=100,message="Name must be between 2 and 100 chars")
	@NotEmpty(message = "The division cannot be empty")
	private String division;	//구분
	
	
	
	private int credit;			//학점
	
	
	
	public Course(){}
	public Course(int year, int semester, String code, String name, String division, int credit) {
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.division = division;
		this.credit = credit;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return year+","+semester+","+code+","+name+","+division+","+credit+"#";
	}
	
	
	
}
