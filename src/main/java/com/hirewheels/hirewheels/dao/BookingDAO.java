package com.hirewheels.hirewheels.dao;

import com.hirewheels.hirewheels.entities.Booking;
import com.hirewheels.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDAO extends JpaRepository<Booking,Integer> {
    List<Booking> findByVehicleWithBooking(Vehicle vehicle);
}
