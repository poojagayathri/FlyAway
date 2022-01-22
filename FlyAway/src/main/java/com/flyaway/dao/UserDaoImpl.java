package com.flyaway.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flyaway.model.Airlines;
import com.flyaway.model.BookingDetails;
import com.flyaway.model.Flight;
import com.flyaway.model.Places;
import com.flyaway.model.UserDetails;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Flight> searchFlight(Flight flight) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("From Flight where toPlaceId=:toId and fromPlaceId=:fromId and departureDate=:depDate and (NoOfSeats-seatsBooked)>="+Flight.noOfSeats);		
		query.setParameter("toId", flight.getToPlaceId());
		query.setParameter("fromId", flight.getFromPlaceId());
		query.setParameter("depDate", flight.getDepartureDate());
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public List<Flight> flightDetails(int flightId) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("From Flight where id=:id");	
		query.setParameter("id", flightId);
		return query.getResultList();
	}


	@Override
	@Transactional
	public boolean passwordCheck(UserDetails userDet) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("From UserDetails where userName=:userName and password=:password ");
		query.setParameter("userName", userDet.getUserName());
		query.setParameter("password", userDet.getPassword());
		List<UserDetails> checkPass=query.getResultList();
		if(checkPass.size()>=1)
			return true;
		else
			return false;
	}	
	
	@Override
	@Transactional
	public boolean userBooked(UserDetails user ,int flightId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From BookingDetails where flightId=:flightId and userName=:name ");
		query.setParameter("flightId", flightId);
		query.setParameter("name", user.getUserName());
		List<BookingDetails> bookingDet=query.getResultList();
		if(bookingDet.size()>=1)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void updateSeatsBooked(int flightId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Flight set seatsBooked=seatsBooked+1 where Id=:flightId ");
		query.setParameter("flightId", flightId);
		int count=query.executeUpdate();
	}
	
	@Override
	@Transactional
	public void bookTickets(BookingDetails bookingDet) {
		Session session=sessionFactory.getCurrentSession();
		session.save(bookingDet);
	}
	
	@Override
	@Transactional
	public List<Places> getAllPlace() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From Places");
		List<Places> placesList=query.getResultList();
		for(Places pl:placesList)
			System.out.println(pl.getId());
		return placesList;
	}
	
	@Override
	@Transactional
	public boolean checkUserExist(UserDetails userDetails) {
		String sql="From UserDetails where userName=:userName";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(sql);
		query.setParameter("userName", userDetails.getUserName());
		List<UserDetails> list= query.getResultList();
		if(list.size()>=1)
			return false;
		else
			return true;
		
	}
	
	@Override
	@Transactional
	public void saveRegisterDet(UserDetails userDetails) {
		Session session=sessionFactory.getCurrentSession();
		session.save(userDetails);
	}
	
	@Override
	@Transactional
	public boolean checkIsAdmin(UserDetails userDetails) {
		Session session=sessionFactory.getCurrentSession();
		String sql="From UserDetails where userName=:userName ";
		Query query=session.createQuery(sql);
		query.setParameter("userName", userDetails.getUserName());
		List<UserDetails> list=query.getResultList();
		if(list.get(0).getIsAdmin().equalsIgnoreCase("No"))
		{
			return false;
		}else {
			return true;
		}		
	}
	
	@Override
	@Transactional
	public List<Airlines> getAllAirlines() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From Airlines");
		List<Airlines> airlineList=query.getResultList();
		for(Airlines pl:airlineList)
			System.out.println(pl.getId());
		return airlineList;
	}
	
	@Override
	@Transactional
	public List<UserDetails> getAllUserDetails() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From UserDetails");
		List<UserDetails> userList=query.getResultList();
		for(UserDetails pl:userList)
			System.out.println(pl.getId());
		return userList;
	}
	
	@Override
	@Transactional
	public List<Flight> getAllFlight() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From Flight");
		List<Flight> flightList=query.getResultList();
		for(Flight pl:flightList)
			System.out.println(pl.getId());
		return flightList;
	}
	

}
