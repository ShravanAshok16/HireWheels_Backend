package com.hirewheels.hirewheels;

import com.hirewheels.hirewheels.dao.FuelTypeDAO;
import com.hirewheels.hirewheels.dao.LocationDAO;
import com.hirewheels.hirewheels.dao.RoleDAO;
import com.hirewheels.hirewheels.dao.VehicleSubCategoryDAO;
import com.hirewheels.hirewheels.entities.Booking;
import com.hirewheels.hirewheels.entities.FuelType;
import com.hirewheels.hirewheels.entities.User;
import com.hirewheels.hirewheels.entities.Vehicle;
import com.hirewheels.hirewheels.services.AdminService;
import com.hirewheels.hirewheels.services.BookingService;
import com.hirewheels.hirewheels.services.InitService;
import com.hirewheels.hirewheels.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.util.Date;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		UserService userService = context.getBean(UserService.class);
		RoleDAO roleDAO = context.getBean(RoleDAO.class);
		AdminService adminService = context.getBean(AdminService.class);
		VehicleSubCategoryDAO vehicleSubCategoryDAO = context.getBean(VehicleSubCategoryDAO.class);
		FuelTypeDAO fuelTypeDAO = context.getBean(FuelTypeDAO.class);
		LocationDAO locationDAO = context.getBean(LocationDAO.class);
		BookingService bookingService = context.getBean(BookingService.class);

		System.out.println("Creating New User: ");
		User user1 = new User();
		user1.setEmail("lalithacashok16@gmail.com");
		user1.setFirstName("Lalitha");
		user1.setLastName("Ashok");
		user1.setMobileNo("9880632752");
		user1.setPassword("18071969");
		user1.setRole(roleDAO.findById(2).get());
		userService.createUser(user1);

		System.out.println("Adding a new vehicle: ");
		Vehicle vehicle = new Vehicle("AMG", "IND 350", "Red", 1,
				"https://www.mercedes-amg.com/en/world-of-amg/news/press-information/mercedes-amg-gt-black-series-record-lap.html",
				vehicleSubCategoryDAO.findById(2).get(), locationDAO.findById(1).get(), fuelTypeDAO.findById(1).get());
		adminService.registerVehicle(vehicle);

		System.out.println("Adding a New Booking: ");
		Booking booking = new Booking();
		booking.setUser(user1);
		booking.setBookingDate(new Date());
		booking.setDropoffDate(new Date());
		booking.setLocation(locationDAO.findById(1).get());
		booking.setAmount(200);
		booking.setPickupDate(new Date());
		booking.setVehicleWithBooking(vehicle);

		adminService.changeAvailability(vehicle.getVehicleId(), 0);

		bookingService.addBooking(booking);
	}
	@Bean
	CommandLineRunner init(InitService initService) {
		return args -> {
			initService.start();
		};
	}
}
