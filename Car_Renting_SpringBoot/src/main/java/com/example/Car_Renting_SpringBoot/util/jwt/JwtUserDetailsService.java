package com.example.Car_Renting_SpringBoot.util.jwt;

import com.example.Car_Renting_SpringBoot.service.User.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.Car_Renting_SpringBoot.entity.User user = userService.getByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }

        User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        builder.password(user.getPassword());

        String profilo;
        if(user.getAdmin()){
            profilo = "ROLE_ADMIN";
        }
        else{
            profilo = "ROLE_USER";
        }

        builder.authorities(profilo);

        return builder.build();
    }
}
