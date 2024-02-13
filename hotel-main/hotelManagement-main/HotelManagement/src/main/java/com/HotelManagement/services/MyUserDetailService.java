package com.HotelManagement.services;

import com.HotelManagement.Repository.UserRepo;
import com.HotelManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService  implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepo.findFirstByUsername(username);
        System.out.println(user+"is there");
        if(user==null)
            throw new UsernameNotFoundException("Error 404");
        return user;
    }
}
