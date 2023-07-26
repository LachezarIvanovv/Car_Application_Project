package bg.softuni.Mobilele.util;

import org.springframework.stereotype.Component;
import softuni.Mobilele.model.entity.*;
import softuni.Mobilele.model.enums.CategoryEnum;
import softuni.Mobilele.model.enums.EngineEnum;
import softuni.Mobilele.model.enums.TransmissionEnum;
import softuni.Mobilele.model.enums.UserRoleEnum;
import softuni.Mobilele.repository.*;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Component
public class TestDataUtils {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public TestDataUtils(UserRepository userRepository,
                         UserRoleRepository userRoleRepository,
                         OfferRepository offerRepository,
                         ModelRepository modelRepository,
                         BrandRepository brandRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    private void initRoles(){
        if(userRoleRepository.count() == 0){
            UserRoleEntity adminRole = new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setUserRole(UserRoleEnum.USER);

            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);
        }
    }

    public UserEntity createTestAdmin(String email){

        initRoles();

        var admin = new UserEntity()
                .setEmail(email)
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setActive(true)
                .setUserRoles(userRoleRepository.findAll());

        return userRepository.save(admin);
    }

    public UserEntity createTestUser(String email){

        initRoles();

        var user = new UserEntity()
                .setEmail(email)
                .setFirstName("User")
                .setLastName("Userov")
                .setActive(true)
                .setUserRoles(userRoleRepository
                        .findAll()
                        .stream()
                        .filter(r -> r.getUserRole() != UserRoleEnum.ADMIN)
                        .collect(Collectors.toList()));

        return userRepository.save(user);
    }

    public OfferEntity createTestOffer(UserEntity seller, ModelEntity model ){
        var offerEntity = new OfferEntity()
                .setEngine(EngineEnum.GASOLINE)
                .setMileage(10000)
                .setPrice(BigDecimal.TEN)
                .setDescription("Test description")
                .setTransmission(TransmissionEnum.MANUAL)
                .setYear(2000)
                .setModel(model)
                .setSeller(seller);

        return offerRepository.save(offerEntity);
    }

    public BrandEntity createTestBrand(){
        var brandEntity = new BrandEntity()
                .setName("Ford");

        return brandRepository.save(brandEntity);
    }

    public ModelEntity createTestModel(BrandEntity brandEntity){
        ModelEntity model = new ModelEntity()
                .setName("Fiesta")
                .setBrand(brandEntity)
                .setCategory(CategoryEnum.CAR)
                .setImageURL("http://image.com/image.png")
                .setStartYear(1978);

        return modelRepository.save(model);
    }

    public void cleanUpDatabase(){
        offerRepository.deleteAll();
        userRepository.deleteAll();
        userRoleRepository.deleteAll();
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }
}
