package com.gestor.clinia.gestorclinia.servicies.login;

import com.gestor.clinia.gestorclinia.dtos.LoginRequestDTO;
import com.gestor.clinia.gestorclinia.dtos.LoginResponseDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface ILoginService  {

    LoginResponseDTO userAutentication(LoginRequestDTO loginRequestDTO);

    UserDetails loadUserByUsername(String username);

    LoginResponseDTO refreshToken(String authHeader);
}
