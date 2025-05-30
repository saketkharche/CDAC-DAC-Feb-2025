package com.cdac.dependent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cdac.dependency.Coach;
import com.cdac.dependency.FootballCoach;
import com.cdac.dependency.Teacher;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//dependent - PublicSchool
//singleton n eager , id="public_school" , maths teacher , football coach
@Component("public_school")
public class PublicSchool implements School {

	// dependency - Teacher
	@Autowired // byType - field level D.I
	private Teacher[] subjectTeachers;
	// depcy - Coach
	@Autowired // byType - field level D.I
	private Coach[] sportsCoaches;

	public PublicSchool() {
		System.out.println("In constructor - " + getClass() + " " + subjectTeachers + " " + sportsCoaches);

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
		for (Coach c : sportsCoaches)
			System.out.println(c.getDailyWorkout());
	}

	// init method
	@PostConstruct // init-method
	public void myInit() {
		System.out.println("in init - " + subjectTeachers + " " + sportsCoaches);
	}

	// destroy method
	@PreDestroy // destroy-method
	public void myDestroy() {
		System.out.println("in destroy");
	}

}
