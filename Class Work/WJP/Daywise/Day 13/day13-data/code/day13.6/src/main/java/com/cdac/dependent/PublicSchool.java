package com.cdac.dependent;

import java.util.Arrays;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

//dependent - PublicSchool
public class PublicSchool implements School {
	// dependency - Teacher
	private Teacher[] subjectTeachers;
	// depcy - Coach
	private Coach[] sportsCoaches;

	public PublicSchool(Coach[] myCoaches, Teacher[] myTeachers) {
		this.sportsCoaches = myCoaches;
		this.subjectTeachers = myTeachers;
		System.out.println("In constructor - " + getClass() + " " + subjectTeachers + " " + sportsCoaches);// not null
	}

	// core mandatory Business logic
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		// dependent (public school) is using depcy to teach
		for (Teacher t : subjectTeachers)
			t.teach();
	}

	// core optional B.L
	@Override
	public void organizeSportsEvent() {
		System.out.println("Preparing for sports event");
//		Arrays.stream(sportsCoaches) //Stream<Coach>
//		.forEach(Coach::getDailyWorkout);//c -> c.getDailyWorkout()
       for(Coach c : sportsCoaches)
    	   System.out.println(c.getDailyWorkout());

	}

	// init method
	public void myInit() {
		System.out.println("in init - " + subjectTeachers + " " + sportsCoaches);
	}

	// destroy method
	public void myDestroy() {
		System.out.println("in destroy");
	}

}
