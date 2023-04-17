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

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
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
