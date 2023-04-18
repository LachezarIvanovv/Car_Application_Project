package softuni.Mobilele.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import softuni.Mobilele.model.dto.UserRegisterDTO;
import softuni.Mobilele.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDTOToUserEntity(UserRegisterDTO registerDTO);
}
