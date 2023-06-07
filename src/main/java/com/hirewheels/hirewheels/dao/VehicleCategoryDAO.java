package com.hirewheels.hirewheels.dao;

import com.hirewheels.hirewheels.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryDAO extends JpaRepository<VehicleCategory,Integer> {
    VehicleCategory findByVehicleCategoryName(String category);
    VehicleCategory findByVehicleCategoryId(int categoryId);
}
