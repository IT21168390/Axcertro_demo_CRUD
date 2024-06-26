package com.axcertro_demo_crud.services.impl;

import com.axcertro_demo_crud.dto.UserDTO;
import com.axcertro_demo_crud.mappers.UserConverter;
import com.axcertro_demo_crud.models.User;
import com.axcertro_demo_crud.repository.UserRepository;
import com.axcertro_demo_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    public UserDTO createUser(UserDTO userDTO) {
        try {
            User user = userRepository.save(userConverter.convertUserDTOToUser(userDTO));
            return userConverter.convertUserToUserDTO(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public UserDTO getUser(int userId){
        try {
            User user = userRepository.findById(userId).get();
            return userConverter.convertUserToUserDTO(user);
        } catch (NoSuchElementException e) {
            System.out.println("Invalid User ID!");
            return null;
        }
    }

    public UserDTO updateUser(UserDTO userDTO) {
        try {
            User user = userRepository.findById(userDTO.getId()).get();
            user.setFirst_name(userDTO.getFirst_name());
            user.setLast_name(userDTO.getLast_name());
            user.setEmail(userDTO.getEmail());

            User updatedUser = userRepository.save(user);
            return userConverter.convertUserToUserDTO(updatedUser);
        } catch (NoSuchElementException e) {
            System.out.println("Invalid User ID!");
            return null;
        }
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
}
