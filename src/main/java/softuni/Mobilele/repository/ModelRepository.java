package softuni.Mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.Mobilele.model.entity.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
