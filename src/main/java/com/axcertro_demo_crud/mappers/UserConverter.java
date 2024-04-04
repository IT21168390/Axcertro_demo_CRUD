package com.axcertro_demo_crud.mappers;

import com.axcertro_demo_crud.dto.UserDTO;
import com.axcertro_demo_crud.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;

    public User convertUserDTOToUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    public UserDTO convertUserToUserDTO(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
}
