package com.hirewheels.hirewheels.services;

import com.hirewheels.hirewheels.entities.Vehicle;

public interface AdminService {
    Vehicle registerVehicle(Vehicle vehicle);
    Vehicle changeAvailability(int vehicleId, int availabilityStatus);
}
