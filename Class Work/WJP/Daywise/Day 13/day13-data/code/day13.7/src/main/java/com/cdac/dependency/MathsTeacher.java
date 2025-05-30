package com.cdac.dependency;

import org.springframework.stereotype.Component;

//singleton n eager , id=maths
@Component("maths")
public class MathsTeacher implements Teacher {
	public MathsTeacher() {
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void teach() {
		System.out.println("Know your tables well !");
	}

}
