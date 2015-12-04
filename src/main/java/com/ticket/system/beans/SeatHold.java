/**
 * 
 */
package com.ticket.system.beans;

import java.util.Optional;

/**
 * @author simmadi
 *
 */
public class SeatHold {

	private int seatHoldId;
	private Optional<Integer>  minLevel;
	private Optional<Integer>  maxLevel;
	private String levelName;
	private Double price;
	private String showDate;
	private String showTime;
	private String customerEmail;
	private int numOfSeats;
	private int seatsHolded;
	private int seatsHoldedLevel;
	private long  seatsHoldedTimeMills;
	

	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	/**
	 * @return the showDate
	 */
	public String getShowDate() {
		return showDate;
	}
	/**
	 * @param showDate the showDate to set
	 */
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	/**
	 * @return the showTime
	 */
	public String getShowTime() {
		return showTime;
	}
	/**
	 * @param showTime the showTime to set
	 */
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @return the seatHoldId
	 */
	public int getSeatHoldId() {
		return seatHoldId;
	}
	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @param seatHoldId the seatHoldId to set
	 */
	public void setSeatHoldId(int seatHoldId) {
		this.seatHoldId = seatHoldId;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * @return the minLevel
	 */
	public Optional<Integer> getMinLevel() {
		return minLevel;
	}
	/**
	 * @return the maxLevel
	 */
	public Optional<Integer> getMaxLevel() {
		return maxLevel;
	}
	/**
	 * @param minLevel the minLevel to set
	 */
	public void setMinLevel(Optional<Integer> minLevel) {
		this.minLevel = minLevel;
	}
	/**
	 * @param maxLevel the maxLevel to set
	 */
	public void setMaxLevel(Optional<Integer> maxLevel) {
		this.maxLevel = maxLevel;
	}
	/**
	 * @return the numOfSeats
	 */
	public int getNumOfSeats() {
		return numOfSeats;
	}
	/**
	 * @param numOfSeats the numOfSeats to set
	 */
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	/**
	 * @return the seatsHolded
	 */
	public int getSeatsHolded() {
		return seatsHolded;
	}
	/**
	 * @param seatsHolded the seatsHolded to set
	 */
	public void setSeatsHolded(int seatsHolded) {
		this.seatsHolded = seatsHolded;
	}
	/**
	 * @return the seatsHoldedLevel
	 */
	public int getSeatsHoldedLevel() {
		return seatsHoldedLevel;
	}
	/**
	 * @param seatsHoldedLevel the seatsHoldedLevel to set
	 */
	public void setSeatsHoldedLevel(int seatsHoldedLevel) {
		this.seatsHoldedLevel = seatsHoldedLevel;
	}
	/**
	 * @return the seatsHoldedTimeMills
	 */
	public long getSeatsHoldedTimeMills() {
		return seatsHoldedTimeMills;
	}
	/**
	 * @param seatsHoldedTimeMills the seatsHoldedTimeMills to set
	 */
	public void setSeatsHoldedTimeMills(long seatsHoldedTimeMills) {
		this.seatsHoldedTimeMills = seatsHoldedTimeMills;
	}
	
}
