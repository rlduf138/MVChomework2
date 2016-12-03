package kr.ac.hansung.model;

public class Division {
	private String division;
	private int credit;
	
	public Division() {
		super();
	}
	public Division(String division, int credit) {
		super();
		this.division = division;
		this.credit = credit;
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
		return division + "," + credit + "#";
	}
	
	
}
