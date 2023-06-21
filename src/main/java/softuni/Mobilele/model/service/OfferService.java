package softuni.Mobilele.model.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import softuni.Mobilele.model.dto.AddOfferDTO;
import softuni.Mobilele.model.entity.ModelEntity;
import softuni.Mobilele.model.entity.OfferEntity;
import softuni.Mobilele.model.entity.UserEntity;
import softuni.Mobilele.model.mapper.OfferMapper;
import softuni.Mobilele.repository.ModelRepository;
import softuni.Mobilele.repository.OfferRepository;
import softuni.Mobilele.repository.UserRepository;

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

    public void addOffer(AddOfferDTO addOfferDTO, UserDetails userDetails){
        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        UserEntity seller = userRepository
                .findByEmail(userDetails.getUsername())
                .orElseThrow();

        ModelEntity model = modelRepository
                .findById(addOfferDTO.getModelId())
                .orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);
    }

}
