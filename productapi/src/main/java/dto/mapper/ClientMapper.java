package dto.mapper;

import dto.request.ClientDTO;
import entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Client toModel(ClientDTO dto);

    ClientDTO toDTO(Client dto);
}
