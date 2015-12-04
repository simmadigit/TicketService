/**
 * 
 */
package com.ticket.system.util;

import java.util.Random;

/**
 * @author simmadi
 *
 */
public class TSApplicationUtil {

	/**
	 * 
	 */
	public TSApplicationUtil() {
		// TODO Auto-generated constructor stub	
		
	}
	
	private String LEVEL_ORCHESTRA = "Orchestra";
	private String LEVEL_MAIN = "Main";
	private String LEVEL_BALCONY1 = "Balcony1";
	private String LEVEL_BALCONY2 = "Balcony2";
	
	
	/**
	* To get the random Seat Hold Id
	* @return random number
	*/
	public int getSeatHoldRanNum() {
	    Random r = new Random( System.currentTimeMillis() );
	    return (1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
	}

	
	/**
	* To get the price of researved seats
	*  @return price
	*/
	
	public Double getPrice(int level)
	{
		double price = 0.0;
		switch (level) {
		case 1: {
			price = 100.00;		
			break;
		}

		case 2: {
			price = 75.00;			
			break;
		}

		case 3: {
			price = 50.00;
			break;
		}

		case 4: {
			price = 40.00;
			break;
		}

		}

		return price;
	}
	
	/**
	* To get the Level Name
	* @return level name
	*/

	public String getLevelName(int level)
	{

		String levelName= null;;

		switch (level) {
		case 1: {
			
			levelName=LEVEL_ORCHESTRA;
			break;
		}

		case 2: {
			
			levelName = LEVEL_MAIN;
			break;
		}

		case 3: {
			
			levelName = LEVEL_BALCONY1;
			break;
		}

		case 4: {
			
			levelName = LEVEL_BALCONY2;
			break;
		}

		}

		return levelName;
	}
	
	/**
	* To get the total price
	* @return total price
	*/
	
	public Double getTotalPrice(int level , int seats){	
		
		Double price = getPrice(level) * seats;
		
		return price;
	}
}
