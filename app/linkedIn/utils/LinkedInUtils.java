package linkedIn.utils;

import java.sql.Date;
import java.util.Calendar;

public class LinkedInUtils {
	
	public static Date createCurrentDate(){
		Calendar calendar = Calendar.getInstance();
	    Date currentDate = new Date((calendar.getTime()).getTime());
	    
	    return currentDate;
	}

}
