package com.fifa.fifaworldcup.service.Impl;

import com.fifa.fifaworldcup.entity.User;
import com.fifa.fifaworldcup.repository.UserRepository;
import com.fifa.fifaworldcup.securityConfiguration.UserMain;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class UserMainDetailService implements UserDetailsService {

    private UserRepository userRepository;


    public UserMainDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("given USER NAME "+username);
        User user = userRepository.findByUsername(username);
        System.out.println("user from repo >>>>>>>>>>>>>>>>>>>>>>"+user.getPassword());
        UserMain userMain = new UserMain(user);
        System.out.println("USER-MAIN >>>>> "+userMain);
        return userMain;
    }
}
