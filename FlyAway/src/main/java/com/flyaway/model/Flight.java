package com.flyaway.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="FlightId", insertable=false)
	private int Id;
	
	@Column(name="FromPlaceId")
	private int fromPlaceId;
	
	@Column(name="ToPlaceId")
	private int toPlaceId;
	
	@Column(name="AirlinesId")
	private int airlineId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="DepartureDate")
	private Date departureDate;
	
	@Column(name="NoOfSeats")
	public static int noOfSeats;
	
	@Column(name="Price")
	private int price;
	
	@Column(name="SeatsBooked")
	private int seatsBooked;
	
	@Column(name="DepartureTime")
	private Date departureTime;
	
	@Column(name="ArrivalTime")
	private Date arrivalTime;
	
	public Flight() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getFromPlaceId() {
		return fromPlaceId;
	}

	public void setFromPlaceId(int fromPlaceId) {
		this.fromPlaceId = fromPlaceId;
	}

	public int getToPlaceId() {
		return toPlaceId;
	}

	public void setToPlaceId(int toPlaceId) {
		this.toPlaceId = toPlaceId;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public static int getNoOfSeats() {
		return noOfSeats;
	}

	public static void setNoOfSeats(int noOfSeats) {
		Flight.noOfSeats = noOfSeats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
	
	

}
