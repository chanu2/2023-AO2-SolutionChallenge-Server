package gdsc.RunEatServer.domain.asset.dto;

import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import lombok.Getter;

@Getter
public class FoodImageDto {
    private String url;
    private String foodName;

    public FoodImageDto(FoodImage foodImage) {
        this.url = foodImage.getFoodImageUrl();
        this.foodName = foodImage.getFoodName();
    }
}
