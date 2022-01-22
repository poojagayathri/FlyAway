package com.flyaway.dao;

import java.util.List;

import com.flyaway.model.Airlines;
import com.flyaway.model.BookingDetails;
import com.flyaway.model.Flight;
import com.flyaway.model.Places;
import com.flyaway.model.UserDetails;

public interface UserDao {
	
	public List<Flight> searchFlight(Flight flight);
	
	public boolean passwordCheck(UserDetails userDet);
	
	public List<Flight> flightDetails(int flightId);
	
	public boolean userBooked(UserDetails user ,int flightId);
	
	public void updateSeatsBooked(int flightId);
	
	public void bookTickets(BookingDetails bookingDet);
	
	public List<Places> getAllPlace();
	
	public void saveRegisterDet(UserDetails userDetails);
	
	public boolean checkUserExist(UserDetails userDetails);
	
	public boolean checkIsAdmin(UserDetails userDetails);
	
	public List<Airlines> getAllAirlines();
	
	public List<UserDetails> getAllUserDetails();
	
	public List<Flight> getAllFlight();
	

}
