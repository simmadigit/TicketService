/**
 * 
 */
package com.ticket.system;

import java.util.Scanner;
import java.util.Optional;

import com.ticket.system.impl.TSSeatsManagement;
import com.ticket.system.impl.TicketServiceImpl;
import com.ticket.system.util.TSConstants;
import com.ticket.system.util.TSValidationUtils;

import org.apache.log4j.Logger;

/**
 * @author simmadi
 *
 */
public class TSGetCustmoerInput {

	private static Logger logger = Logger.getLogger(TicketServiceImpl.class);
	
	Double price;
	String levelName;
	
	Scanner choiceInput = new Scanner(System.in);
	TSValidationUtils tsValidationUtils = new TSValidationUtils();
	TSSeatsManagement tsmgmt = new TSSeatsManagement();
	/**
	 * 
	 */
	public TSGetCustmoerInput() {
		// TODO Auto-generated constructor stub
		logger.info("Entered in to the TSGetCustmoerInput");
	}
	
	/**
	* To get the Customer Seat Hold id from Customer
	*
	* @return customer seatHoldId 
	*/
	
	public int getCustomerSeatHoldId() throws Exception	
	{
		int customerSeatHoldId = 0;
		
		System.out.print("Enter your Seat Hold ID to make Reservation:");
		customerSeatHoldId = Integer.parseInt(choiceInput.nextLine());		
	
		return customerSeatHoldId;
	}
	
	
	/**
	* To validate the seats requested with available seats	* 
	* @param numOfSeatsToHold 	* 
	* @return a boolean value
	*/
	public boolean doValidateSeats(int numOfSeatsToHold) throws Exception{
		
		boolean flag = true;
		
		if(numOfSeatsToHold > TSConstants.TS_VENUE_SEAT_LIMIT){
			flag = false;
			System.out.println(numOfSeatsToHold +" Seats are not available");
			
		}
		
		return flag;
	}
	
	
	/**
	* To validate the seats requested with level wise available seats	* 
	* @param numOfSeatsToHold 	* 
	* @return a boolean value
	*/
	public boolean doValidateLevelWiseSeats(int numOfSeatsToHold, int levelWiseSeats) throws Exception{
		
		boolean flag = true;
		
		if(numOfSeatsToHold > levelWiseSeats){
			flag = false;
			System.out.println(numOfSeatsToHold +" Seats are not available in the specified Levels");
			
		}
		
		return flag;
	}

	
	/**
	* To get the number of seats to hold 
	* @param minLevel
	* @param maxLevel 
	* @return a int value
	*/
	
	public int getNumOfSeatsToHold(Optional<Integer> minLevel, Optional<Integer> maxLevel) throws Exception	
	{
		int numOfSeatsToHold = 0;
		boolean validSeats = true;
		int minLevelIndex = 0;
		int maxLevelIndex = 0;
		if(minLevel.isPresent() && maxLevel.isPresent()){
			
			minLevelIndex = minLevel.get().intValue();
			maxLevelIndex = maxLevel.get().intValue();
			
		}
				
		do{
		System.out.print("\nEnter Number Of Seats to Hold:");
		numOfSeatsToHold = Integer.parseInt(choiceInput.nextLine());	
		validSeats = doValidateSeats(numOfSeatsToHold);
		int levelWiseSeats = tsmgmt.getAvailableSeatsbyMinAndMaxLevel(minLevelIndex, maxLevelIndex);
		validSeats = doValidateLevelWiseSeats(numOfSeatsToHold,levelWiseSeats);
		
		}while(validSeats == false);
	
		return numOfSeatsToHold;
	}
	
	/**
	* To continue based on the customer Input
	* @return String with YES or NO
	*/
	
	
	public String doContinue()	throws Exception
	{
		boolean yesOrNoFlag = true;
		String optChoice = null;
		
		do{
			System.out.print("\nDo you want to continue [YES/NO]");		
			optChoice = choiceInput.nextLine();
			yesOrNoFlag = tsValidationUtils.isValidOptChoice(optChoice);
		}while (yesOrNoFlag == false);
		
		return optChoice;
	}

	/**
	* To continue based on the customer Input
	* @return String with YES or NO
	*/
	
	public String getOptionFlag() throws Exception
	{
		boolean yesOrNoFlag = true;
		String optChoice = null;
		
		do{
			System.out.print("\nDo you want the Seats Availability by Stage Level [YES/NO]");		
			optChoice = choiceInput.nextLine();
			yesOrNoFlag = tsValidationUtils.isValidOptChoice(optChoice);
		}while (yesOrNoFlag == false);
		
		return optChoice;
	}
	
	/**
	* To get the Email Id from Customer
	* @return String with YES or NO
	*/

	public String getEmailId()	throws Exception
	{
		String emailID = null;
		boolean emailFlag = true;
		
		do{
			System.out.print("\nEnter Your E-mail ID : ");
			emailID = choiceInput.nextLine();			
			emailFlag = tsValidationUtils.isValidEmailID(emailID);
		}while (emailFlag == false);
		
		return emailID;
	}

	/**
	* To get the Stage Level from Customer
	* @return the stage Level 
	*/

	public Optional<Integer> getStageLevel() throws Exception {
		Optional<Integer> optionalLevelId = null;
		Integer levelId;
		boolean iscorrectOption = true;
	
		do{
			//System.out.println("Please enter the following information to check seats availability");
			System.out.println("=========================================");
			System.out.println("|       STAGE SELECTION                 |");
			System.out.println("=========================================");        
			System.out.println("|1. Orchestra   Price($100)             |"); 
			System.out.println("|2. Main        Price($75)              |");  
			System.out.println("|3. Balcony1    Price($50)              |");
			System.out.println("|4. Balcony2    Price($40)              |");
			System.out.println("=========================================");
			
			System.out.print("Select Option[1 / 2 / 3 / 4] :");	
			
			levelId = new Integer(Integer.valueOf(choiceInput.nextLine()));		
		
			if(levelId.intValue() < 1 || levelId.intValue() > 4 )
			{
				System.out.println("Invalid Option! Please re-enter. ");
				iscorrectOption=false;
			}
			optionalLevelId = Optional.of(levelId);
			
		}while(iscorrectOption == false);

		return optionalLevelId;
	}

	/**
	* To validate the seatHoldId given by Customer
	* @return customer hold id
	*/
	
	public int checkSeatHoldId(int holdObjHoldId, int seatHoldId) throws Exception{
		
		int newSeatHold=0;
		if(holdObjHoldId != seatHoldId ){
			System.out.print("\nInvalid SeatHold Id");
			System.out.print("\nEnter the correct SeatHold Id:");			
			newSeatHold = Integer.parseInt(choiceInput.nextLine());
		}	else{
			newSeatHold = seatHoldId;
			
		}
		
		return newSeatHold;
	}
	
	/**
	* To validate the customer email-id 
	* @return customer email-id
	*/
		
	public String checkCustomerEmailId(String holdObjemailID, String customerEmail) throws Exception{
		
		String newCustEmail= null;
		
		if(!holdObjemailID.equalsIgnoreCase(customerEmail)){			
			System.out.println(" Invalid Email !!!, Please re-enter the Seat Holding time email id:");
			newCustEmail = choiceInput.nextLine();
		}else{
			newCustEmail = customerEmail;
		}		
				
		return newCustEmail;
	}
	
	
}
