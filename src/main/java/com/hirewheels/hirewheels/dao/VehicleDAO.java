package com.hirewheels.hirewheels.dao;

import com.hirewheels.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDAO extends JpaRepository<Vehicle,Integer> {
    boolean existsByVehicleNumber(String VehicleNumber);
}
