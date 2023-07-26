package softuni.Mobilele.model.entity;

import jakarta.persistence.*;
import softuni.Mobilele.model.enums.CategoryEnum;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(STRING)
    @Column(nullable = false)
    private CategoryEnum category;

    @Column(nullable = false)
    private String imageURL;

    @Column(nullable = false)
    private Integer startYear;

    private Integer endYear;

    @ManyToOne
    private BrandEntity brand;


    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ModelEntity setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageURL='" + imageURL + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + (brand != null ? brand.getName() : null) +
                '}';
    }
}
