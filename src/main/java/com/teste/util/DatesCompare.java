package com.teste.util;

import java.util.Date;

public class DatesCompare {

	
	public Long differDates(Date d1, Date d2){
		Long dt =(d2.getTime() - d1.getTime() + 3600000);
		return dt/86400000L;
	}
}
