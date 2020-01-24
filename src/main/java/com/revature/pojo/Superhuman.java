package com.revature.pojo;

public class Superhuman {
	
	private String superhumanName;
	
	private String powers;
	
	private String weakness;
	
	private String alignment;


	public String getSuperhumanName() {
		return superhumanName;
	}

	public void setSuperhumanName(String superhumanName) {
		this.superhumanName = superhumanName;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	@Override
	public String toString() {
		return "Superhuman [superhumanName=" + superhumanName + ", powers=" + powers + ", weakness=" + weakness
				+ ", alignment=" + alignment + "]";
	}

	public Superhuman(String superhumanName, String powers, String weakness, String alignment) {
		super();
		this.superhumanName = superhumanName;
		this.powers = powers;
		this.weakness = weakness;
		this.alignment = alignment;
	}
	
	public Superhuman() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
