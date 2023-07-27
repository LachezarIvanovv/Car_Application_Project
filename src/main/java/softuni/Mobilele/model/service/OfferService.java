package softuni.Mobilele.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import softuni.Mobilele.model.dto.CreateOrUpdateOfferDTO;
import softuni.Mobilele.model.dto.OfferDetailDTO;
import softuni.Mobilele.model.dto.SearchOfferDTO;
import softuni.Mobilele.model.entity.ModelEntity;
import softuni.Mobilele.model.entity.OfferEntity;
import softuni.Mobilele.model.entity.UserEntity;
import softuni.Mobilele.model.enums.UserRoleEnum;
import softuni.Mobilele.model.mapper.OfferMapper;
import softuni.Mobilele.repository.ModelRepository;
import softuni.Mobilele.repository.OfferRepository;
import softuni.Mobilele.repository.OfferSpecification;
import softuni.Mobilele.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository,
                        UserRepository userRepository,
                        ModelRepository modelRepository,
                        OfferMapper offerMapper){

        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.offerMapper = offerMapper;
    }

    public boolean isOwner(String userName, Long offerId){
        boolean isOwner = offerRepository.findById(offerId)
                .filter(offer -> offer.getSeller().getEmail().equals(userName))
                .isPresent();

        if(isOwner){
            return true;
        }

        return userRepository.findByEmail(userName)
                .map(this::isAdmin)
                .isPresent();
    }

    private boolean isAdmin(UserEntity user){
        return user.getUserRoles()
                .stream()
                .anyMatch(r -> r.getUserRole() == UserRoleEnum.ADMIN);
    }

    public void deleteOfferById(Long offerId){
        offerRepository.deleteById(offerId);
    }

    public void addOffer(CreateOrUpdateOfferDTO createOrUpdateOfferDTO, UserDetails userDetails){
        OfferEntity newOffer = offerMapper.createOrUpdateOfferDtoToOfferEntity(createOrUpdateOfferDTO);

        UserEntity seller = userRepository
                .findByEmail(userDetails.getUsername())
                .orElseThrow();

        ModelEntity model = modelRepository
                .findById(createOrUpdateOfferDTO.getModelId())
                .orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);
    }

    public Optional<CreateOrUpdateOfferDTO> getOfferEditDetails(Long offerId){
        return offerRepository.findById(offerId)
                .map(offerMapper::offerEntityToCreateOrUpdateOfferDtoTo);
    }

    public Page<OfferDetailDTO> getAllOffers(Pageable pageable){
        return offerRepository.findAll(pageable)
                .map(offerMapper::offerEntityToOfferDetailDto);
    }

    public Optional<OfferDetailDTO> findOfferById(Long offerId){
        return offerRepository.findById(offerId)
                .map(offerMapper::offerEntityToOfferDetailDto);
    }

    public List<OfferDetailDTO> searchOffer(SearchOfferDTO searchOfferDTO){
        return this.offerRepository.findAll(new OfferSpecification(searchOfferDTO))
                .stream()
                .map(offer -> offerMapper.offerEntityToOfferDetailDto((OfferEntity) offer))
                .toList();
    }
}
