package tester;

import com.cdac.dependency.EnglishTeacher;
import com.cdac.dependency.ScienceTeacher;
import com.cdac.dependent.PublicSchool;

public class TestPublicSchool {

	public static void main(String[] args) {
		PublicSchool publicSchool=new PublicSchool(new ScienceTeacher());
		publicSchool.manageAcademics();

	}

}
