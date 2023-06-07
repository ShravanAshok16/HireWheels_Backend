package com.hirewheels.hirewheels.dao;

import com.hirewheels.hirewheels.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDAO extends JpaRepository<Location,Integer> {
}
