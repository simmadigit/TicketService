/**
 * 
 */
package com.ticket.system.util;

import java.util.Optional;

/**
 * @author simmadi
 *
 */
public class TSConstants {
	
	// ERROR Messages
	 public static final String TS_GET_CUSTMOER_INPUT_NULL_ERR_MSG="Customer Input Object is Null";  
	 public static final String TS_CUSTMOER_RES_FAIL_MSG="Reservation is Failed";
	 
	 // SUCCESS Messages
	 public static final String TS_CUSTMOER_RES_SUCCESS_MSG="Reservation is Success";
	 
	// Application Specific Constants
	 public static final int TS_ORCHESTRA_LEVEL_UPPER_LIMIT=1250; 
	 public static final int TS_MAIN_LEVEL_UPPER_LIMIT=2000; 
	 public static final int TS_BALCONY_1_LEVEL_UPPER_LIMIT=1500; 
	 public static final int TS_BALCONY_2_LEVEL_UPPER_LIMIT=1500; 
	 public static final int TS_VENUE_SEAT_LIMIT=6250; 
	 public static final int TS_VENUE_NOLEVEL=0;
	 public static final int TS_SEAT_HOLD_ID = 123123;
	 public static final Optional<Integer> TS_VENUE_OPTIONAL_LEVEL =  Optional.of(new Integer(TS_VENUE_NOLEVEL));
	 
	public static final String TS_CUSTMOER_YES_OPT = "YES";
	 public static final String TS_CUSTMOER_NO_OPT ="NO";
	 public static final int TS_SEAT_HOLD_ID_MAX_INTRVAL= 60000;
}
