/**
 * 
 */
package com.ticket.system.beans;

/**
 * @author simmadi
 *
 */
public class ReserveSeat {
	
	private int levelId;
	private String levelName;
	private Double price;
	private String showDate;
	private String showTime;
	private String customerEmail;
	public int reservedSeats;
	
	
	/**
	 * @return the levelId
	 */
	public int getLevelId() {
		return levelId;
	}
	/**
	 * @param levelId the levelId to set
	 */
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
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
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * @return the reservedSeats
	 */
	public int getReservedSeats() {
		return reservedSeats;
	}
	/**
	 * @param reservedSeats the reservedSeats to set
	 */
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

}
