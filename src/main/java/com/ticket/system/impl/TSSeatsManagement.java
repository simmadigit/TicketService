/**
 * 
 */
package com.ticket.system.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.ticket.system.beans.ReserveSeat;
import com.ticket.system.beans.SeatHold;
import com.ticket.system.util.TSApplicationUtil;
import com.ticket.system.util.TSConstants;

import org.apache.log4j.Logger;


/**
 * @author simmadi
 *
 */
public class TSSeatsManagement {

	/**
	 * 
	 */
	public TSSeatsManagement() {
		// TODO Auto-generated constructor stub
		logger.info("Entered in to the TSSeatsManagement");
	}

	private static Logger logger = Logger.getLogger(TSSeatsManagement.class);
	Map<Integer, List<Object>> straLevelTicketsMap = new HashMap<Integer, List< Object>>();
	List<Object> seatsList = new ArrayList();
	SeatHold seatHold = new SeatHold();
	ReserveSeat reserveSeatObj = new ReserveSeat();
	
	
	/** To get  available seats between the level range
	 * @param level number
	 * @return seats 
	 */
	public int getAvailableSeatsbyMinAndMaxLevel(int minLevelIndex, int maxLevelIndex){
		int availableSeats= 0;	
		int holdSeats = 0;
		int reserveSeats = 0;
		int totalSeats = 0;


		for ( int i = minLevelIndex; i <= maxLevelIndex;  i++)	{
			List<Object> value = straLevelTicketsMap.get(new Integer (i));
			// checks for null value
			if (value != null) {
				// iterates over String elements of value
				for (Object element : value) {
					// checks for null 
					if (element != null && element instanceof  SeatHold ) {
						holdSeats++;		               
					}
					if (element != null && element instanceof  ReserveSeat ) {
						reserveSeats++;		               
					}
				}
			}

			totalSeats += findTotalSeatsbyLevel(i);
		}	    

		availableSeats = totalSeats - (holdSeats + reserveSeats);

		if(availableSeats<0)
			availableSeats= 0;
		return availableSeats;
	}
	
	/** To get the available seats by level Index
	 * @param level number
	 * @return seats 
	 */

	public int getAvailableSeats(int levelIndex){
		int availableSeats= 0;	
		int holdSeats = 0;
		int reserveSeats = 0;
		int totalSeats = 0;
		
		List<Object> value = straLevelTicketsMap.get(new Integer (levelIndex));
	    // checks for null value
	    if (value != null) {
	        // iterates over String elements of value
	        for (Object element : value) {
	            // checks for null 
	            if (element != null && element instanceof  SeatHold ) {
	                holdSeats++;		               
	            }
	            if (element != null && element instanceof  ReserveSeat ) {
	            	reserveSeats++;		               
	            }
	        }
	    }
	    
	    totalSeats = findTotalSeatsbyLevel(levelIndex);	    
	
		availableSeats = totalSeats - (holdSeats + reserveSeats);
		if(availableSeats<0)
			availableSeats= 0;
		
		return availableSeats;
	}

	/** To find the total available seats	
	 * @return seats 
	 */

	public int getAvailableSeats() {
		int availableSeats=0;
		int holdSeats = 0;
		int reserveSeats = 0;
		int totalSeats = 0;
		
		for (Integer key : straLevelTicketsMap.keySet()) {
		    // gets the value
		    List<Object> value = straLevelTicketsMap.get(key);
		    // checks for null value
		    if (value != null) {
		        // iterates over list
		        for (Object element : value) {
		            // checks for null 
		            if (element != null && element instanceof  SeatHold ) {
		                holdSeats++;		               
		            }
		            if (element != null && element instanceof  ReserveSeat ) {
		            	reserveSeats++;		               
		            }
		        }
		    }
		}
				
		totalSeats = TSConstants.TS_ORCHESTRA_LEVEL_UPPER_LIMIT
				+ TSConstants.TS_MAIN_LEVEL_UPPER_LIMIT
				+ TSConstants.TS_BALCONY_1_LEVEL_UPPER_LIMIT
				+ TSConstants.TS_BALCONY_2_LEVEL_UPPER_LIMIT;
		
		availableSeats = totalSeats - (holdSeats + reserveSeats);		
		if(availableSeats<0)
			availableSeats= 0;
		
		return availableSeats;
	}
	
	/** To find the available seats by level
	 * @param level number
	 * @return seats 
	 */
	
	
	public int findTotalSeatsbyLevel(int level){
		int totalSeats = 0;
		
		 switch (level)
         {
             case 1: totalSeats = TSConstants.TS_ORCHESTRA_LEVEL_UPPER_LIMIT;
                     break;

             case 2: totalSeats = TSConstants.TS_MAIN_LEVEL_UPPER_LIMIT;
                     break;

             case 3: totalSeats = TSConstants.TS_BALCONY_1_LEVEL_UPPER_LIMIT;
                     break;

             case 4: totalSeats = TSConstants.TS_BALCONY_2_LEVEL_UPPER_LIMIT;
                     break;
             
         }		
		
		return totalSeats;
	}
	
