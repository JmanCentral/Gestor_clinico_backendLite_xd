package com.gestor.clinia.gestorclinia.mappers;

import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaRequestDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaResponseDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaUpdateRequestDTO;
import com.gestor.clinia.gestorclinia.entities.ConsultaMedica;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ConsultaMedicaMapper {


    ConsultaMedica toEntity(ConsultaMedicaRequestDTO dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ConsultaMedicaUpdateRequestDTO dto, @MappingTarget ConsultaMedica entity);
    @Mapping(source = "paciente.id", target = "idPaciente")
    ConsultaMedicaResponseDTO toDTO(ConsultaMedica consultaMedica);

}
