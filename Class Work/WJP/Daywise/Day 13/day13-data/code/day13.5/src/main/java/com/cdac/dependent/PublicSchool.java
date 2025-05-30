package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

//dependent - PublicSchool
public class PublicSchool implements School {
	// dependency - Teacher
	private Teacher subjectTeacher;
	// depcy - Coach
	private Coach sportsCoach;

	public PublicSchool(Coach myCoach,Teacher myTeacher) {
		this.sportsCoach=myCoach;
		this.subjectTeacher=myTeacher;
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher+" "+sportsCoach);// not null
	}

	// core mandatory Business logic
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		// dependent (public school) is using depcy to teach
		subjectTeacher.teach();
	}

	// core optional B.L
	@Override
	public void organizeSportsEvent() {
		System.out.println("Preparing for sports event");
		System.out.println(sportsCoach.getDailyWorkout());// using depcy

	}

	// init method
	public void myInit() {
		System.out.println("in init - "+subjectTeacher+" "+sportsCoach);
	}

	// destroy method
	public void myDestroy() {
		System.out.println("in destroy");
	}

}
