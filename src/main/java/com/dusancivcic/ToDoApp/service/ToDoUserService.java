package com.dusancivcic.ToDoApp.service;

import com.dusancivcic.ToDoApp.model.ToDoUser;
import com.dusancivcic.ToDoApp.repository.ToDoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ToDoUserService implements UserDetailsService {
    @Autowired
    private ToDoUserRepository toDoUserRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ToDoUser toDoUser = toDoUserRepository.findByUserName(userName);
        if (toDoUser == null) {
            throw new UsernameNotFoundException("Could not find this user!");
        } else
            return toDoUser;
    }

    public void registerUser(ToDoUser toDoUser) {
        String password = passwordEncoder.encode(toDoUser.getPassword());
        toDoUser.setPassword(password);
        toDoUserRepository.save(toDoUser);
    }
}
