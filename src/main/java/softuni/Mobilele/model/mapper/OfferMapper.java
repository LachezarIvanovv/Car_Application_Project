package softuni.Mobilele.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import softuni.Mobilele.model.dto.AddOfferDTO;
import softuni.Mobilele.model.dto.OfferDetailDTO;
import softuni.Mobilele.model.entity.OfferEntity;


@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);

    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "model.brand.name", target = "brand")
    @Mapping(source = "seller.firstName", target = "sellerFirstName")
    @Mapping(source = "seller.lastName", target = "sellerLastName")
    OfferDetailDTO offerEntityToOfferDetailDto(OfferEntity offer);
}
