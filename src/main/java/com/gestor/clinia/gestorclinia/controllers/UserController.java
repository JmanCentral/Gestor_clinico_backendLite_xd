package com.gestor.clinia.gestorclinia.controllers;


import com.gestor.clinia.gestorclinia.dtos.UserDTO;
import com.gestor.clinia.gestorclinia.servicies.usuario.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDTO userRequestDTO) {
        userService.save(userRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