	/** To Hold the requested seats
	 * @param SeatHold instance	 
	 * @return SeatHold instance
	 */
	
	public SeatHold findAndHoldSeatsMgmt(SeatHold seatHold) {

		int seatsHold = 0;
		int minLevelInt = 0;
		int maxLevelInt = 0;
		int numSeats = 0;

		TSApplicationUtil tsApplicationUtil = new TSApplicationUtil();

		if (seatHold != null) {

			minLevelInt = seatHold.getMinLevel().get().intValue();
			maxLevelInt = seatHold.getMaxLevel().get().intValue();
			numSeats = seatHold.getNumOfSeats();
		}

		int availableSeats = 0;

		availableSeats = getAvailableSeats();		

		if (numSeats > 2000 && availableSeats >= numSeats) {

			for (int level = minLevelInt; level <= maxLevelInt; level++) {								
					int levelSeats = getAvailableSeats(level);					
					for (int element = 0; (element < levelSeats && numSeats >0); element++) {
						straLevelTicketsMap.put(new Integer(level),
								Arrays.asList(seatHold));
						seatsHold++;
						numSeats--;						
					}
					
			}
			seatHold.setSeatsHoldedLevel(1234);	

		} else {

			for (int i = minLevelInt; i <= maxLevelInt; i++) {

				availableSeats = getAvailableSeats(i);

				if (availableSeats >= numSeats) {

					for (int seat = 0; seat < numSeats; seat++) {

						straLevelTicketsMap.put(new Integer(i),
								Arrays.asList(seatHold));
						seatsHold++;
						seatHold.setSeatsHoldedLevel(i);

					}

					break;

				} else {
					System.out
							.println("Seats Requested are not available in the requested level: "+i);
				}

			}

		}
		
		long startMillis = System.currentTimeMillis();
		
		
		
		if (seatsHold > 0){
			seatHold.setSeatHoldId(tsApplicationUtil.getSeatHoldRanNum());
			seatHold.setSeatsHoldedTimeMills(startMillis);
		}
		
		
		seatHold.setSeatsHolded(seatsHold);
		return seatHold;

	}
	
	
	/** To make the reservation
	 * @param SeatHold Object
	 * @param int seatHold ID
	 * @return boolean value
	 */
	public String makeReservation(SeatHold seatHold,int seatHoldId) {
		String statusMsg=null;
		int reserveSeats = 0;
		int levelID=0;
		int holdedSeats = 0;
		double price = 0.0;
		long durationMillis = 0;

		int maxLevelInt = 0; 
		int minLevelInt = 0;
		
		TSApplicationUtil tsApplicationUtil = new TSApplicationUtil();
		
		if(seatHold != null){
		durationMillis = System.currentTimeMillis() - seatHold.getSeatsHoldedTimeMills();
		levelID = seatHold.getSeatsHoldedLevel();		
		holdedSeats = seatHold.getSeatsHolded();
		minLevelInt = seatHold.getMinLevel().get().intValue();
		maxLevelInt = seatHold.getMaxLevel().get().intValue();
		reserveSeatObj.setCustomerEmail(seatHold.getCustomerEmail());		
		}
		
		if(durationMillis > TSConstants.TS_SEAT_HOLD_ID_MAX_INTRVAL){

			System.out.println("Your SeatHolded ID is expired, Please Hold the Tickets again, Thank you Bye");
			System.out.println("Status : "+TSConstants.TS_CUSTMOER_RES_FAIL_MSG);
			System.exit(0);
		}		
		
		reserveSeatObj.setLevelId(levelID);
		
		
		for ( int seat=0; seat < holdedSeats; seat++){
			seatsList.add(reserveSeatObj);
		}


		for ( int minLevel = minLevelInt; minLevel <= maxLevelInt ; minLevel++)	{
			List<Object> value = straLevelTicketsMap.get(new Integer (minLevel));
			// checks for null value
			if (value != null) {
				// iterates over String elements of value
				for (Object element : value) {
					// checks for null 
					if (element != null && element instanceof  SeatHold ) {
						straLevelTicketsMap.remove((new Integer(minLevel)));	
						straLevelTicketsMap.put(new Integer(minLevel),  seatsList);						
					}

				}
			}	

		}
					
		reserveSeats =holdedSeats;
		
		price = tsApplicationUtil.getTotalPrice(levelID,reserveSeats);
	    statusMsg = TSConstants.TS_CUSTMOER_RES_SUCCESS_MSG;	    
	    reserveSeatObj.setReservedSeats(reserveSeats);	    
	    
	    System.out.println("Reserved Seats:"+reserveSeats);
	   
	    if(levelID != 1234){
	    	System.out.println("Reserved at stage Level:"+levelID);
	    	System.out.println("Price:$"+price);
	    }
		return statusMsg;
		
		
	}
	

}