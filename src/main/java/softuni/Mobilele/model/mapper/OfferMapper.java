package softuni.Mobilele.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import softuni.Mobilele.model.dto.CreateOrUpdateOfferDTO;
import softuni.Mobilele.model.dto.OfferDetailDTO;
import softuni.Mobilele.model.entity.OfferEntity;


@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity createOrUpdateOfferDtoToOfferEntity(CreateOrUpdateOfferDTO createOrUpdateOfferDTO);

    CreateOrUpdateOfferDTO offerEntityToCreateOrUpdateOfferDtoTo(OfferEntity offerEntity);

    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "model.brand.name", target = "brand")
    @Mapping(source = "seller.firstName", target = "sellerFirstName")
    @Mapping(source = "seller.lastName", target = "sellerLastName")
    OfferDetailDTO offerEntityToOfferDetailDto(OfferEntity offer);
}
