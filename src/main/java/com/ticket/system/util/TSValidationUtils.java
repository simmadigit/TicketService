/**
 * 
 */
package com.ticket.system.util;

import java.util.regex.Pattern;


/**
 * @author simmadi
 *
 */
public class TSValidationUtils {

	final static Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);	


	/**
	 * 
	 */
	public TSValidationUtils() {
		// TODO Auto-generated constructor stub
	}

	/** To validate the email ID 
	 * @param String email ID
	 * @return boolean value
	 */
	
	public boolean isValidEmailID(String emailId){
		boolean emailFlag = true;
		
		if ("".equals(emailId) == false && VALID_EMAIL_ADDRESS_REGEX.matcher(emailId).matches() == false) {
			emailFlag = false;
			System.out.println("Invalid Email-Id !!! ");
		}
		
		return emailFlag;

	}
	
	/** To validate the choice YES/NO or yes / no
	 * @param String Opt choice
	 * @return boolean value
	 */
	
	public boolean isValidOptChoice(String optChoice){
		
		boolean optFlag = true;

		if (TSConstants.TS_CUSTMOER_YES_OPT.equalsIgnoreCase(optChoice) || TSConstants.TS_CUSTMOER_NO_OPT.equalsIgnoreCase((optChoice)))
		{
			optFlag = true;
		
		} 
		else
		{
			optFlag = false;
			System.out.println("Invalid Choice !!! ");
		}
		
		return optFlag;
	}
	
	/** To validate the choice YES/NO or yes / no
	 * @param String Opt choice
	 * @return boolean value
	 */
	
	public boolean isValidStagLevel(Integer levelId){
		
		boolean iscorrectOption = true;
		
		if(levelId.intValue() < 1 || levelId.intValue() > 4 )
		{
			System.out.println("Invalid Option! Please re-enter. ");
			iscorrectOption=false;
		}
		
		return iscorrectOption;
	}
}
