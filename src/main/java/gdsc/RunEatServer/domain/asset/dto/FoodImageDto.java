package gdsc.RunEatServer.domain.asset.dto;

import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import lombok.Getter;

@Getter
public class FoodImageDto {
    private String foodName;
    private Integer foodCalorie;
    private String foodImageUrl;


    public FoodImageDto(FoodImage foodImage) {
        this.foodName = foodImage.getFoodName();
        this.foodCalorie = foodImage.getFoodCalorie();
        this.foodImageUrl = foodImage.getFoodImageUrl();
    }
}
