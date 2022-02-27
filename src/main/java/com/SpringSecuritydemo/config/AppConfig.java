package com.SpringSecuritydemo.config;

import lombok.var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * We have to implement UserDetailsService and PasswordEncoder, so that spring security wil not call default one
 */
@Configuration
public class AppConfig{

    //Here we are trying to override UserDetails service, so that spring security will not call the default UserDetails

    //When implementing UserDetails, we should implement password encoder as well, or else it will give us exception {No passwordEncoder found}

    @Bean
    public UserDetailsService userDetailsService(){
        //in memory user details manager
        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("ram")
                            .password("123")
                            .authorities("read")
                            .build();

        uds.createUser(u1);
        return uds;
    }

    //Implementing the Password Encoder, to resolve passwordEncoder execption
    @Bean
    public PasswordEncoder passwordEncoder(){
       return NoOpPasswordEncoder.getInstance();
    }
}
