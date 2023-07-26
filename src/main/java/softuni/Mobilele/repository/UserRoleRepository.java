package softuni.Mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.Mobilele.model.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
}
