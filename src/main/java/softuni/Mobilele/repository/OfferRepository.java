package softuni.Mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.Mobilele.model.entity.OfferEntity;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {


}
