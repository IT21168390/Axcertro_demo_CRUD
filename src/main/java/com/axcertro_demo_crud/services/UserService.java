package com.axcertro_demo_crud.services;

import com.axcertro_demo_crud.dto.UserDTO;

public interface UserService {
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO getUser(int userId);
    public UserDTO updateUser(UserDTO userDTO);
    public void deleteUser(int userId);
}
