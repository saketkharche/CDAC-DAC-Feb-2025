package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

//dependent - PublicSchool
public class PublicSchool implements School {
	// dependency - Teacher
	private Teacher subjectTeacher;
	//depcy - Coach
	private Coach sportsCoach;

	
	private PublicSchool(Teacher myTeacher,Coach myCoach) {
		this.subjectTeacher = myTeacher;
		this.sportsCoach=myCoach;
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
	//Factory method based D.I
	public static PublicSchool myFactoryMethod(Teacher teacher1,
			Coach coach1) {
		System.out.println("in factory method "+teacher1+" "+coach1);
		//create depnt bean n wire depcies
		return new PublicSchool(teacher1, coach1);
		
	}
	
	

}
