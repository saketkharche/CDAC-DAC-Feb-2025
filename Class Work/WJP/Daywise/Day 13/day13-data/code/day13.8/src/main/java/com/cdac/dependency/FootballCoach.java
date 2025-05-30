package com.cdac.dependency;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//spring component , prototype , id="football"

@Component("football")
@Scope("prototype")
public class FootballCoach implements Coach {

    public FootballCoach() {
    	System.out.println("In constructor - " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in strength training n cardio";
    }
}
