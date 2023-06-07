package com.hirewheels.hirewheels.dao;

import com.hirewheels.hirewheels.entities.Booking;
import com.hirewheels.hirewheels.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDAO extends JpaRepository<City,Integer> {
}
