package softuni.Mobilele.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import softuni.Mobilele.model.entity.OfferEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long>,
        JpaSpecificationExecutor<OfferEntity> {

}
