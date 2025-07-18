package com.gestor.clinia.gestorclinia.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;
    private String username;
    private String email;
    private String password;
    private Set<String> rol;
}

