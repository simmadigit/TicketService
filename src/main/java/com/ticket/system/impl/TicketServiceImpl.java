/**
 * 
 */
package com.ticket.system.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.ticket.system.TSGetCustmoerInput;
import com.ticket.system.beans.SeatHold;
import com.ticket.system.intf.TicketService;

/**
 * @author simmadi
 *
 */
public class TicketServiceImpl implements TicketService {

	private static Logger logger = Logger.getLogger(TicketServiceImpl.class);
	public static SeatHold holdedSeats=null;
	TSSeatsManagement tsSeatsManagement = new TSSeatsManagement();
	TSGetCustmoerInput tsGetCustmoerInput = new TSGetCustmoerInput();

	/**
	 * 
	 */
	public TicketServiceImpl() {
		// TODO Auto-generated constructor stub
		logger.info("Entered in to the TicketServiceImpl");
	}

	/**
	 * The number of seats in the requested level that are neither held nor reserved
	 * Implementation done here
	 * @param venueLevel a numeric venue level identifier to limit the search
	 * @return the number of tickets available on the provided level
	 */

	@Override
	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		Integer levelIndex;
		int availableSeats=0;

		try	{
			if(venueLevel.isPresent() && venueLevel.get().intValue()!=0)	{
				levelIndex = venueLevel.get();
				availableSeats = tsSeatsManagement.getAvailableSeats(levelIndex.intValue());
			}else if (venueLevel.get().intValue()==0){
				availableSeats = tsSeatsManagement.getAvailableSeats();
			}

		}catch( NoSuchElementException ex )	{

			logger.error("Stage Level Not found "+ex );

		}
		return availableSeats;
	}

	/**
	 * Find and hold the best available seats for a customer   implementation done here
	 *
	 * @param numSeats the number of seats to find and hold
	 * @param minLevel the minimum venue level
	 * @param maxLevel the maximum venue level
	 * @param customerEmail unique identifier for the customer
	 * @return a SeatHold object identifying the specific seats and related
	information
	 */

	@Override
	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel,
			Optional<Integer> maxLevel, String customerEmail) {

		SeatHold seatHold = new SeatHold();
		seatHold.setCustomerEmail(customerEmail);
		seatHold.setMinLevel(minLevel);
		seatHold.setMaxLevel(maxLevel);
		seatHold.setNumOfSeats(numSeats);
		try{
		holdedSeats = tsSeatsManagement.findAndHoldSeatsMgmt(seatHold);	
		}catch( NoSuchElementException ex )	{

			logger.error("Exception: "+ex );

		}
		return holdedSeats;
	}


	/**
	 * Commit seats held for a specific customer 
	 * implementation done here.	*
	 * @param seatHoldId the seat hold identifier
	 * @param customerEmail the email address of the customer to which the seat hold is assigned
	 * @return a reservation confirmation code
	 */

	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {

		String statusMsg=null;	
		int newSeatHold=0;
		int holdObjHoldId=0;
		String holdObjemailID = null;
		String newEmailID = null;

		try{
			if(holdedSeats != null){
				holdObjHoldId = holdedSeats.getSeatHoldId();
				holdObjemailID = holdedSeats.getCustomerEmail();
			}
			

			do{
				newSeatHold = tsGetCustmoerInput.checkSeatHoldId(holdObjHoldId,seatHoldId);
			}while(newSeatHold!=holdObjHoldId);

			do{
				newEmailID = tsGetCustmoerInput.checkCustomerEmailId(holdObjemailID,customerEmail );			

			}while(!newEmailID.equalsIgnoreCase(holdObjemailID));


			holdedSeats.setSeatHoldId(newSeatHold);
			statusMsg = tsSeatsManagement.makeReservation(holdedSeats,newSeatHold);	

		}catch(Exception ex){
			logger.error(" Invalid Entry:" + ex);
		}
		if(logger.isDebugEnabled()){
			logger.debug("statusMsg:"+statusMsg);
		}

		return statusMsg;
	}

}
