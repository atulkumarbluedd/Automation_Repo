package JavaHandsOn;

import java.util.ArrayList;
import java.util.List;

public class updatedSwitch {

	public static void main(String[] args) {

		boolean ans=isWeekDayV1_1(Day.MON);
		System.out.println(ans);
		 boolean ans1=isWeekDayV1_1(Day.SAT);
		System.out.println(ans1);

	}
	enum Day {
		MON, TUE, WED, THUR, FRI, SAT, SUN
	};

	public static Boolean isWeekDayV1_1 (Day day)
	{
		Boolean result = switch(day) {
			case MON, TUE, WED, THUR, FRI -> true;
			case SAT, SUN -> false;
		};
		return result;
	}

}