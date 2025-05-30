package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

//dependent - PublicSchool
public class PublicSchool implements School {
	// dependency - Teacher
	private Teacher subjectTeacher;
	//depcy - Coach
	private Coach sportsCoach;

	//constructor based D.I (dependency injection) 
	//most recommended from Spring - it enforces mandatory dependency
	public PublicSchool(Teacher myTeacher) {
		this.subjectTeacher = myTeacher;
		System.out.println("In constructor - " 
		+ getClass()+" "+subjectTeacher);//not null
	}
	//core mandatory Business logic
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		//dependent (public school) is using depcy to teach
		subjectTeacher.teach();
	}
	//core optional B.L
	@Override
	public void organizeSportsEvent() {
		System.out.println("Preparing for sports event");
		System.out.println(sportsCoach.getDailyWorkout());//using depcy
		
	}

	// init method
	public void myInit() {
		System.out.println("in init");
	}	
	// destroy method
	public void myDestroy() {
		System.out.println("in destroy");
	}
	//setter Based D.I - optional depcies
	public void setSportsCoach(Coach myCoach)
	{
		System.out.println("in set coach");
		this.sportsCoach=myCoach;
	}
	

}
