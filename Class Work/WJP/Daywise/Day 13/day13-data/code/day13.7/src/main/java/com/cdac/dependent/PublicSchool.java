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
	@Autowired //byType
	@Qualifier("maths") //byName
	private Teacher subjectTeacher;
	// depcy - Coach
	@Autowired
	@Qualifier("football")
	private Coach sportsCoach;

	public PublicSchool() {
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher + " " + sportsCoach);
	
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
//		Arrays.stream(sportsCoaches) //Stream<Coach>
//		.forEach(Coach::getDailyWorkout);//c -> c.getDailyWorkout()
		System.out.println(sportsCoach.getDailyWorkout());
	}

	// init method
	@PostConstruct //init-method
	public void myInit() {
		System.out.println("in init - " + subjectTeacher + " " + sportsCoach);
	}

	// destroy method
	@PreDestroy //destroy-method
	public void myDestroy() {
		System.out.println("in destroy");
	}
	

}
