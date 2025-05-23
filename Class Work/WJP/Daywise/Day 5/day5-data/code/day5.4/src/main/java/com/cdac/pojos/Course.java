package com.cdac.pojos;

public enum Course {
	JAVA_OOP(70), WEB_JAVA(80), MERN(75), DBT(85), PYTHON(90);
	private int minScore;

	private Course(int minScore) {
		//super(name,ordinal)
		this.minScore = minScore;
	}
	//getter

	public int getMinScore() {
		return minScore;
	}
	
	
	
	
}
