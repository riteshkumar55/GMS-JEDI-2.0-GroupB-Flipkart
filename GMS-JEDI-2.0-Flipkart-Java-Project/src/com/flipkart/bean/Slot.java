/**
 * 
 */
package com.flipkart.bean;

import java.sql.Date;

/**
 * 
 */
public class Slot {
	private int slotId;
	private int slotTime;
	private int availSeats;
	private int gymId;
	private Date day;
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public int getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(int slotTime) {
		this.slotTime = slotTime;
	}
	public int getAvailSeats() {
		return availSeats;
	}
	
	public Slot(int slotId, int slotTime, int availSeats, int gymId, Date day) {
		super();
		this.slotId = slotId;
		this.slotTime = slotTime;
		this.availSeats = availSeats;
		this.gymId = gymId;
		this.day = day;
	}
	public Slot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public void setAvailSeats(int availSeats) {
		this.availSeats = availSeats;
	}
}
