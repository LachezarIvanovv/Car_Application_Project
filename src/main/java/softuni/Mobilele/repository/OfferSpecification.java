package softuni.Mobilele.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import softuni.Mobilele.model.dto.SearchOfferDTO;
import softuni.Mobilele.model.entity.OfferEntity;

public class OfferSpecification implements Specification<OfferEntity> {

    private final SearchOfferDTO searchOfferDTO;

    public OfferSpecification(SearchOfferDTO searchOfferDTO){
        this.searchOfferDTO = searchOfferDTO;
    }

    @Override
    public Predicate toPredicate(Root<OfferEntity> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.conjunction();

        if(searchOfferDTO.getModel() != null && !searchOfferDTO.getModel().isEmpty()){
            p.getExpressions().add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.join("model").get("name"), searchOfferDTO.getModel()))
            );
        }

        if(searchOfferDTO.getMinPrice() != null){
            p.getExpressions().add(
                    criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), searchOfferDTO.getMinPrice()))
            );
        }

        if(searchOfferDTO.getMaxPrice() != null){
            p.getExpressions().add(
                    criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("price"), searchOfferDTO.getMaxPrice()))
            );
        }

        return p;
    }
}
