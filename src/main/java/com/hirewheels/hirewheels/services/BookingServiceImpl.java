package com.hirewheels.hirewheels.services;

import com.hirewheels.hirewheels.dao.BookingDAO;
import com.hirewheels.hirewheels.dao.UserDAO;
import com.hirewheels.hirewheels.entities.Booking;
import com.hirewheels.hirewheels.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingDAO bookingDao;

    @Autowired
    UserDAO userDao;

    @Override
    public Booking addBooking(Booking booking) {
        User getUser = booking.getUser();
        if(getUser.getWalletMoney() < booking.getAmount()){
            System.out.println("Insufficient Balance. Please Check With Admin.");
        }else {
            getUser.setWalletMoney(getUser.getWalletMoney() - booking.getAmount());
            userDao.save(getUser);
        }
        Booking savedBooking = bookingDao.save(booking);
        return savedBooking;
    }
}
