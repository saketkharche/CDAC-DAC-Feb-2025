package com.cdac.dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//singleton n lazy , ordinary spring comp 
//with derived id=englishTeacher
@Component
@Lazy(true)
public class EnglishTeacher implements Teacher {
	public EnglishTeacher() {
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void teach() {
		System.out.println("Practice English Grammar");
	}

}
