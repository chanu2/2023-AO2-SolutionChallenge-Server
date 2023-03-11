package gdsc.RunEatServer.domain.asset.dto;

import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import lombok.Getter;

@Getter
public class RandomFoodImageDto {
    private String url;
    private String foodName;


    public RandomFoodImageDto(FoodImage foodImage) {
        this.url = foodImage.getFoodImageUrl();
        this.foodName = foodImage.getFoodName();
    }
}
