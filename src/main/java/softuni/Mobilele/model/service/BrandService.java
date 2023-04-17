package softuni.Mobilele.model.service;

import org.springframework.stereotype.Service;
import softuni.Mobilele.model.dto.BrandDTO;
import softuni.Mobilele.model.dto.ModelDTO;
import softuni.Mobilele.model.entity.BrandEntity;
import softuni.Mobilele.model.entity.ModelEntity;
import softuni.Mobilele.repository.BrandRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository){

        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands(){
        return brandRepository
                .findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDTO mapBrand(BrandEntity brandEntity){
        List<ModelDTO> models = brandEntity
                .getModels()
                .stream()
                .map(this::mapModel)
                .toList();

        return new BrandDTO()
                .setModels(models)
                .setName(brandEntity.getName());

    }

    private ModelDTO mapModel(ModelEntity modelEntity){
        return new ModelDTO()
                .setId(modelEntity.getId())
                .setName(modelEntity.getName());
    }
}
