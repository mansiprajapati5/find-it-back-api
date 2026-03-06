package com.finditback.system.auth.service;



import com.finditback.system.auth.Decorator.CustomUserDetails;
import com.finditback.system.auth.Model.User;
import com.finditback.system.auth.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByIdAndSoftDeleteIsFalse(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));
        return new CustomUserDetails(user);
    }
}