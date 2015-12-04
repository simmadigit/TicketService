/**
 *
 */
package com.ticket.system;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;


import com.ticket.system.beans.SeatHold;
import com.ticket.system.impl.TicketServiceImpl;
import com.ticket.system.util.TSConstants;

import org.apache.log4j.Logger;



/**
 * @author simmadi
 *
 */
public class TSMainMenuScreen {

	/**
	 * @param args
	 * @throws Exception
	 */
	private static Logger logger = Logger.getLogger(TSMainMenuScreen.class);

	public static void main(String[] args) throws Exception {


		TSGetCustmoerInput tsGetCustmoerInput = new TSGetCustmoerInput();
		TicketServiceImpl ticketService = new TicketServiceImpl();
		try{
			TicketService(tsGetCustmoerInput,ticketService );
		}catch(NumberFormatException | InputMismatchException exception){
			System.out.println("Invalid Entry causes Exit");
			logger.error("exception:"+exception);
		}

	}


	public static void TicketService(TSGetCustmoerInput tsGetCustmoerInput, TicketServiceImpl ticketService ) throws Exception{

		System.out.println("==========================================");
		System.out.println("|   Welcome to the Ticket Service System |");
		System.out.println("==========================================");

		System.out.println("==========================================");
		System.out.println("|       MENU SELECTION                   |");
		System.out.println("==========================================");
		System.out.println("|    1. Check Seats Availability         |");
		System.out.println("|    2. Hold and Reservation of          |");
		System.out.println("|       available Seats                  |");
		System.out.println("|    3. Close                            |");
		System.out.println("==========================================");

		System.out.print("Select Option[1 / 2 / 3] :");


		try	(
				Scanner choiceInput = new Scanner(System.in);
				){
			
			int choice = Integer.parseInt(choiceInput.nextLine());

			switch(choice)
			{

			case 1:
			{

				if(logger.isDebugEnabled()){
					logger.debug("Customer Selected Check Seats Availability");
				}
				int avaiableSeats =0;

				String OptFlag = tsGetCustmoerInput.getOptionFlag();
				if(OptFlag.equalsIgnoreCase(TSConstants.TS_CUSTMOER_YES_OPT)){
					avaiableSeats = ticketService.numSeatsAvailable(tsGetCustmoerInput.getStageLevel());
				}else{
					avaiableSeats = ticketService.numSeatsAvailable(TSConstants.TS_VENUE_OPTIONAL_LEVEL);
				}
				System.out.println("Available Seats: "+avaiableSeats);

				String doFlag = tsGetCustmoerInput.doContinue();
				if(doFlag.equalsIgnoreCase(TSConstants.TS_CUSTMOER_NO_OPT)){
					System.out.println("Thank you , Bye!!!");
					System.exit(0);
				}

			}
			case 2:
			{
				if(logger.isDebugEnabled()){
					logger.debug("Customer Selected Hold Available Seats  ");
				}

				System.out.println("=========================================");
				System.out.println("|       Hold Available Seats            |");
				System.out.println("=========================================");

				String customerEmail = tsGetCustmoerInput.getEmailId();
				System.out.println("\nEnter Minimum Venue Level: ");
				Optional<Integer> minLevel = tsGetCustmoerInput.getStageLevel();
				System.out.println("\nEnter Maximum Venue Level: ");
				Optional<Integer> maxLevel = tsGetCustmoerInput.getStageLevel();
				int numOfSeatsToHold = tsGetCustmoerInput.getNumOfSeatsToHold(minLevel, maxLevel);

				SeatHold seatHold = ticketService.findAndHoldSeats(numOfSeatsToHold, minLevel, maxLevel, customerEmail);
				if ( seatHold.getSeatsHolded()>0) {
					System.out.println("Number of Seats Requested to Hold :"+seatHold.getNumOfSeats());
					System.out.println("Number of Seats Holded :"+seatHold.getSeatsHolded());
					if(seatHold.getSeatsHoldedLevel() != 1234){
						System.out.println("Seats Holded venue Level :"+seatHold.getSeatsHoldedLevel());
					}else{
					}	System.out.println("Seats Holded across requested levels ");
					System.out.println("Seats Holded ID :"+seatHold.getSeatHoldId());
					System.out.println("Your Seats Holded ID is valid for 60 Seconds");
				} else{
					System.out.println("Thank you , Bye!!!");
					System.exit(0);
				}

				String doFlag = tsGetCustmoerInput.doContinue();
				if(doFlag.equalsIgnoreCase(TSConstants.TS_CUSTMOER_NO_OPT)){
					System.out.println("Thank you , Bye!!!");
					System.exit(0);
				}else{
					doReservation(tsGetCustmoerInput,ticketService );
				}
			}
			case 3:
			{
				if(logger.isDebugEnabled()){
					logger.debug("Customer is Exited");
				}

				System.out.println("Thank you , Bye!!!");
				System.exit(0);
				break;
			}
			default : System.out.println("Invalid Input, Please choose any one of the above available Options'1 or 2 or 3 or 4'");
			break;
			}

		} catch(NumberFormatException | InputMismatchException exception){

			System.out.println("Invalid Entry causes Exit");
			logger.error("exception:"+exception);
		}

	}		
	public static void doReservation(TSGetCustmoerInput tsGetCustmoerInput, TicketServiceImpl ticketService ) throws Exception{

		if(logger.isDebugEnabled()){
			logger.debug("Customer selected Make Reservation of Seats ");
		}
		System.out.println("=========================================");
		System.out.println("|         Make Reservation of Seats      | ");
		System.out.println("=========================================");
		int  seatHoldId = tsGetCustmoerInput.getCustomerSeatHoldId();		
		String customerEmail = tsGetCustmoerInput.getEmailId();
		System.out.println("Status: "+ticketService.reserveSeats(seatHoldId, customerEmail));		
		String doFlag = tsGetCustmoerInput.doContinue();		
		if(doFlag.equalsIgnoreCase(TSConstants.TS_CUSTMOER_NO_OPT)){
			System.out.println("Thank you , Bye!!!");
			System.exit(0);
		}else{

			TicketService(tsGetCustmoerInput,ticketService );						
		}

	}
}

