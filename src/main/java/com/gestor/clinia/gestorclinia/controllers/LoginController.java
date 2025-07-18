package com.gestor.clinia.gestorclinia.controllers;


import com.gestor.clinia.gestorclinia.dtos.LoginRequestDTO;
import com.gestor.clinia.gestorclinia.dtos.LoginResponseDTO;
import com.gestor.clinia.gestorclinia.servicies.login.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginController {

    private final ILoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO = loginService.userAutentication(loginRequestDTO);
        return ResponseEntity.ok(loginResponseDTO);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDTO> refreshToken(@RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.ok(loginService.refreshToken(authHeader));
    }

}
