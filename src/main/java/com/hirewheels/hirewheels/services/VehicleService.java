package com.hirewheels.hirewheels.services;

import com.hirewheels.hirewheels.entities.Vehicle;

import java.util.Date;
import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId);
    public List<Vehicle> getAllVehicles();
}
