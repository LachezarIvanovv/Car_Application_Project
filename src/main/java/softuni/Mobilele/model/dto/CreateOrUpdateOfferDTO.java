package softuni.Mobilele.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import softuni.Mobilele.model.enums.EngineEnum;
import softuni.Mobilele.model.enums.TransmissionEnum;

public class CreateOrUpdateOfferDTO {


    @NotNull
    @Min(1)
    private Long modelId;

    @NotNull
    private EngineEnum engine;

    @NotEmpty
    private String imageUrl;

    @Positive
    @NotNull
    private Integer price;

    @Min(1900)
    @NotNull
    private Integer year;

    @NotEmpty
    private String description;

    @NotNull
    private TransmissionEnum transmission;

    @Positive
    @NotNull
    private Integer mileage;


    public Long getModelId() {
        return modelId;
    }

    public CreateOrUpdateOfferDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public CreateOrUpdateOfferDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CreateOrUpdateOfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public Integer getPrice() {
        return price;
    }

    public CreateOrUpdateOfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CreateOrUpdateOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateOrUpdateOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateOrUpdateOfferDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public CreateOrUpdateOfferDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
