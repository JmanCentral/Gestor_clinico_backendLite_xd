package com.gestor.clinia.gestorclinia.mappers;

import com.gestor.clinia.gestorclinia.dtos.UserDTO;
import com.gestor.clinia.gestorclinia.entities.User;

public interface UserMapper {

    User toEntity(UserDTO dto);

}
