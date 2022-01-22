package com.flyaway.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyaway.dao.UserDao;
import com.flyaway.model.Airlines;
import com.flyaway.model.BookingDetails;
import com.flyaway.model.Flight;
import com.flyaway.model.Places;
import com.flyaway.model.UserDetails;

@Service
public class FronendServiceImpl implements FrontendService{
	
	@Autowired
	private UserDao dao;

	@Override
	@Transactional
	public List<Flight> searchFlight(Flight flight) {
		return dao.searchFlight(flight);
	}

	@Override
	@Transactional
	public boolean passwordCheck(UserDetails userDet) {
		return dao.passwordCheck(userDet);		
	}

	@Override
	@Transactional
	public List<Flight> flightDetails(int flightId) {
		return dao.flightDetails(flightId);
	}

	@Override
	public boolean userBooked(UserDetails user, int flightId) {
		return dao.userBooked(user, flightId);
	}

	@Override
	public void updateSeatsBooked(int flightId) {
		dao.updateSeatsBooked(flightId);		
	}

	@Override
	public void bookTickets(BookingDetails bookingDet) {
		dao.bookTickets(bookingDet);		
	}

	@Override
	public List<Places> getAllPlace() {
		return dao.getAllPlace();
	}

	@Override
	public void saveRegisterDet(UserDetails userDetails) {
		dao.saveRegisterDet(userDetails);
		
	}

	@Override
	public boolean checkUserExist(UserDetails userDetails) {
		return dao.checkUserExist(userDetails);
	}

	@Override
	public boolean checkIsAdmin(UserDetails userDetails) {
		return dao.checkIsAdmin(userDetails);
	}

	@Override
	public List<Airlines> getAllAirlines() {
		return dao.getAllAirlines();
	}

	@Override
	public List<UserDetails> getAllUserDetails() {
		// TODO Auto-generated method stub
		return dao.getAllUserDetails();
	}

	@Override
	public List<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		return dao.getAllFlight();
	}

}
