package com.axcertro_demo_crud.controller;

import com.axcertro_demo_crud.dto.UserDTO;
import com.axcertro_demo_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.createUser(userDTO);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId) {
        UserDTO user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.updateUser(userDTO);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
