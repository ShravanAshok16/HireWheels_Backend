package com.hirewheels.hirewheels.services;

import com.hirewheels.hirewheels.entities.User;

public interface UserService {
    User getUser(User user);
    User createUser(User user);
    User getUserDetailsByEmail(String email);
}
