package com.cdac.dependency;

import org.springframework.stereotype.Component;

//singleton n eager - spring bean(spring managed component)
@Component("cricket") //stereotype annotation - 
//<bean id="cricket" class="F.Q cls name"/>
//to tell SC - to manage life cycle + D.I
public class CricketCoach implements Coach {

    public CricketCoach() {
    	System.out.println("In constructor - " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
