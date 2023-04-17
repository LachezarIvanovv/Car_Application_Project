package softuni.Mobilele.model.mapper;

import org.mapstruct.Mapper;
import softuni.Mobilele.model.dto.AddOfferDTO;
import softuni.Mobilele.model.entity.OfferEntity;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
}
