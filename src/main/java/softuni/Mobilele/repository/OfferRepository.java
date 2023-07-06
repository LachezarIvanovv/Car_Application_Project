package softuni.Mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.Mobilele.model.entity.OfferEntity;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {


    Optional<Object> findAllByModelNameContains(String query);
}
