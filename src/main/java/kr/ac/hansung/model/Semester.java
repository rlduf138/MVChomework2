package kr.ac.hansung.model;

public class Semester {
	private int year;
	private int semester;
	private int credit;
	
	
	
	public Semester(int year, int semester, int credit) {
		this.year = year;
		this.semester = semester;
		this.credit = credit;
	}
	public Semester() {
		// TODO Auto-generated constructor stub
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return year + "," + semester + "," + credit + "#";
	}
	
	
	
}
