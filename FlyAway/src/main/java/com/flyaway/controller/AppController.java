package com.flyaway.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flyaway.model.BookingDetails;
import com.flyaway.model.Flight;
import com.flyaway.model.Places;
import com.flyaway.model.UserDetails;
import com.flyaway.service.FrontendService;

@Controller
public class AppController {
	@Autowired
	private FrontendService frontendService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@GetMapping(path="/")
	public String login(Model model,@ModelAttribute("flight")Flight flight) {
		System.out.println("entered Login");
		List<Places> placesList=frontendService.getAllPlace();
		//Map<String,Integer> placesMap = placesList.stream().collect(Collectors.toMap(Places::getPlaceName, Places::getId));
		//List<Integer> placesList=Arrays.asList(1,2,3,4);
		
		model.addAttribute("placesList",placesList);
		return "index";
	}
	
	@GetMapping(path="FlyAway")
	public String redirectTo() {
		return "redirect:/";
	}
	
	@PostMapping(path="SearchFlight")
	public ModelAndView searchFlight(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("flight")Flight flight) {
		System.out.print(flight.getDepartureDate());
		ModelAndView modelView=new ModelAndView();
		System.out.println(flight.getToPlaceId()+" to Id");
		System.out.println(flight.getFromPlaceId()+" from Id");
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-DD");
		//String dep=df.format(flight.getDepartureDate());
		Flight.noOfSeats=Integer.parseInt(request.getParameter("noOfPersons"));
		System.out.println(Flight.noOfSeats+" is the number of seats");
		List<Flight> flightList=frontendService.searchFlight(flight);
		for(Flight fli:flightList)
			System.out.println(fli.getPrice());
		modelView.addObject("flight", flightList);
		modelView.setViewName("FlightList");
		return modelView;
	}
	
	@GetMapping(path="/detailsBeforeBooking")
	public ModelAndView detailsBeforeBooking(@ModelAttribute("flight")Flight flight) {
		int flightId=flight.getId();
		System.out.println(flightId+" entering details before booking" +flight.getPrice()+" is the price");
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("userDetails",new UserDetails());
		modelView.addObject("flightId", flightId);
		modelView.addObject("noOfSeats",Flight.noOfSeats);
		modelView.setViewName("Login");
		return modelView;		
	}
	
	@PostMapping(path="/login")
	public String login(@ModelAttribute("userDetails")UserDetails userDetails,Model model,HttpServletRequest request) {
		System.out.println(userDetails.getPassword()+" "+userDetails.getUserName()+" is the deatils "+Flight.noOfSeats);
		boolean passwordCorrect=frontendService.passwordCheck(userDetails);
		int flightId=Integer.parseInt(request.getParameter("flightId"));
		Flight flightDetails=(frontendService.flightDetails(flightId)).get(0);
		model.addAttribute("msg","Password Incorrect or Sign Up");
		model.addAttribute("flightId", flightId);
		model.addAttribute("flight", flightDetails);
		model.addAttribute("noOfSeats",Flight.noOfSeats);
		if(passwordCorrect&& frontendService.checkIsAdmin(userDetails)) {
			return "AdminDashboard";
		}
		else if(!passwordCorrect)
			return "Login";
		else
			return "ConfirmBooking";
	}
	
	@PostMapping(path="/ConfirmBooking")
	public String ConfirmBooking(HttpServletRequest request,Model model) {	
		int flightId=Integer.parseInt(request.getParameter("flightId"));
		model.addAttribute("flightId", flightId);
		model.addAttribute("userDetails",new UserDetails());
		if(Flight.noOfSeats==0)
			return "BookingSuccess";
		return "BookTickets";
	}
	
	@PostMapping(path="/BookTicket")
	public String BookTickets(HttpServletRequest request,@ModelAttribute("userDetails")UserDetails userDetails,Model model) {
		int flightId=Integer.parseInt(request.getParameter("flightId"));
		model.addAttribute("flightId", flightId);
		if(Flight.noOfSeats==0)
			return "BookingSuccess";
		else {
			boolean userBooked=frontendService.userBooked(userDetails, flightId);
			if(!userBooked) {
				System.out.println("user already booked");
				model.addAttribute("msg","Booking done for this user");
			}
			else
			{
				BookingDetails details=new BookingDetails();
				System.out.println(flightId+" "+userDetails.getUserName());
				details.setFlightId(flightId);
				details.setUserName(userDetails.getUserName());
				frontendService.bookTickets(details);
				frontendService.updateSeatsBooked(flightId);
				Flight.noOfSeats=Flight.noOfSeats-1;
				System.out.println(Flight.noOfSeats+" upadte done");
			}
			return "BookTickets";
		}
	}
	@GetMapping(path="/ToRegister")
	public String returnRegister(Model model,HttpServletRequest request) {
		int flightId=Integer.parseInt(request.getParameter("flightId"));
		model.addAttribute("msg","Password Incorrect or Sign Up");
		model.addAttribute("flightId", flightId);
		model.addAttribute("userDetails", new UserDetails());
		return "Register";
	}
	
	@PostMapping(path="/RegisterUser")
	public String registerUser(@ModelAttribute("userDetails")UserDetails userDetails,Model model,HttpServletRequest request) {
		if(frontendService.checkUserExist(userDetails))
		{
			frontendService.saveRegisterDet(userDetails);
			int flightId=Integer.parseInt(request.getParameter("flightId"));
			Flight flightDetails=(frontendService.flightDetails(flightId)).get(0);
			model.addAttribute("msg","Password Incorrect or Sign Up");
			model.addAttribute("flightId", flightId);
			model.addAttribute("flight", flightDetails);
			model.addAttribute("noOfSeats",Flight.noOfSeats);
			return "ConfirmBooking";
		}
		else {
			return "Login";
		}
		
	}
	
	@GetMapping(path="/UserList")
	public String getUserList(Model model) {
		model.addAttribute("User",frontendService.getAllUserDetails());
		return "UserList";
	}
	
	@GetMapping(path="/PlacesList")
	public String getPlacesList(Model model) {
		model.addAttribute("Places",frontendService.getAllPlace());
		model.addAttribute("Airlines",frontendService.getAllAirlines());
		return "PlacesList";
		
	}
	
	@GetMapping(path="/FlightList")
	public String getFlightList(Model model) {
		model.addAttribute("Flight",frontendService.getAllFlight());
		return "AirlinesList";
	}
}
